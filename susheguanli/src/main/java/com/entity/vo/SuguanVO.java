package com.entity.vo;

import com.entity.SuguanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宿管
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("suguan")
public class SuguanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 宿管姓名
     */

    @TableField(value = "suguan_name")
    private String suguanName;


    /**
     * 宿管手机号
     */

    @TableField(value = "suguan_phone")
    private String suguanPhone;


    /**
     * 电子邮箱
     */

    @TableField(value = "suguan_email")
    private String suguanEmail;


    /**
     * 楼栋
     */

    @TableField(value = "loudong_types")
    private Integer loudongTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：宿管姓名
	 */
    public String getSuguanName() {
        return suguanName;
    }


    /**
	 * 获取：宿管姓名
	 */

    public void setSuguanName(String suguanName) {
        this.suguanName = suguanName;
    }
    /**
	 * 设置：宿管手机号
	 */
    public String getSuguanPhone() {
        return suguanPhone;
    }


    /**
	 * 获取：宿管手机号
	 */

    public void setSuguanPhone(String suguanPhone) {
        this.suguanPhone = suguanPhone;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getSuguanEmail() {
        return suguanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setSuguanEmail(String suguanEmail) {
        this.suguanEmail = suguanEmail;
    }
    /**
	 * 设置：楼栋
	 */
    public Integer getLoudongTypes() {
        return loudongTypes;
    }


    /**
	 * 获取：楼栋
	 */

    public void setLoudongTypes(Integer loudongTypes) {
        this.loudongTypes = loudongTypes;
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
