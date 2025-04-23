
package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.SuguanEntity;
import com.entity.SusheBaoxiuEntity;
import com.entity.SusheEntity;
import com.entity.XueshengEntity;
import com.entity.view.SusheBaoxiuView;
import com.service.*;
import com.utils.PageUtils;
import com.utils.PoiUtil;
import com.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 宿舍报修
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/susheBaoxiu")
public class SusheBaoxiuController {
    private static final Logger logger = LoggerFactory.getLogger(SusheBaoxiuController.class);

    @Autowired
    private SusheBaoxiuService susheBaoxiuService;


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
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("宿管".equals(role)){

            SuguanEntity suguanEntity = suguanService.selectById(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            if(suguanEntity == null)
                return R.error("宿管查不到");
            params.put("suguanId",suguanEntity.getId());
            params.put("loudongTypes",suguanEntity.getLoudongTypes());
        }
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = susheBaoxiuService.queryPage(params);

        //字典表数据转换
        List<SusheBaoxiuView> list =(List<SusheBaoxiuView>)page.getList();
        for(SusheBaoxiuView c:list){
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
        SusheBaoxiuEntity susheBaoxiu = susheBaoxiuService.selectById(id);
        if(susheBaoxiu !=null){
            //entity转view
            SusheBaoxiuView view = new SusheBaoxiuView();
            BeanUtils.copyProperties( susheBaoxiu , view );//把实体数据重构到view中

                //级联表
                SusheEntity sushe = susheService.selectById(susheBaoxiu.getSusheId());
                if(sushe != null){
                    BeanUtils.copyProperties( sushe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSusheId(sushe.getId());
                }
                //级联表
                XueshengEntity xuesheng = xueshengService.selectById(susheBaoxiu.getXueshengId());
                if(xuesheng != null){
                    BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXueshengId(xuesheng.getId());
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
    public R save(@RequestBody SusheBaoxiuEntity susheBaoxiu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,susheBaoxiu:{}",this.getClass().getName(),susheBaoxiu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role)){
            susheBaoxiu.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            susheBaoxiu.setSusheBaoxiuTypes(1);
        }

            susheBaoxiu.setInsertTime(new Date());
            susheBaoxiu.setCreateTime(new Date());
            susheBaoxiuService.insert(susheBaoxiu);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SusheBaoxiuEntity susheBaoxiu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,susheBaoxiu:{}",this.getClass().getName(),susheBaoxiu.toString());

            susheBaoxiuService.updateById(susheBaoxiu);//根据id更新
            return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        susheBaoxiuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save(String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<SusheBaoxiuEntity> susheBaoxiuList = new ArrayList<>();//上传的东西
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
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SusheBaoxiuEntity susheBaoxiuEntity = new SusheBaoxiuEntity();
//                            susheBaoxiuEntity.setSusheId(Integer.valueOf(data.get(0)));   //宿舍 要改的
//                            susheBaoxiuEntity.setXueshengId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            susheBaoxiuEntity.setSusheBaoxiuUuidNumber(data.get(0));                    //报修编号 要改的
//                            susheBaoxiuEntity.setSusheBaoxiuName(data.get(0));                    //报修名称 要改的
//                            susheBaoxiuEntity.setSusheBaoxiuWupinName(data.get(0));                    //报修物品 要改的
//                            susheBaoxiuEntity.setSusheBaoxiuContent("");//详情和图片
//                            susheBaoxiuEntity.setInsertTime(date);//时间
//                            susheBaoxiuEntity.setSusheBaoxiuTypes(Integer.valueOf(data.get(0)));   //报修状态 要改的
//                            susheBaoxiuEntity.setCreateTime(date);//时间
                            susheBaoxiuList.add(susheBaoxiuEntity);


                            //把要查询是否重复的字段放入map中
                                //报修编号
                                if(seachFields.containsKey("susheBaoxiuUuidNumber")){
                                    List<String> susheBaoxiuUuidNumber = seachFields.get("susheBaoxiuUuidNumber");
                                    susheBaoxiuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> susheBaoxiuUuidNumber = new ArrayList<>();
                                    susheBaoxiuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("susheBaoxiuUuidNumber",susheBaoxiuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报修编号
                        List<SusheBaoxiuEntity> susheBaoxiuEntities_susheBaoxiuUuidNumber = susheBaoxiuService.selectList(new EntityWrapper<SusheBaoxiuEntity>().in("sushe_baoxiu_uuid_number", seachFields.get("susheBaoxiuUuidNumber")));
                        if(susheBaoxiuEntities_susheBaoxiuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(SusheBaoxiuEntity s:susheBaoxiuEntities_susheBaoxiuUuidNumber){
                                repeatFields.add(s.getSusheBaoxiuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报修编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        susheBaoxiuService.insertBatch(susheBaoxiuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
