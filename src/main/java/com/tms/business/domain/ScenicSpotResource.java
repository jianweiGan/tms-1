package com.tms.business.domain;

import java.io.Serializable;
import java.util.Date;

public class ScenicSpotResource implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.data_id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private String dataId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.sourceUrl
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private String sourceurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.type
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private Integer type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.sort
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private Integer sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.create_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.modify_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column scenic_spot_resource.flag_delete
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private Integer flagDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table scenic_spot_resource
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.id
     *
     * @return the value of scenic_spot_resource.id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.id
     *
     * @param id the value for scenic_spot_resource.id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.data_id
     *
     * @return the value of scenic_spot_resource.data_id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public String getDataId() {
        return dataId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.data_id
     *
     * @param dataId the value for scenic_spot_resource.data_id
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setDataId(String dataId) {
        this.dataId = dataId == null ? null : dataId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.sourceUrl
     *
     * @return the value of scenic_spot_resource.sourceUrl
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public String getSourceurl() {
        return sourceurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.sourceUrl
     *
     * @param sourceurl the value for scenic_spot_resource.sourceUrl
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl == null ? null : sourceurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.type
     *
     * @return the value of scenic_spot_resource.type
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.type
     *
     * @param type the value for scenic_spot_resource.type
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.sort
     *
     * @return the value of scenic_spot_resource.sort
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.sort
     *
     * @param sort the value for scenic_spot_resource.sort
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.create_time
     *
     * @return the value of scenic_spot_resource.create_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.create_time
     *
     * @param createTime the value for scenic_spot_resource.create_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.modify_time
     *
     * @return the value of scenic_spot_resource.modify_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.modify_time
     *
     * @param modifyTime the value for scenic_spot_resource.modify_time
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column scenic_spot_resource.flag_delete
     *
     * @return the value of scenic_spot_resource.flag_delete
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public Integer getFlagDelete() {
        return flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column scenic_spot_resource.flag_delete
     *
     * @param flagDelete the value for scenic_spot_resource.flag_delete
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    public void setFlagDelete(Integer flagDelete) {
        this.flagDelete = flagDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenic_spot_resource
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
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
        ScenicSpotResource other = (ScenicSpotResource) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getDataId() == null ? other.getDataId() == null : this.getDataId().equals(other.getDataId()))
                && (this.getSourceurl() == null ? other.getSourceurl() == null : this.getSourceurl().equals(other.getSourceurl()))
                && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
                && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
                && (this.getFlagDelete() == null ? other.getFlagDelete() == null : this.getFlagDelete().equals(other.getFlagDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table scenic_spot_resource
     *
     * @mbggenerated Wed Oct 04 22:35:36 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataId() == null) ? 0 : getDataId().hashCode());
        result = prime * result + ((getSourceurl() == null) ? 0 : getSourceurl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getFlagDelete() == null) ? 0 : getFlagDelete().hashCode());
        return result;
    }
}