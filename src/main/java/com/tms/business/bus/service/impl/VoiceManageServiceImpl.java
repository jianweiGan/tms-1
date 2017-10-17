package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.VoiceManageService;
import com.tms.business.domain.VoiceManage;
import com.tms.business.mapper.VoiceManageMapper;
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
@Service(value = "service/voice/operate")
public class VoiceManageServiceImpl implements VoiceManageService {

    @Autowired
    private VoiceManageMapper voiceManageMapper;

    @Override
    public JSONObject fetchVoiceManageList(JSONObject param) throws Exception {
        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        Page<VoiceManage> page = voiceManageMapper.selectList(param.getString("name"));

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject getVoiceManageInfo(String id) throws Exception {
        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        VoiceManage voiceManage = voiceManageMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(voiceManage)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(voiceManage);

        List<JSONObject> audioUrls = new ArrayList<>();
        audioUrls.add(JOHelper.gen("url", voiceManage.getUrl()));

        jsonObject.put("audioUrls", audioUrls);

        return jsonObject;
    }

    @Override
    public JSONObject addVoiceManageInfo(JSONObject param) throws Exception {
        VoiceManage voiceManage = JOHelper.jo2class(param, VoiceManage.class);
        voiceManage.setId(UUIDHelper.getUUID());
        voiceManage.setFlagDelete(0);
        voiceManage.setCreateTime(new Date());
        voiceManage.setModifyTime(new Date());

        if (!ObjectUtils.isEmpty(param.getJSONArray("audioUrls")) && 0 < param.getJSONArray("audioUrls").size()) {
            voiceManage.setUrl(((JSONObject)param.getJSONArray("audioUrls").get(0)).getString("url"));
        }

        voiceManageMapper.insert(voiceManage);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateVoiceManageInfo(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        VoiceManage voiceManage = JOHelper.jo2class(param, VoiceManage.class);
        voiceManage.setModifyTime(new Date());

        if (!ObjectUtils.isEmpty(param.getJSONArray("audioUrls")) && 0 < param.getJSONArray("audioUrls").size()) {
            voiceManage.setUrl(((JSONObject)param.getJSONArray("audioUrls").get(0)).getString("url"));
        }

        voiceManageMapper.updateByPrimaryKeyWithBLOBs(voiceManage);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteVoiceManageInfo(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        VoiceManage voiceManage = JOHelper.jo2class(param, VoiceManage.class);
        voiceManage.setModifyTime(new Date());
        voiceManage.setFlagDelete(1);

        voiceManageMapper.updateByPrimaryKeySelective(voiceManage);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }
}
