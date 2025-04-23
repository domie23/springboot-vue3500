package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 宿舍
 *
 * @author 
 * @email
 */
@TableName("sushe_baoxiu")
public class SusheBaoxiuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SusheBaoxiuEntity() {

	}

	public SusheBaoxiuEntity(T t) {
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
     * 宿舍
     */
    @TableField(value = "sushe_id")

    private Integer susheId;


    /**
     * 学生
     */
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 报修编号
     */
    @TableField(value = "sushe_baoxiu_uuid_number")

    private String susheBaoxiuUuidNumber;


    /**
     * 报修名称
     */
    @TableField(value = "sushe_baoxiu_name")

    private String susheBaoxiuName;


    /**
     * 报修物品
     */
    @TableField(value = "sushe_baoxiu_wupin_name")

    private String susheBaoxiuWupinName;


    /**
     * 报修详情
     */
    @TableField(value = "sushe_baoxiu_content")

    private String susheBaoxiuContent;


    /**
     * 报修时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 报修状态
     */
    @TableField(value = "sushe_baoxiu_types")

    private Integer susheBaoxiuTypes;


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
	 * 设置：宿舍
	 */
    public Integer getSusheId() {
        return susheId;
    }
    /**
	 * 获取：宿舍
	 */

    public void setSusheId(Integer susheId) {
        this.susheId = susheId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 获取：学生
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：报修编号
	 */
    public String getSusheBaoxiuUuidNumber() {
        return susheBaoxiuUuidNumber;
    }
    /**
	 * 获取：报修编号
	 */

    public void setSusheBaoxiuUuidNumber(String susheBaoxiuUuidNumber) {
        this.susheBaoxiuUuidNumber = susheBaoxiuUuidNumber;
    }
    /**
	 * 设置：报修名称
	 */
    public String getSusheBaoxiuName() {
        return susheBaoxiuName;
    }
    /**
	 * 获取：报修名称
	 */

    public void setSusheBaoxiuName(String susheBaoxiuName) {
        this.susheBaoxiuName = susheBaoxiuName;
    }
    /**
	 * 设置：报修物品
	 */
    public String getSusheBaoxiuWupinName() {
        return susheBaoxiuWupinName;
    }
    /**
	 * 获取：报修物品
	 */

    public void setSusheBaoxiuWupinName(String susheBaoxiuWupinName) {
        this.susheBaoxiuWupinName = susheBaoxiuWupinName;
    }
    /**
	 * 设置：报修详情
	 */
    public String getSusheBaoxiuContent() {
        return susheBaoxiuContent;
    }
    /**
	 * 获取：报修详情
	 */

    public void setSusheBaoxiuContent(String susheBaoxiuContent) {
        this.susheBaoxiuContent = susheBaoxiuContent;
    }
    /**
	 * 设置：报修时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：报修时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：报修状态
	 */
    public Integer getSusheBaoxiuTypes() {
        return susheBaoxiuTypes;
    }
    /**
	 * 获取：报修状态
	 */

    public void setSusheBaoxiuTypes(Integer susheBaoxiuTypes) {
        this.susheBaoxiuTypes = susheBaoxiuTypes;
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
        return "SusheBaoxiu{" +
            "id=" + id +
            ", susheId=" + susheId +
            ", xueshengId=" + xueshengId +
            ", susheBaoxiuUuidNumber=" + susheBaoxiuUuidNumber +
            ", susheBaoxiuName=" + susheBaoxiuName +
            ", susheBaoxiuWupinName=" + susheBaoxiuWupinName +
            ", susheBaoxiuContent=" + susheBaoxiuContent +
            ", insertTime=" + insertTime +
            ", susheBaoxiuTypes=" + susheBaoxiuTypes +
            ", createTime=" + createTime +
        "}";
    }
}
