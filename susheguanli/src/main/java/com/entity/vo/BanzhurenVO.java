package com.entity.vo;

import com.entity.BanzhurenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 班主任
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("banzhuren")
public class BanzhurenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


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

}
