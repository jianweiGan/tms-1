package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.VoiceManageService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VoiceManageController extends BaseController{
    @Autowired
    @Qualifier(value = "service/voice/operate")
    private VoiceManageService voiceManageService;

    @RequestMapping(value = "/voice/fetch_voice_manage_list")
    @ResponseBody
    public JSONObject fetchVoiceManageList(@RequestBody JSONObject param) throws Exception{
        return voiceManageService.fetchVoiceManageList(param);
    }

    @RequestMapping(value = "/voice/get_voice_manage_info")
    @ResponseBody
    public JSONObject getVoiceManageInfo(@RequestParam("id") String id) throws Exception{
        return voiceManageService.getVoiceManageInfo(id);
    }

    @RequestMapping(value = "/voice/add_voice_manage_info")
    @ResponseBody
    public JSONObject addVoiceManageInfo(@RequestBody JSONObject param) throws Exception{
        return voiceManageService.addVoiceManageInfo(param);
    }

    @RequestMapping(value = "/voice/update_voice_manage_info")
    @ResponseBody
    public JSONObject updateVoiceManageInfo(@RequestBody JSONObject param) throws Exception{
        return voiceManageService.updateVoiceManageInfo(param);
    }

    @RequestMapping(value = "/voice/delete_voice_manage_info")
    @ResponseBody
    public JSONObject deleteVoiceManageInfo(@RequestBody JSONObject param) throws Exception{
        return voiceManageService.deleteVoiceManageInfo(param);
    }
}
