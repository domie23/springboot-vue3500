










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
 * 卫生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/weisheng")
public class WeishengController {
    private static final Logger logger = LoggerFactory.getLogger(WeishengController.class);

    @Autowired
    private WeishengService weishengService;


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
//        if(StringUtils.isNotEmpty(String.valueOf(params.get("insertTimeStart"))) || StringUtils.isNotEmpty(String.valueOf(params.get("insertTimeEnd"))) ){
////            params.put("orderBy","jifenjilu_number");
////        }else if(params.get("orderBy")==null || params.get("orderBy")==""){
////            params.put("orderBy","id");
////        }
        PageUtils page = weishengService.queryPage(params);

        //字典表数据转换
        List<WeishengView> list =(List<WeishengView>)page.getList();
        for(WeishengView c:list){
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
        WeishengEntity weisheng = weishengService.selectById(id);
        if(weisheng !=null){
            //entity转view
            WeishengView view = new WeishengView();
            BeanUtils.copyProperties( weisheng , view );//把实体数据重构到view中

                //级联表
                SusheEntity sushe = susheService.selectById(weisheng.getSusheId());
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
    public R save(@RequestBody WeishengEntity weisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,weisheng:{}",this.getClass().getName(),weisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");

        Wrapper<WeishengEntity> queryWrapper = new EntityWrapper<WeishengEntity>()
            .eq("sushe_id", weisheng.getSusheId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeishengEntity weishengEntity = weishengService.selectOne(queryWrapper);
        if(weishengEntity==null){
            weisheng.setInsertTime(new Date());
            weisheng.setCreateTime(new Date());
            weishengService.insert(weisheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WeishengEntity weisheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,weisheng:{}",this.getClass().getName(),weisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<WeishengEntity> queryWrapper = new EntityWrapper<WeishengEntity>()
            .notIn("id",weisheng.getId())
            .andNew()
            .eq("sushe_id", weisheng.getSusheId())
            .eq("insert_time", new SimpleDateFormat("yyyy-MM-dd").format(weisheng.getInsertTime()))
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WeishengEntity weishengEntity = weishengService.selectOne(queryWrapper);
        if(weishengEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      weisheng.set
            //  }
            weishengService.updateById(weisheng);//根据id更新
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
        weishengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<WeishengEntity> weishengList = new ArrayList<>();//上传的东西
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
                            WeishengEntity weishengEntity = new WeishengEntity();
//                            weishengEntity.setSusheId(Integer.valueOf(data.get(0)));   //宿舍 要改的
//                            weishengEntity.setInsertTime(date);//时间
//                            weishengEntity.setJifenjiluNumber(data.get(0));                    //得分 要改的
//                            weishengEntity.setCreateTime(date);//时间
                            weishengList.add(weishengEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        weishengService.insertBatch(weishengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





}
