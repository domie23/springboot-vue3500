package com.entity.view;

import com.entity.WeishengEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 卫生
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("weisheng")
public class WeishengView extends WeishengEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 sushe
			/**
			* 宿舍名
			*/
			private String susheName;
			/**
			* 楼栋
			*/
			private Integer loudongTypes;
				/**
				* 楼栋的值
				*/
				private String loudongValue;

	public WeishengView() {

	}

	public WeishengView(WeishengEntity weishengEntity) {
		try {
			BeanUtils.copyProperties(this, weishengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















				//级联表的get和set sushe
					/**
					* 获取： 宿舍名
					*/
					public String getSusheName() {
						return susheName;
					}
					/**
					* 设置： 宿舍名
					*/
					public void setSusheName(String susheName) {
						this.susheName = susheName;
					}
					/**
					* 获取： 楼栋
					*/
					public Integer getLoudongTypes() {
						return loudongTypes;
					}
					/**
					* 设置： 楼栋
					*/
					public void setLoudongTypes(Integer loudongTypes) {
						this.loudongTypes = loudongTypes;
					}


						/**
						* 获取： 楼栋的值
						*/
						public String getLoudongValue() {
							return loudongValue;
						}
						/**
						* 设置： 楼栋的值
						*/
						public void setLoudongValue(String loudongValue) {
							this.loudongValue = loudongValue;
						}






}
