package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.FeedBackService;
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
public class FeedBackController extends BaseController{
    @Autowired
    @Qualifier(value = "service/feed_back/operate")
    private FeedBackService feedBackService;

    @RequestMapping(value = "/feed_back/get_info")
    @ResponseBody
    public JSONObject getFeedBackInfo(@RequestParam(value="id") String id) throws Exception{
        return feedBackService.getFeedBackInfo(id);
    }

    @RequestMapping(value = "/feed_back/select_list")
    @ResponseBody
    public JSONObject selectList(@RequestBody JSONObject param) throws Exception{
        return feedBackService.selectList(param);
    }
}
