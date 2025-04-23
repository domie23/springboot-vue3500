package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.SusheBaoxiuEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 宿舍
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("sushe_baoxiu")
public class SusheBaoxiuView extends SusheBaoxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报修状态的值
		*/
		private String susheBaoxiuValue;



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

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;
			/**
			* QQ号
			*/
			private String xueshengQq;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;
			/**
			* 班级
			*/
			private Integer banjiTypes;
				/**
				* 班级的值
				*/
				private String banjiValue;

	public SusheBaoxiuView() {

	}

	public SusheBaoxiuView(SusheBaoxiuEntity susheBaoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, susheBaoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 报修状态的值
			*/
			public String getSusheBaoxiuValue() {
				return susheBaoxiuValue;
			}
			/**
			* 设置： 报修状态的值
			*/
			public void setSusheBaoxiuValue(String susheBaoxiuValue) {
				this.susheBaoxiuValue = susheBaoxiuValue;
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










				//级联表的get和set xuesheng


					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}

					/**
					* 获取： QQ号
					*/
					public String getXueshengQq() {
						return xueshengQq;
					}
					/**
					* 设置： QQ号
					*/
					public void setXueshengQq(String xueshengQq) {
						this.xueshengQq = xueshengQq;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
						}

					/**
					* 获取： 班级
					*/
					public Integer getBanjiTypes() {
						return banjiTypes;
					}
					/**
					* 设置： 班级
					*/
					public void setBanjiTypes(Integer banjiTypes) {
						this.banjiTypes = banjiTypes;
					}


						/**
						* 获取： 班级的值
						*/
						public String getBanjiValue() {
							return banjiValue;
						}
						/**
						* 设置： 班级的值
						*/
						public void setBanjiValue(String banjiValue) {
							this.banjiValue = banjiValue;
						}






}
