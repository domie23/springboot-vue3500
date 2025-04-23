package com.entity.view;

import com.entity.LaifangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 来访人员
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laifang")
public class LaifangView extends LaifangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 是否同意的值
		*/
		private String shifouValue;



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

	public LaifangView() {

	}

	public LaifangView(LaifangEntity laifangEntity) {
		try {
			BeanUtils.copyProperties(this, laifangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
			/**
			* 获取： 是否同意的值
			*/
			public String getShifouValue() {
				return shifouValue;
			}
			/**
			* 设置： 是否同意的值
			*/
			public void setShifouValue(String shifouValue) {
				this.shifouValue = shifouValue;
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
