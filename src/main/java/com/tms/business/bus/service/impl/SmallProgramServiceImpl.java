package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.SmallProgramService;
import com.tms.business.domain.*;
import com.tms.business.mapper.*;
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
@Service(value = "service/program/operate")
public class SmallProgramServiceImpl implements SmallProgramService {

    @Autowired
    private HomePageModuleMapper homePageModuleMapper;
    @Autowired
    private TmsLegendMapper tmsLegendMapper;
    @Autowired
    private TmsLegendActivityMapper tmsLegendActivityMapper;
    @Autowired
    private ScenicSpotMapper scenicSpotMapper;
    @Autowired
    private ScenicSpotResourceMapper scenicSpotResourceMapper;
    @Autowired
    private CustomNoticeMapper customNoticeMapper;
    @Autowired
    private FeedBackMapper feedBackMapper;
    @Autowired
    private WonderfulPhotoMapper wonderfulPhotoMapper;
    @Autowired
    private MapManageMapper mapManageMapper;

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

        //tms介绍

        PageHelper.startPage(1, 1); // 核心分页代码

        JSONObject result = new JSONObject();

        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setFlagDelete(0);
        Page<ScenicSpot> page = scenicSpotMapper.selectList(scenicSpot);
        if (!ObjectUtils.isEmpty(page) && 0 < page.getTotal()) {
            JSONObject tmsJson = JOHelper.obj2Json(page.getResult().get(0));


            List<ScenicSpotResource> list = scenicSpotResourceMapper.selectListByDataId(tmsJson.getString("id"));

            List<JSONObject> imageUrls = new ArrayList<>();

            list.forEach(resource -> {
                if (1 == resource.getType()) {
                    imageUrls.add(JOHelper.gen("id", resource.getId(), "url", resource.getSourceurl()));
                }
            });
            tmsJson.put("imageUrls", imageUrls);
            result.put("tms", tmsJson);
        } else {
            result.put("tms", null);
        }

        //主要景点图片 TODO:未确定
        result.put("mainImage", "http://oq50tshbr.bkt.clouddn.com/tms/image/55dca620b381fcb83dcd5481469c6603.jpeg");

        //游客须知
        CustomNotice customNotice = customNoticeMapper.getCustomNotice();
        result.put("notice", customNotice);

        return result;
    }

    @Override
    public JSONObject getScenicInfo(JSONObject param) throws Exception {
        return null;
    }

    @Override
    public JSONObject addFeedBack(JSONObject param) throws Exception {

        FeedBack feedBack = JOHelper.jo2class(param, FeedBack.class);
        if (ObjectUtils.isEmpty(feedBack)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        if (StringUtils.isBlank(feedBack.getOpenId()) || StringUtils.isBlank(feedBack.getNickName())) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        feedBack.setId(UUIDHelper.getUUID());
        feedBack.setCreateTime(new Date());
        feedBack.setModifyTime(new Date());
        feedBack.setFlagDelete(0);

        feedBackMapper.insert(feedBack);

        JSONObject result = new JSONObject();
        result.put("data", "提交成功");
        result.put("status", 1);
        return result;
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

    @Override
    public JSONObject getScenisInfo(JSONObject param) throws Exception {

        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw  new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        ScenicSpot scenicSpot = scenicSpotMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(scenicSpot)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(scenicSpot);

        List<ScenicSpotResource> list = scenicSpotResourceMapper.selectListByDataId(id);

        List<JSONObject> imageUrls = new ArrayList<>();
        List<JSONObject> videoUrls = new ArrayList<>();
        List<JSONObject> audioUrls = new ArrayList<>();

        list.forEach(resource -> {
            if (1 == resource.getType()) {
                imageUrls.add(JOHelper.gen("id", resource.getId(), "url", resource.getSourceurl()));
            } else if (2 == resource.getType()) {
                videoUrls.add(JOHelper.gen("id", resource.getId(), "url", resource.getSourceurl()));
            } else if (3 == resource.getType()) {
                audioUrls.add(JOHelper.gen("id", resource.getId(), "url", resource.getSourceurl()));
            }
        });

        jsonObject.put("imageUrls", imageUrls);
        jsonObject.put("videoUrls", videoUrls);
        jsonObject.put("audioUrls", audioUrls);

        return jsonObject;
    }

    @Override
    public JSONObject selectWonderfulPhotoList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<WonderfulPhoto> page = wonderfulPhotoMapper.selectWonderfulPhotoList(param.getInteger("type"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject getWonderfulPhotoInfo(JSONObject param) throws Exception {
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
    public JSONObject selectMapList(JSONObject param) throws Exception {

        PageHelper.startPage(1, 100); // 核心分页代码

        JSONObject result = new JSONObject();

        MapManage mapManage = new MapManage();

        Page<MapManage> page = mapManageMapper.selectList(mapManage);

        result.put("mapList", page.getResult());

        ScenicSpot scenicSpot = new ScenicSpot();

        scenicSpot.setFlagDelete(0);
        Page<ScenicSpot> scenicPage = scenicSpotMapper.selectList(scenicSpot);

        result.put("scenicList", scenicPage.getResult());

        return JOHelper.gen("data", result, "status", 1);
    }
}
