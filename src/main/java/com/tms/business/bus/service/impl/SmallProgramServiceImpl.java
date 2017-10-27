package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.SmallProgramService;
import com.tms.business.domain.HomePageModule;
import com.tms.business.domain.TmsLegend;
import com.tms.business.domain.TmsLegendActivity;
import com.tms.business.mapper.HomePageModuleMapper;
import com.tms.business.mapper.TmsLegendActivityMapper;
import com.tms.business.mapper.TmsLegendMapper;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import com.tms.common.helper.JOHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "service/program/operate")
public class SmallProgramServiceImpl implements SmallProgramService {

    @Autowired
    private HomePageModuleMapper homePageModuleMapper;
    @Autowired
    private TmsLegendMapper tmsLegendMapper;
    @Autowired
    private TmsLegendActivityMapper tmsLegendActivityMapper;

    @Override
    public JSONObject selectHomePageList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        if (ObjectUtils.isEmpty(pageJson)) {
            PageHelper.startPage(1, 10); // 核心分页代码
        } else {
            PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码
        }

        HomePageModule homePageModule = new HomePageModule();

        Page<HomePageModule> page = homePageModuleMapper.selectList(homePageModule);

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject aboutTms(JSONObject param) throws Exception {
        return null;
    }

    @Override
    public JSONObject getScenicInfo(JSONObject param) throws Exception {
        return null;
    }

    @Override
    public JSONObject addFeedBack(JSONObject param) throws Exception {
        return null;
    }

    @Override
    public JSONObject getTmsLegend(JSONObject param) throws Exception {
        return null;
    }

    @Override
    public JSONObject getTmsLegendActivity(JSONObject param) throws Exception {
        TmsLegend tmsLegend = tmsLegendMapper.getTmsLegend();

        PageHelper.startPage(1, 10); // 核心分页代码

        Page<TmsLegendActivity> page = tmsLegendActivityMapper.selectList(null, 1, null, null);

        JSONObject result = new JSONObject();

        result.put("tmsLegend", tmsLegend);

        result.put("tmsLegendActivity", page.getResult());

        return result;
    }

    @Override
    public JSONObject getTmsActivityDetail(JSONObject param) throws Exception {

        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        TmsLegendActivity tmsLegendActivity = tmsLegendActivityMapper.selectByPrimaryKey(id);

        JSONObject result = JOHelper.obj2Json(tmsLegendActivity);

        if (StringUtils.isNotBlank(tmsLegendActivity.getDetail())) {
            JSONArray jsonArray = JSONArray.parseArray(tmsLegendActivity.getDetail());
            result.put("detail", jsonArray);
        }

        return result;
    }

    @Override
    public JSONObject getMinJianChuanShuo(JSONObject param) throws Exception {

        PageHelper.startPage(1, 1); // 核心分页代码

        Page<TmsLegendActivity> page = tmsLegendActivityMapper.selectList(null, 2, null, null);

        JSONObject result = new JSONObject();

        if (0 < page.getResult().size()) {
            result.put("minJianChuanShuo", page.getResult().get(0));
            if (StringUtils.isNotBlank(page.getResult().get(0).getDetail())) {
                result.put("detail", JSONArray.parse(page.getResult().get(0).getDetail()));
            } else {
                result.put("detail", new ArrayList<>());
            }

        }

        return result;
    }

    @Override
    public JSONObject getMinJianChuanShuoDetail(JSONObject param) throws Exception {

        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        TmsLegendActivity tmsLegendActivity = tmsLegendActivityMapper.selectByPrimaryKey(id);

        JSONObject result = JOHelper.obj2Json(tmsLegendActivity);

        if (StringUtils.isNotBlank(tmsLegendActivity.getDetail())) {
            JSONArray jsonArray = JSONArray.parseArray(tmsLegendActivity.getDetail());
            result.put("detail", jsonArray);
        }

        return result;
    }
}
