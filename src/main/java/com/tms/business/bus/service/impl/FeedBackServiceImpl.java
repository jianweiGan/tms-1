package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.FeedBackService;
import com.tms.business.bus.service.ScenicService;
import com.tms.business.domain.FeedBack;
import com.tms.business.domain.HomePageModule;
import com.tms.business.domain.ScenicSpot;
import com.tms.business.domain.ScenicSpotResource;
import com.tms.business.mapper.FeedBackMapper;
import com.tms.business.mapper.ScenicSpotMapper;
import com.tms.business.mapper.ScenicSpotResourceMapper;
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

/**
 * Created by xiongzhanyuan on 2017/2/21.
 */
@Transactional
@Service(value = "service/feed_back/operate")
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackMapper feedBackMapper;

    @Override
    public JSONObject getFeedBackInfo(String id) throws Exception {

        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        FeedBack feedBack = feedBackMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(feedBack)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(feedBack);

        return jsonObject;
    }

    @Override
    public JSONObject selectList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<FeedBack> page = feedBackMapper.selectList(param.getString("content"), param.getDate("startTime"), param.getDate("endTime"), param.getInteger("type"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }
}
