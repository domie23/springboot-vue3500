package com.entity.model;

import com.entity.LaifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 来访人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaifangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 访问宿舍
     */
    private Integer susheId;


    /**
     * 来访人姓名
     */
    private String laifangName;


    /**
     * 来访人手机号
     */
    private String laifangPhone;


    /**
     * 来访人身份证号
     */
    private String laifangIdNumber;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 健康码
     */
    private String laifangPhoto;


    /**
     * 是否同意
     */
    private Integer shifouTypes;


    /**
     * 来访事由
     */
    private String laifangContent;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date likaiTime;


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
	 * 获取：访问宿舍
	 */
    public Integer getSusheId() {
        return susheId;
    }


    /**
	 * 设置：访问宿舍
	 */
    public void setSusheId(Integer susheId) {
        this.susheId = susheId;
    }
    /**
	 * 获取：来访人姓名
	 */
    public String getLaifangName() {
        return laifangName;
    }


    /**
	 * 设置：来访人姓名
	 */
    public void setLaifangName(String laifangName) {
        this.laifangName = laifangName;
    }
    /**
	 * 获取：来访人手机号
	 */
    public String getLaifangPhone() {
        return laifangPhone;
    }


    /**
	 * 设置：来访人手机号
	 */
    public void setLaifangPhone(String laifangPhone) {
        this.laifangPhone = laifangPhone;
    }
    /**
	 * 获取：来访人身份证号
	 */
    public String getLaifangIdNumber() {
        return laifangIdNumber;
    }


    /**
	 * 设置：来访人身份证号
	 */
    public void setLaifangIdNumber(String laifangIdNumber) {
        this.laifangIdNumber = laifangIdNumber;
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
	 * 获取：健康码
	 */
    public String getLaifangPhoto() {
        return laifangPhoto;
    }


    /**
	 * 设置：健康码
	 */
    public void setLaifangPhoto(String laifangPhoto) {
        this.laifangPhoto = laifangPhoto;
    }
    /**
	 * 获取：是否同意
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 设置：是否同意
	 */
    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 获取：来访事由
	 */
    public String getLaifangContent() {
        return laifangContent;
    }


    /**
	 * 设置：来访事由
	 */
    public void setLaifangContent(String laifangContent) {
        this.laifangContent = laifangContent;
    }
    /**
	 * 获取：来访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：来访时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：离开时间
	 */
    public Date getLikaiTime() {
        return likaiTime;
    }


    /**
	 * 设置：离开时间
	 */
    public void setLikaiTime(Date likaiTime) {
        this.likaiTime = likaiTime;
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
