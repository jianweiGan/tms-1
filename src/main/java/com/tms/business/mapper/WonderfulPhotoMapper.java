package com.tms.business.mapper;

import com.github.pagehelper.Page;
import com.tms.business.domain.WonderfulPhoto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WonderfulPhotoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    int insert(WonderfulPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    int insertSelective(WonderfulPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    WonderfulPhoto selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    int updateByPrimaryKeySelective(WonderfulPhoto record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table wonderful_photo
     *
     * @mbggenerated Fri Oct 13 21:30:27 CST 2017
     */
    int updateByPrimaryKey(WonderfulPhoto record);

    Page<WonderfulPhoto> selectList(@Param("type") Integer type, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    Page<WonderfulPhoto> selectWonderfulPhotoList(@Param("type") Integer type);

}