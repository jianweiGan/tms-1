package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.CustomNoticeService;
import com.tms.business.bus.service.ScenicService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomNoticeController extends BaseController{
    @Autowired
    @Qualifier(value = "service/notice/operate")
    private CustomNoticeService customNoticeService;

    @RequestMapping(value = "/notice/get_notice")
    @ResponseBody
    public JSONObject getNoticeInfo() throws Exception{
        return customNoticeService.getNoticeInfo();
    }


    @RequestMapping(value = "/notice/add_notice")
    @ResponseBody
    public JSONObject addNoticeInfo(@RequestBody JSONObject param) throws Exception{
        return customNoticeService.addNoticeInfo(param);
    }

    @RequestMapping(value = "/notice/update_notice")
    @ResponseBody
    public JSONObject updateNoticeInfo(@RequestBody JSONObject param) throws Exception{
        return customNoticeService.updateNoticeInfo(param);
    }
}
