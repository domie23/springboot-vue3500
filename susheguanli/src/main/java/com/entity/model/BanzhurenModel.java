package com.entity.model;

import com.entity.BanzhurenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 班主任
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BanzhurenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 班主任姓名
     */
    private String banzhurenName;


    /**
     * 班主任手机号
     */
    private String banzhurenPhone;


    /**
     * 电子邮箱
     */
    private String banzhurenEmail;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 班级
     */
    private Integer banjiTypes;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：班主任姓名
	 */
    public String getBanzhurenName() {
        return banzhurenName;
    }


    /**
	 * 设置：班主任姓名
	 */
    public void setBanzhurenName(String banzhurenName) {
        this.banzhurenName = banzhurenName;
    }
    /**
	 * 获取：班主任手机号
	 */
    public String getBanzhurenPhone() {
        return banzhurenPhone;
    }


    /**
	 * 设置：班主任手机号
	 */
    public void setBanzhurenPhone(String banzhurenPhone) {
        this.banzhurenPhone = banzhurenPhone;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getBanzhurenEmail() {
        return banzhurenEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setBanzhurenEmail(String banzhurenEmail) {
        this.banzhurenEmail = banzhurenEmail;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：班级
	 */
    public Integer getBanjiTypes() {
        return banjiTypes;
    }


    /**
	 * 设置：班级
	 */
    public void setBanjiTypes(Integer banjiTypes) {
        this.banjiTypes = banjiTypes;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
