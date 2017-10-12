package com.tms.business.domain;

import java.io.Serializable;
import java.util.Date;

public class CustomNotice implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.id
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.name
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.image_url
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String imageUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.content
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.subject
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String subject;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.consult_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String consultPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.complaint_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private String complaintPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.create_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.modify_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column custom_notice.flag_delete
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private Integer flagDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table custom_notice
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.id
     *
     * @return the value of custom_notice.id
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.id
     *
     * @param id the value for custom_notice.id
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.name
     *
     * @return the value of custom_notice.name
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.name
     *
     * @param name the value for custom_notice.name
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.image_url
     *
     * @return the value of custom_notice.image_url
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.image_url
     *
     * @param imageUrl the value for custom_notice.image_url
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.content
     *
     * @return the value of custom_notice.content
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.content
     *
     * @param content the value for custom_notice.content
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.subject
     *
     * @return the value of custom_notice.subject
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getSubject() {
        return subject;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.subject
     *
     * @param subject the value for custom_notice.subject
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.consult_phone
     *
     * @return the value of custom_notice.consult_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getConsultPhone() {
        return consultPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.consult_phone
     *
     * @param consultPhone the value for custom_notice.consult_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setConsultPhone(String consultPhone) {
        this.consultPhone = consultPhone == null ? null : consultPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.complaint_phone
     *
     * @return the value of custom_notice.complaint_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public String getComplaintPhone() {
        return complaintPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.complaint_phone
     *
     * @param complaintPhone the value for custom_notice.complaint_phone
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setComplaintPhone(String complaintPhone) {
        this.complaintPhone = complaintPhone == null ? null : complaintPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.create_time
     *
     * @return the value of custom_notice.create_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.create_time
     *
     * @param createTime the value for custom_notice.create_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.modify_time
     *
     * @return the value of custom_notice.modify_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.modify_time
     *
     * @param modifyTime the value for custom_notice.modify_time
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column custom_notice.flag_delete
     *
     * @return the value of custom_notice.flag_delete
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public Integer getFlagDelete() {
        return flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column custom_notice.flag_delete
     *
     * @param flagDelete the value for custom_notice.flag_delete
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
     */
    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom_notice
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
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
        CustomNotice other = (CustomNotice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
                && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
                && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
                && (this.getConsultPhone() == null ? other.getConsultPhone() == null : this.getConsultPhone().equals(other.getConsultPhone()))
                && (this.getComplaintPhone() == null ? other.getComplaintPhone() == null : this.getComplaintPhone().equals(other.getComplaintPhone()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
                && (this.getFlagDelete() == null ? other.getFlagDelete() == null : this.getFlagDelete().equals(other.getFlagDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table custom_notice
     *
     * @mbggenerated Thu Oct 12 19:49:08 CST 2017
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
        result = prime * result + ((getConsultPhone() == null) ? 0 : getConsultPhone().hashCode());
        result = prime * result + ((getComplaintPhone() == null) ? 0 : getComplaintPhone().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getFlagDelete() == null) ? 0 : getFlagDelete().hashCode());
        return result;
    }
}