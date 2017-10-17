package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.VoiceManageService;
import com.tms.business.bus.service.WonderfulPhotoService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WonderfulPhotoController extends BaseController{
    @Autowired
    @Qualifier(value = "service/wonderful/operate")
    private WonderfulPhotoService wonderfulPhotoService;

    @RequestMapping(value = "/wonderful/fetch_wonderful_photo_list")
    @ResponseBody
    public JSONObject fetchWonderfulPhotoList(@RequestBody JSONObject param) throws Exception{
        return wonderfulPhotoService.fetchWonderfulPhotoList(param);
    }

    @RequestMapping(value = "/wonderful/get_wonderful_photo_info")
    @ResponseBody
    public JSONObject getWonderfulPhotoInfo(@RequestParam("id") String id) throws Exception{
        return wonderfulPhotoService.getWonderfulPhotoInfo(id);
    }

    @RequestMapping(value = "/wonderful/add_wonderful_photo_info")
    @ResponseBody
    public JSONObject addWonderfulPhotoInfo(@RequestBody JSONObject param) throws Exception{
        return wonderfulPhotoService.addWonderfulPhotoInfo(param);
    }

    @RequestMapping(value = "/wonderful/update_wonderful_photo_info")
    @ResponseBody
    public JSONObject updateWonderfulPhotoInfo(@RequestBody JSONObject param) throws Exception{
        return wonderfulPhotoService.updateWonderfulPhotoInfo(param);
    }

    @RequestMapping(value = "/wonderful/online_wonderful_photo_info")
    @ResponseBody
    public JSONObject onLineWonderfulPhotoInfo(@RequestBody JSONObject param) throws Exception{
        return wonderfulPhotoService.onLineWonderfulPhotoInfo(param);
    }

    @RequestMapping(value = "/wonderful/offline_wonderful_photo_info")
    @ResponseBody
    public JSONObject offLineWonderfulPhotoInfo(@RequestBody JSONObject param) throws Exception{
        return wonderfulPhotoService.offLineWonderfulPhotoInfo(param);
    }
}
