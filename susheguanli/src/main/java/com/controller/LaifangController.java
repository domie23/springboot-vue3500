










package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 来访人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/laifang")
public class LaifangController {
    private static final Logger logger = LoggerFactory.getLogger(LaifangController.class);

    @Autowired
    private LaifangService laifangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private SusheService susheService;

    @Autowired
    private XueshengService xueshengService;
    @Autowired
    private SuguanService suguanService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("宿管".equals(role))
            params.put("suguanId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = laifangService.queryPage(params);

        //字典表数据转换
        List<LaifangView> list =(List<LaifangView>)page.getList();
        for(LaifangView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LaifangEntity laifang = laifangService.selectById(id);
        if(laifang !=null){
            //entity转view
            LaifangView view = new LaifangView();
            BeanUtils.copyProperties( laifang , view );//把实体数据重构到view中

                //级联表
                SusheEntity sushe = susheService.selectById(laifang.getSusheId());
                if(sushe != null){
                    BeanUtils.copyProperties( sushe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheId(sushe.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LaifangEntity laifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,laifang:{}",this.getClass().getName(),laifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<LaifangEntity> queryWrapper = new EntityWrapper<LaifangEntity>()
            .eq("sushe_id", laifang.getSusheId())
            .eq("laifang_name", laifang.getLaifangName())
            .eq("laifang_phone", laifang.getLaifangPhone())
            .eq("laifang_id_number", laifang.getLaifangIdNumber())
            .eq("sex_types", laifang.getSexTypes())
            .eq("shifou_types", laifang.getShifouTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaifangEntity laifangEntity = laifangService.selectOne(queryWrapper);
        if(laifangEntity==null){
            laifang.setInsertTime(new Date());
            laifang.setCreateTime(new Date());
            laifangService.insert(laifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LaifangEntity laifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,laifang:{}",this.getClass().getName(),laifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<LaifangEntity> queryWrapper = new EntityWrapper<LaifangEntity>()
            .notIn("id",laifang.getId())
            .andNew()
            .eq("sushe_id", laifang.getSusheId())
            .eq("laifang_name", laifang.getLaifangName())
            .eq("laifang_phone", laifang.getLaifangPhone())
            .eq("laifang_id_number", laifang.getLaifangIdNumber())
            .eq("sex_types", laifang.getSexTypes())
            .eq("shifou_types", laifang.getShifouTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LaifangEntity laifangEntity = laifangService.selectOne(queryWrapper);
        if("".equals(laifang.getLaifangPhoto()) || "null".equals(laifang.getLaifangPhoto())){
                laifang.setLaifangPhoto(null);
        }
        if(laifangEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      laifang.set
            //  }
            laifangService.updateById(laifang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        laifangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<LaifangEntity> laifangList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LaifangEntity laifangEntity = new LaifangEntity();
//                            laifangEntity.setSusheId(Integer.valueOf(data.get(0)));   //访问宿舍 要改的
//                            laifangEntity.setLaifangName(data.get(0));                    //来访人姓名 要改的
//                            laifangEntity.setLaifangPhone(data.get(0));                    //来访人手机号 要改的
//                            laifangEntity.setLaifangIdNumber(data.get(0));                    //来访人身份证号 要改的
//                            laifangEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            laifangEntity.setLaifangPhoto("");//照片
//                            laifangEntity.setShifouTypes(Integer.valueOf(data.get(0)));   //是否同意 要改的
//                            laifangEntity.setLaifangContent("");//照片
//                            laifangEntity.setInsertTime(date);//时间
//                            laifangEntity.setLikaiTime(new Date(data.get(0)));          //离开时间 要改的
//                            laifangEntity.setCreateTime(date);//时间
                            laifangList.add(laifangEntity);


                            //把要查询是否重复的字段放入map中
                                //来访人手机号
                                if(seachFields.containsKey("laifangPhone")){
                                    List<String> laifangPhone = seachFields.get("laifangPhone");
                                    laifangPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> laifangPhone = new ArrayList<>();
                                    laifangPhone.add(data.get(0));//要改的
                                    seachFields.put("laifangPhone",laifangPhone);
                                }
                                //来访人身份证号
                                if(seachFields.containsKey("laifangIdNumber")){
                                    List<String> laifangIdNumber = seachFields.get("laifangIdNumber");
                                    laifangIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> laifangIdNumber = new ArrayList<>();
                                    laifangIdNumber.add(data.get(0));//要改的
                                    seachFields.put("laifangIdNumber",laifangIdNumber);
                                }
                        }

                        //查询是否重复
                         //来访人手机号
                        List<LaifangEntity> laifangEntities_laifangPhone = laifangService.selectList(new EntityWrapper<LaifangEntity>().in("laifang_phone", seachFields.get("laifangPhone")));
                        if(laifangEntities_laifangPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaifangEntity s:laifangEntities_laifangPhone){
                                repeatFields.add(s.getLaifangPhone());
                            }
                            return R.error(511,"数据库的该表中的 [来访人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //来访人身份证号
                        List<LaifangEntity> laifangEntities_laifangIdNumber = laifangService.selectList(new EntityWrapper<LaifangEntity>().in("laifang_id_number", seachFields.get("laifangIdNumber")));
                        if(laifangEntities_laifangIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LaifangEntity s:laifangEntities_laifangIdNumber){
                                repeatFields.add(s.getLaifangIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [来访人身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        laifangService.insertBatch(laifangList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
