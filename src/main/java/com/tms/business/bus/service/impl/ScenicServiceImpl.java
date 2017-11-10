package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.ScenicService;
import com.tms.business.bus.service.TbLogService;
import com.tms.business.domain.HomePageModule;
import com.tms.business.domain.ScenicSpot;
import com.tms.business.domain.ScenicSpotResource;
import com.tms.business.domain.UserInfo;
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
@Service(value = "service/scenic/operate")
public class ScenicServiceImpl implements ScenicService {

    @Autowired
    private ScenicSpotMapper scenicSpotMapper;
    @Autowired
    private ScenicSpotResourceMapper scenicSpotResourceMapper;
    @Autowired
    private TbLogService tbLogService;

    @Override
    public JSONObject getScenicInfo(String id) throws Exception {

        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
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
    public JSONObject selectList(JSONObject param) throws Exception {

        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        ScenicSpot scenicSpot = new ScenicSpot();
        if (StringUtils.isNotBlank(param.getString("name"))) {
            scenicSpot.setName(param.getString("name"));
        }
        if (!ObjectUtils.isEmpty(param.getInteger("level"))) {
            scenicSpot.setLevel(param.getInteger("level"));
        }

        scenicSpot.setFlagDelete(0);
        Page<ScenicSpot> page = scenicSpotMapper.selectList(scenicSpot);

        List<JSONObject> list = new ArrayList<>();

        for (ScenicSpot scenic : page.getResult()) {
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(scenic);
            if (StringUtils.isNotBlank(jsonObject.getString("parentId"))) {
                ScenicSpot spot = scenicSpotMapper.selectByIdAndFlagDelete(scenic.getParentId(), 0);
                if (!ObjectUtils.isEmpty(spot)) {
                    jsonObject.put("parentName", spot.getName());
                }
            }
            list.add(jsonObject);
        }

        JSONObject result = new JSONObject();
        result.put("list", list);
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject addScenicInfo(JSONObject param, String token) throws Exception {
        //保存基本信息
        ScenicSpot scenicSpot = JOHelper.jo2class(param, ScenicSpot.class);
        scenicSpot.setId(UUIDHelper.getUUID());
        scenicSpot.setFlagDelete(0);
        scenicSpot.setCreateTime(new Date());
        scenicSpot.setModifyTime(new Date());

        scenicSpotMapper.insert(scenicSpot);

        //保存资源
        JSONArray imageArray = param.getJSONArray("imageUrls");
        JSONArray videoArray = param.getJSONArray("videoUrls");
        JSONArray audioArray = param.getJSONArray("audioUrls");

        imageArray.forEach(image -> {
            JSONObject jsonObject = (JSONObject) image;
            ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
            scenicSpotResource.setId(UUIDHelper.getUUID());
            scenicSpotResource.setDataId(scenicSpot.getId());
            scenicSpotResource.setSourceurl(jsonObject.getString("url"));
            scenicSpotResource.setType(1);
            scenicSpotResource.setCreateTime(new Date());
            scenicSpotResource.setModifyTime(new Date());
            scenicSpotResource.setSort(0);
            scenicSpotResource.setFlagDelete(0);
            scenicSpotResourceMapper.insert(scenicSpotResource);
        });

        videoArray.forEach(video -> {
            JSONObject jsonObject = (JSONObject) video;
            ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
            scenicSpotResource.setId(UUIDHelper.getUUID());
            scenicSpotResource.setDataId(scenicSpot.getId());
            scenicSpotResource.setSourceurl(jsonObject.getString("url"));
            scenicSpotResource.setType(2);
            scenicSpotResource.setCreateTime(new Date());
            scenicSpotResource.setModifyTime(new Date());
            scenicSpotResource.setSort(0);
            scenicSpotResource.setFlagDelete(0);
            scenicSpotResourceMapper.insert(scenicSpotResource);
        });

        audioArray.forEach(audio -> {
            JSONObject jsonObject = (JSONObject) audio;
            ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
            scenicSpotResource.setId(UUIDHelper.getUUID());
            scenicSpotResource.setDataId(scenicSpot.getId());
            scenicSpotResource.setSourceurl(jsonObject.getString("url"));
            scenicSpotResource.setType(3);
            scenicSpotResource.setCreateTime(new Date());
            scenicSpotResource.setModifyTime(new Date());
            scenicSpotResource.setSort(0);
            scenicSpotResource.setFlagDelete(0);
            scenicSpotResourceMapper.insert(scenicSpotResource);
        });

        tbLogService.addTbLog(token, "scenic_spot", scenicSpot.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateScenicInfo(JSONObject param, String token) throws Exception {

        String id = param.getString("id");
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        //更新基本信息
        ScenicSpot scenicSpot = JOHelper.jo2class(param, ScenicSpot.class);

        scenicSpot.setModifyTime(new Date());

        scenicSpotMapper.updateByPrimaryKey(scenicSpot);

        //更新资源
        scenicSpotResourceMapper.deleteResourceByDataId(id);

        JSONArray imageArray = param.getJSONArray("imageUrls");
        JSONArray videoArray = param.getJSONArray("videoUrls");
        JSONArray audioArray = param.getJSONArray("audioUrls");

        imageArray.forEach(image -> {
            JSONObject jsonObject = (JSONObject) image;

            if (StringUtils.isNotBlank(jsonObject.getString("id"))) {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(jsonObject.getString("id"));
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResourceMapper.updateByPrimaryKeySelective(scenicSpotResource);
            } else {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(UUIDHelper.getUUID());
                scenicSpotResource.setDataId(scenicSpot.getId());
                scenicSpotResource.setSourceurl(jsonObject.getString("url"));
                scenicSpotResource.setType(1);
                scenicSpotResource.setCreateTime(new Date());
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResource.setSort(0);
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResourceMapper.insert(scenicSpotResource);
            }
        });

        videoArray.forEach(video -> {
            JSONObject jsonObject = (JSONObject) video;
            if (StringUtils.isNotBlank(jsonObject.getString("id"))) {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(jsonObject.getString("id"));
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResourceMapper.updateByPrimaryKeySelective(scenicSpotResource);
            } else {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(UUIDHelper.getUUID());
                scenicSpotResource.setDataId(scenicSpot.getId());
                scenicSpotResource.setSourceurl(jsonObject.getString("url"));
                scenicSpotResource.setType(2);
                scenicSpotResource.setCreateTime(new Date());
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResource.setSort(0);
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResourceMapper.insert(scenicSpotResource);
            }
        });

        audioArray.forEach(audio -> {
            JSONObject jsonObject = (JSONObject) audio;
            if (StringUtils.isNotBlank(jsonObject.getString("id"))) {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(jsonObject.getString("id"));
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResourceMapper.updateByPrimaryKeySelective(scenicSpotResource);
            } else {
                ScenicSpotResource scenicSpotResource = new ScenicSpotResource();
                scenicSpotResource.setId(UUIDHelper.getUUID());
                scenicSpotResource.setDataId(scenicSpot.getId());
                scenicSpotResource.setSourceurl(jsonObject.getString("url"));
                scenicSpotResource.setType(3);
                scenicSpotResource.setCreateTime(new Date());
                scenicSpotResource.setModifyTime(new Date());
                scenicSpotResource.setSort(0);
                scenicSpotResource.setFlagDelete(0);
                scenicSpotResourceMapper.insert(scenicSpotResource);
            }
        });

        tbLogService.addTbLog(token, "scenic_spot", scenicSpot.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteScenicInfo(JSONObject param, String token) throws Exception {
        String id = param.getString("id");
        Integer flagDelete = param.getInteger("flagDelete");
        if (StringUtils.isBlank(id) || ObjectUtils.isEmpty(flagDelete)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        List<ScenicSpot> list = scenicSpotMapper.selectByParentId(id, 0);
        if (!ObjectUtils.isEmpty(list) && 0 < list.size()) {
            throw new BussinessException(ErrorCodeEnum.CANNOTDELETESCENIC);
        }

        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setId(id);
        scenicSpot.setFlagDelete(flagDelete);
        scenicSpotMapper.updateByPrimaryKeySelective(scenicSpot);

        tbLogService.addTbLog(token, "scenic_spot", scenicSpot.getId(), 3);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }
}
