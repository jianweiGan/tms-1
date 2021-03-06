package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.CustomNoticeService;
import com.tms.business.bus.service.TbLogService;
import com.tms.business.bus.service.TmsLegendService;
import com.tms.business.domain.CustomNotice;
import com.tms.business.domain.FeedBack;
import com.tms.business.domain.TmsLegend;
import com.tms.business.domain.TmsLegendActivity;
import com.tms.business.mapper.CustomNoticeMapper;
import com.tms.business.mapper.TmsLegendActivityMapper;
import com.tms.business.mapper.TmsLegendMapper;
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
@Service(value = "service/legend/operate")
public class TmsLegendServiceImpl implements TmsLegendService {

    @Autowired
    private TmsLegendMapper tmsLegendMapper;

    @Autowired
    private TmsLegendActivityMapper tmsLegendActivityMapper;

    @Autowired
    private TbLogService tbLogService;

    @Override
    public JSONObject getLegendInfo() throws Exception {

        TmsLegend tmsLegend = tmsLegendMapper.getTmsLegend();

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(tmsLegend);

        return jsonObject;
    }

    @Override
    public JSONObject addLegendInfo(JSONObject param, String token) throws Exception {

        TmsLegend tmsLegend = JOHelper.jo2class(param, TmsLegend.class);
        tmsLegend.setId(UUIDHelper.getUUID());
        tmsLegend.setFlagDelete(0);
        tmsLegend.setCreateTime(new Date());
        tmsLegend.setModifyTime(new Date());

        tmsLegendMapper.insert(tmsLegend);

        tbLogService.addTbLog(token, "tms_legend", tmsLegend.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateLegendInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        TmsLegend tmsLegend = JOHelper.jo2class(param, TmsLegend.class);
        tmsLegend.setModifyTime(new Date());

        tmsLegendMapper.updateByPrimaryKey(tmsLegend);

        tbLogService.addTbLog(token, "tms_legend", tmsLegend.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject fetchLegendActivityList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<TmsLegendActivity> page = tmsLegendActivityMapper.selectList(param.getString("name"), param.getInteger("type"), param.getDate("startTime"), param.getDate("endTime"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject getLegendActivityInfo(String id) throws Exception {
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        TmsLegendActivity tmsLegendActivity = tmsLegendActivityMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(tmsLegendActivity)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(tmsLegendActivity);

        String detailFormStr = tmsLegendActivity.getDetail();

        if (StringUtils.isNotBlank(detailFormStr)) {
            jsonObject.put("detailForm", JSONArray.parseArray(detailFormStr));
        } else {
            jsonObject.put("detailForm", null);
        }

        return jsonObject;
    }

    @Override
    public JSONObject addLegendActivityInfo(JSONObject param, String token) throws Exception {
        TmsLegendActivity tmsLegendActivity = JOHelper.jo2class(param, TmsLegendActivity.class);

        Date startTime = tmsLegendActivity.getStartTime();
        Date endTime = tmsLegendActivity.getEndTime();

        if (!ObjectUtils.isEmpty(startTime) && !ObjectUtils.isEmpty(endTime)) {
            if (endTime.before(startTime)) {
                throw new BussinessException(ErrorCodeEnum.ENDTIMEBEFORESTARTTIME);
            }
        }

        tmsLegendActivity.setId(UUIDHelper.getUUID());
        tmsLegendActivity.setFlagDelete(0);
        tmsLegendActivity.setCreateTime(new Date());
        tmsLegendActivity.setModifyTime(new Date());

        if (!ObjectUtils.isEmpty(param.getJSONArray("detailForm")) && 0 < param.getJSONArray("detailForm").size()) {
            tmsLegendActivity.setDetail(param.getJSONArray("detailForm").toJSONString());
        }

        tmsLegendActivityMapper.insert(tmsLegendActivity);

        tbLogService.addTbLog(token, "tms_legend_activity", tmsLegendActivity.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateLegendActivityInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        TmsLegendActivity tmsLegendActivity = JOHelper.jo2class(param, TmsLegendActivity.class);
        tmsLegendActivity.setModifyTime(new Date());
        if (!ObjectUtils.isEmpty(param.getJSONArray("detailForm")) && 0 < param.getJSONArray("detailForm").size()) {
            tmsLegendActivity.setDetail(param.getJSONArray("detailForm").toJSONString());
        }
        Date startTime = tmsLegendActivity.getStartTime();
        Date endTime = tmsLegendActivity.getEndTime();

        if (!ObjectUtils.isEmpty(startTime) && !ObjectUtils.isEmpty(endTime)) {
            if (endTime.before(startTime)) {
                throw new BussinessException(ErrorCodeEnum.ENDTIMEBEFORESTARTTIME);
            }
        }

        tmsLegendActivityMapper.updateByPrimaryKeyWithBLOBs(tmsLegendActivity);

        tbLogService.addTbLog(token, "tms_legend_activity", tmsLegendActivity.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteLegendActivityInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        TmsLegendActivity tmsLegendActivity = JOHelper.jo2class(param, TmsLegendActivity.class);
        tmsLegendActivity.setModifyTime(new Date());
        tmsLegendActivity.setFlagDelete(1);

        tmsLegendActivityMapper.updateByPrimaryKeySelective(tmsLegendActivity);

        tbLogService.addTbLog(token, "tms_legend_activity", tmsLegendActivity.getId(), 3);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }
}
