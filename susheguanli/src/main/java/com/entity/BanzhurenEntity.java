package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 班主任
 *
 * @author 
 * @email
 */
@TableName("banzhuren")
public class BanzhurenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BanzhurenEntity() {

	}

	public BanzhurenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 班主任姓名
     */
    @TableField(value = "banzhuren_name")

    private String banzhurenName;


    /**
     * 班主任手机号
     */
    @TableField(value = "banzhuren_phone")

    private String banzhurenPhone;


    /**
     * 电子邮箱
     */
    @TableField(value = "banzhuren_email")

    private String banzhurenEmail;


    /**
     * 性别
     */
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 班级
     */
    @TableField(value = "banji_types")

    private Integer banjiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：班主任姓名
	 */
    public String getBanzhurenName() {
        return banzhurenName;
    }


    /**
	 * 获取：班主任姓名
	 */

    public void setBanzhurenName(String banzhurenName) {
        this.banzhurenName = banzhurenName;
    }
    /**
	 * 设置：班主任手机号
	 */
    public String getBanzhurenPhone() {
        return banzhurenPhone;
    }


    /**
	 * 获取：班主任手机号
	 */

    public void setBanzhurenPhone(String banzhurenPhone) {
        this.banzhurenPhone = banzhurenPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getBanzhurenEmail() {
        return banzhurenEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setBanzhurenEmail(String banzhurenEmail) {
        this.banzhurenEmail = banzhurenEmail;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }


    /**
	 * 获取：班级
	 */

    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Banzhuren{" +
            "id=" + id +
            ", banzhurenName=" + banzhurenName +
            ", banzhurenPhone=" + banzhurenPhone +
            ", banzhurenEmail=" + banzhurenEmail +
            ", sexTypes=" + sexTypes +
            ", banjiTypes=" + banjiTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
