package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.SusheBaoxiuEntity;
import com.entity.view.SusheBaoxiuView;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 宿舍 Dao 接口
 *
 * @author 
 */
public interface SusheBaoxiuDao extends BaseMapper<SusheBaoxiuEntity> {

   List<SusheBaoxiuView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
