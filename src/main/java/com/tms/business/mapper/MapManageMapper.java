package com.tms.business.mapper;

import com.github.pagehelper.Page;
import com.tms.business.domain.MapManage;
import org.springframework.stereotype.Repository;

@Repository
public interface MapManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    int insert(MapManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    int insertSelective(MapManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    MapManage selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    int updateByPrimaryKeySelective(MapManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table map_manage
     *
     * @mbggenerated Sat Oct 14 22:20:12 CST 2017
     */
    int updateByPrimaryKey(MapManage record);

    Page<MapManage> selectList(MapManage mapManage);

    void setNotDefault();

}