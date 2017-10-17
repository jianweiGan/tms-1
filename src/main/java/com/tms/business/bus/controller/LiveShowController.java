package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.LiveShowService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LiveShowController extends BaseController{
    @Autowired
    @Qualifier(value = "service/live/operate")
    private LiveShowService liveShowService;

    @RequestMapping(value = "/live/fetch_live_show_list")
    @ResponseBody
    public JSONObject fetchLiveShowList(@RequestBody JSONObject param) throws Exception{
        return liveShowService.fetchLiveShowList(param);
    }

    @RequestMapping(value = "/live/get_live_show_info")
    @ResponseBody
    public JSONObject getLiveShowInfo(@RequestParam("id") String id) throws Exception{
        return liveShowService.getLiveShowInfo(id);
    }

    @RequestMapping(value = "/live/add_live_show_info")
    @ResponseBody
    public JSONObject addLiveShowInfo(@RequestBody JSONObject param) throws Exception{
        return liveShowService.addLiveShowInfo(param);
    }

    @RequestMapping(value = "/live/update_live_show_info")
    @ResponseBody
    public JSONObject updateLiveShowInfo(@RequestBody JSONObject param) throws Exception{
        return liveShowService.updateLiveShowInfo(param);
    }

    @RequestMapping(value = "/live/delete_live_show_info")
    @ResponseBody
    public JSONObject deleteLiveShowInfo(@RequestBody JSONObject param) throws Exception{
        return liveShowService.deleteLiveShowInfo(param);
    }
}
