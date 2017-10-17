package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.HomePageModuleService;
import com.tms.business.bus.service.MapManageService;
import com.tms.business.domain.HomePageModule;
import com.tms.business.domain.MapManage;
import com.tms.business.mapper.HomePageModuleMapper;
import com.tms.business.mapper.MapManageMapper;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import com.tms.common.helper.JOHelper;
import com.tms.common.helper.UUIDHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.Map;

/**
 * Created by xiongzhanyuan on 2017/2/21.
 */
@Transactional
@Service(value = "service/map/operate")
public class MapManageServiceImpl implements MapManageService {

    @Autowired
    private MapManageMapper mapManageMapper;

    @Override
    public JSONObject getMapeInfo(String id) throws Exception {

        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        MapManage mapManage = mapManageMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(mapManage)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(mapManage);

        return jsonObject;
    }

    @Override
    public JSONObject selectMapList(JSONObject param) throws Exception {

        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        MapManage mapManage = new MapManage();

        Page<MapManage> page = mapManageMapper.selectList(mapManage);

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject addMap(JSONObject param) throws Exception {

        MapManage mapManage = JOHelper.jo2class(param, MapManage.class);
        mapManage.setId(UUIDHelper.getUUID());
        mapManage.setCreateTime(new Date());
        mapManage.setModifyTime(new Date());
        mapManage.setFlagDelete(0);
        mapManageMapper.insert(mapManage);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateMap(JSONObject param) throws Exception {

        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        MapManage mapManage = JOHelper.jo2class(param, MapManage.class);
        mapManage.setModifyTime(new Date());

        mapManageMapper.updateByPrimaryKey(mapManage);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteMap(JSONObject param) throws Exception {
        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        MapManage mapManage = new MapManage();
        mapManage.setId(id);
        mapManage.setFlagDelete(1);

        mapManageMapper.updateByPrimaryKeySelective(mapManage);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject isDefault(JSONObject param) throws Exception {
        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        mapManageMapper.setNotDefault();

        MapManage mapManage = new MapManage();
        mapManage.setId(id);
        mapManage.setIsDefault(0);

        mapManageMapper.updateByPrimaryKeySelective(mapManage);

        JSONObject result = new JSONObject();
        result.put("data", "设置成功");
        result.put("status", 1);
        return result;
    }
}
