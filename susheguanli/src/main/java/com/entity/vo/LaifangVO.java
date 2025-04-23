package com.entity.vo;

import com.entity.LaifangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 来访人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("laifang")
public class LaifangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 访问宿舍
     */

    @TableField(value = "sushe_id")
    private Integer susheId;


    /**
     * 来访人姓名
     */

    @TableField(value = "laifang_name")
    private String laifangName;


    /**
     * 来访人手机号
     */

    @TableField(value = "laifang_phone")
    private String laifangPhone;


    /**
     * 来访人身份证号
     */

    @TableField(value = "laifang_id_number")
    private String laifangIdNumber;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 健康码
     */

    @TableField(value = "laifang_photo")
    private String laifangPhoto;


    /**
     * 是否同意
     */

    @TableField(value = "shifou_types")
    private Integer shifouTypes;


    /**
     * 来访事由
     */

    @TableField(value = "laifang_content")
    private String laifangContent;


    /**
     * 来访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 离开时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "likai_time")
    private Date likaiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：访问宿舍
	 */
    public Integer getSusheId() {
        return susheId;
    }


    /**
	 * 获取：访问宿舍
	 */

    public void setSusheId(Integer susheId) {
        this.susheId = susheId;
    }
    /**
	 * 设置：来访人姓名
	 */
    public String getLaifangName() {
        return laifangName;
    }


    /**
	 * 获取：来访人姓名
	 */

    public void setLaifangName(String laifangName) {
        this.laifangName = laifangName;
    }
    /**
	 * 设置：来访人手机号
	 */
    public String getLaifangPhone() {
        return laifangPhone;
    }


    /**
	 * 获取：来访人手机号
	 */

    public void setLaifangPhone(String laifangPhone) {
        this.laifangPhone = laifangPhone;
    }
    /**
	 * 设置：来访人身份证号
	 */
    public String getLaifangIdNumber() {
        return laifangIdNumber;
    }


    /**
	 * 获取：来访人身份证号
	 */

    public void setLaifangIdNumber(String laifangIdNumber) {
        this.laifangIdNumber = laifangIdNumber;
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
	 * 设置：健康码
	 */
    public String getLaifangPhoto() {
        return laifangPhoto;
    }


    /**
	 * 获取：健康码
	 */

    public void setLaifangPhoto(String laifangPhoto) {
        this.laifangPhoto = laifangPhoto;
    }
    /**
	 * 设置：是否同意
	 */
    public Integer getShifouTypes() {
        return shifouTypes;
    }


    /**
	 * 获取：是否同意
	 */

    public void setShifouTypes(Integer shifouTypes) {
        this.shifouTypes = shifouTypes;
    }
    /**
	 * 设置：来访事由
	 */
    public String getLaifangContent() {
        return laifangContent;
    }


    /**
	 * 获取：来访事由
	 */

    public void setLaifangContent(String laifangContent) {
        this.laifangContent = laifangContent;
    }
    /**
	 * 设置：来访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：来访时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：离开时间
	 */
    public Date getLikaiTime() {
        return likaiTime;
    }


    /**
	 * 获取：离开时间
	 */

    public void setLikaiTime(Date likaiTime) {
        this.likaiTime = likaiTime;
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

}
