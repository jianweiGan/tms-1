package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.VoiceManageService;
import com.tms.business.bus.service.WonderfulPhotoService;
import com.tms.business.domain.VoiceManage;
import com.tms.business.domain.WonderfulPhoto;
import com.tms.business.mapper.VoiceManageMapper;
import com.tms.business.mapper.WonderfulPhotoMapper;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import com.tms.common.helper.JOHelper;
import com.tms.common.helper.UUIDHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Transactional
@Service(value = "service/wonderful/operate")
public class WonderfulPhotoServiceImpl implements WonderfulPhotoService {

    @Autowired
    private WonderfulPhotoMapper wonderfulPhotoMapper;

    @Override
    public JSONObject fetchWonderfulPhotoList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<WonderfulPhoto> page = wonderfulPhotoMapper.selectList(param.getInteger("type"), param.getDate("startTime"), param.getDate("endTime"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject getWonderfulPhotoInfo(String id) throws Exception {
        return null;
    }

    @Override
    public JSONObject addWonderfulPhotoInfo(JSONObject param) throws Exception {
        WonderfulPhoto wonderfulPhoto = JOHelper.jo2class(param, WonderfulPhoto.class);
        wonderfulPhoto.setId(UUIDHelper.getUUID());
        wonderfulPhoto.setFlagDelete(1);
        wonderfulPhoto.setCreateTime(new Date());
        wonderfulPhoto.setModifyTime(new Date());

        wonderfulPhotoMapper.insert(wonderfulPhoto);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateWonderfulPhotoInfo(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        WonderfulPhoto wonderfulPhoto = JOHelper.jo2class(param, WonderfulPhoto.class);
        wonderfulPhoto.setModifyTime(new Date());

        wonderfulPhotoMapper.updateByPrimaryKey(wonderfulPhoto);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject onLineWonderfulPhotoInfo(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        WonderfulPhoto wonderfulPhoto = JOHelper.jo2class(param, WonderfulPhoto.class);
        wonderfulPhoto.setModifyTime(new Date());
        wonderfulPhoto.setFlagDelete(0);

        wonderfulPhotoMapper.updateByPrimaryKeySelective(wonderfulPhoto);

        JSONObject result = new JSONObject();
        result.put("data", "通过审核");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject offLineWonderfulPhotoInfo(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        WonderfulPhoto wonderfulPhoto = JOHelper.jo2class(param, WonderfulPhoto.class);
        wonderfulPhoto.setModifyTime(new Date());
        wonderfulPhoto.setFlagDelete(1);

        wonderfulPhotoMapper.updateByPrimaryKeySelective(wonderfulPhoto);

        JSONObject result = new JSONObject();
        result.put("data", "拒绝");
        result.put("status", 1);
        return result;
    }
}
