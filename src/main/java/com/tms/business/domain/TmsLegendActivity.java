package com.tms.business.domain;

import java.io.Serializable;
import java.util.Date;

public class TmsLegendActivity implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.id
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.name
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.type
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.image_url
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private String imageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.start_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Date startTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.end_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Date endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.content
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.create_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.modify_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.flag_delete
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private Integer flagDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend_activity.detail
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private String detail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tms_legend_activity
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.id
     *
     * @return the value of tms_legend_activity.id
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.id
     *
     * @param id the value for tms_legend_activity.id
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.name
     *
     * @return the value of tms_legend_activity.name
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.name
     *
     * @param name the value for tms_legend_activity.name
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.type
     *
     * @return the value of tms_legend_activity.type
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.type
     *
     * @param type the value for tms_legend_activity.type
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.image_url
     *
     * @return the value of tms_legend_activity.image_url
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.image_url
     *
     * @param imageUrl the value for tms_legend_activity.image_url
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.start_time
     *
     * @return the value of tms_legend_activity.start_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.start_time
     *
     * @param startTime the value for tms_legend_activity.start_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.end_time
     *
     * @return the value of tms_legend_activity.end_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.end_time
     *
     * @param endTime the value for tms_legend_activity.end_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.content
     *
     * @return the value of tms_legend_activity.content
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.content
     *
     * @param content the value for tms_legend_activity.content
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.create_time
     *
     * @return the value of tms_legend_activity.create_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.create_time
     *
     * @param createTime the value for tms_legend_activity.create_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.modify_time
     *
     * @return the value of tms_legend_activity.modify_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.modify_time
     *
     * @param modifyTime the value for tms_legend_activity.modify_time
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.flag_delete
     *
     * @return the value of tms_legend_activity.flag_delete
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public Integer getFlagDelete() {
        return flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.flag_delete
     *
     * @param flagDelete the value for tms_legend_activity.flag_delete
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend_activity.detail
     *
     * @return the value of tms_legend_activity.detail
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend_activity.detail
     *
     * @param detail the value for tms_legend_activity.detail
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tms_legend_activity
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TmsLegendActivity other = (TmsLegendActivity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
                && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
                && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
                && (this.getFlagDelete() == null ? other.getFlagDelete() == null : this.getFlagDelete().equals(other.getFlagDelete()))
                && (this.getDetail() == null ? other.getDetail() == null : this.getDetail().equals(other.getDetail()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tms_legend_activity
     *
     * @mbggenerated Tue Oct 17 09:37:57 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getFlagDelete() == null) ? 0 : getFlagDelete().hashCode());
        result = prime * result + ((getDetail() == null) ? 0 : getDetail().hashCode());
        return result;
    }
}