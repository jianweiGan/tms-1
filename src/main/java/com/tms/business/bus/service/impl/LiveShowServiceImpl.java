package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.LiveShowService;
import com.tms.business.bus.service.TbLogService;
import com.tms.business.domain.LiveShow;
import com.tms.business.mapper.LiveShowMapper;
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

@Transactional
@Service(value = "service/live/operate")
public class LiveShowServiceImpl implements LiveShowService {

    @Autowired
    private LiveShowMapper liveShowMapper;

    @Autowired
    private TbLogService tbLogService;

    @Override
    public JSONObject fetchLiveShowList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<LiveShow> page = liveShowMapper.selectList(param.getString("name"), param.getDate("startTime"), param.getDate("endTime"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject getLiveShowInfo(String id) throws Exception {
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        LiveShow liveShow = liveShowMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(liveShow)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(liveShow);

        String detailFormStr = liveShow.getDetail();

        if (StringUtils.isNotBlank(detailFormStr)) {
            jsonObject.put("detailForm", JSONArray.parseArray(detailFormStr));
        } else {
            jsonObject.put("detailForm", null);
        }

        return jsonObject;
    }

    @Override
    public JSONObject addLiveShowInfo(JSONObject param, String token) throws Exception {
        LiveShow liveShow = JOHelper.jo2class(param, LiveShow.class);
        liveShow.setId(UUIDHelper.getUUID());
        liveShow.setFlagDelete(0);
        liveShow.setCreateTime(new Date());
        liveShow.setModifyTime(new Date());

        if (!ObjectUtils.isEmpty(param.getJSONArray("detailForm")) && 0 < param.getJSONArray("detailForm").size()) {
            liveShow.setDetail(param.getJSONArray("detailForm").toJSONString());
        }

        liveShowMapper.insert(liveShow);

        tbLogService.addTbLog(token, "live_show", liveShow.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateLiveShowInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        LiveShow liveShow = JOHelper.jo2class(param, LiveShow.class);
        liveShow.setModifyTime(new Date());
        if (!ObjectUtils.isEmpty(param.getJSONArray("detailForm")) && 0 < param.getJSONArray("detailForm").size()) {
            liveShow.setDetail(param.getJSONArray("detailForm").toJSONString());
        }

        liveShowMapper.updateByPrimaryKeyWithBLOBs(liveShow);

        tbLogService.addTbLog(token, "live_show", liveShow.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteLiveShowInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        LiveShow liveShow = JOHelper.jo2class(param, LiveShow.class);
        liveShow.setModifyTime(new Date());
        liveShow.setFlagDelete(1);

        liveShowMapper.updateByPrimaryKeySelective(liveShow);

        tbLogService.addTbLog(token, "live_show", liveShow.getId(), 3);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }
}
