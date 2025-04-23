package com.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.SusheBaoxiuDao;
import com.entity.SusheBaoxiuEntity;
import com.entity.view.SusheBaoxiuView;
import com.service.SusheBaoxiuService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 宿舍 服务实现类
 */
@Service("susheBaoxiuService")
@Transactional
public class SusheBaoxiuServiceImpl extends ServiceImpl<SusheBaoxiuDao, SusheBaoxiuEntity> implements SusheBaoxiuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<SusheBaoxiuView> page =new Query<SusheBaoxiuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
