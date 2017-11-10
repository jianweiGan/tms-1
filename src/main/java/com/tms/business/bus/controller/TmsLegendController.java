package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.CustomNoticeService;
import com.tms.business.bus.service.TmsLegendService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TmsLegendController extends BaseController{
    @Autowired
    @Qualifier(value = "service/legend/operate")
    private TmsLegendService tmsLegendService;

    @RequestMapping(value = "/legend/get_legend")
    @ResponseBody
    public JSONObject getLegendInfo() throws Exception{
        return tmsLegendService.getLegendInfo();
    }


    @RequestMapping(value = "/legend/add_legend")
    @ResponseBody
    public JSONObject addLegendInfo(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return tmsLegendService.addLegendInfo(param, token);
    }

    @RequestMapping(value = "/legend/update_legend")
    @ResponseBody
    public JSONObject updateLegendInfo(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return tmsLegendService.updateLegendInfo(param, token);
    }

    @RequestMapping(value = "/legend/fetch_legend_activity_list")
    @ResponseBody
    public JSONObject fetchLegendActivityList(@RequestBody JSONObject param) throws Exception{
        return tmsLegendService.fetchLegendActivityList(param);
    }

    @RequestMapping(value = "/legend/get_legend_activity_info")
    @ResponseBody
    public JSONObject getLegendActivityInfo(@RequestParam("id") String id) throws Exception{
        return tmsLegendService.getLegendActivityInfo(id);
    }

    @RequestMapping(value = "/legend/add_legend_activity_info")
    @ResponseBody
    public JSONObject addLegendActivityInfo(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return tmsLegendService.addLegendActivityInfo(param, token);
    }

    @RequestMapping(value = "/legend/update_legend_activity_info")
    @ResponseBody
    public JSONObject updateLegendActivityInfo(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return tmsLegendService.updateLegendActivityInfo(param, token);
    }

    @RequestMapping(value = "/legend/delete_legend_activity_info")
    @ResponseBody
    public JSONObject deleteLegendActivityInfo(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return tmsLegendService.deleteLegendActivityInfo(param, token);
    }
}
