package com.tms.business.domain;

import java.io.Serializable;
import java.util.Date;

public class TmsLegend implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.id
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.name
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.image_url
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private String imageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.content
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.subject
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private String subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.create_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.modify_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tms_legend.flag_delete
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private Integer flagDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table tms_legend
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.id
     *
     * @return the value of tms_legend.id
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.id
     *
     * @param id the value for tms_legend.id
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.name
     *
     * @return the value of tms_legend.name
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.name
     *
     * @param name the value for tms_legend.name
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.image_url
     *
     * @return the value of tms_legend.image_url
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.image_url
     *
     * @param imageUrl the value for tms_legend.image_url
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.content
     *
     * @return the value of tms_legend.content
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.content
     *
     * @param content the value for tms_legend.content
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.subject
     *
     * @return the value of tms_legend.subject
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.subject
     *
     * @param subject the value for tms_legend.subject
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.create_time
     *
     * @return the value of tms_legend.create_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.create_time
     *
     * @param createTime the value for tms_legend.create_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.modify_time
     *
     * @return the value of tms_legend.modify_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.modify_time
     *
     * @param modifyTime the value for tms_legend.modify_time
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tms_legend.flag_delete
     *
     * @return the value of tms_legend.flag_delete
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public Integer getFlagDelete() {
        return flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tms_legend.flag_delete
     *
     * @param flagDelete the value for tms_legend.flag_delete
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tms_legend
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
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
        TmsLegend other = (TmsLegend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getFlagDelete() == null ? other.getFlagDelete() == null : this.getFlagDelete().equals(other.getFlagDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tms_legend
     *
     * @mbggenerated Sat Oct 07 10:09:54 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getFlagDelete() == null) ? 0 : getFlagDelete().hashCode());
        return result;
    }
}