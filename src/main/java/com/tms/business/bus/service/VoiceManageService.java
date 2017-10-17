package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface VoiceManageService {

    JSONObject fetchVoiceManageList(JSONObject param) throws Exception;

    JSONObject getVoiceManageInfo(@RequestParam("id") String id) throws Exception;

    JSONObject addVoiceManageInfo(JSONObject param) throws Exception;

    JSONObject updateVoiceManageInfo(JSONObject param) throws Exception;

    JSONObject deleteVoiceManageInfo(JSONObject param) throws Exception;

}
