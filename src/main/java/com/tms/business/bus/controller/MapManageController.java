package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.HomePageModuleService;
import com.tms.business.bus.service.MapManageService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.format.DateTimeFormatter;

@Controller
public class MapManageController extends BaseController{
    @Autowired
    @Qualifier(value = "service/map/operate")
    private MapManageService mapManageService;

    @RequestMapping(value = "/map/get_map_info")
    @ResponseBody
    public JSONObject getMapeInfo(@RequestHeader(value="id") String id) throws Exception{
        return mapManageService.getMapeInfo(id);
    }

    @RequestMapping(value = "/map/select_map_list")
    @ResponseBody
    public JSONObject selectMapList(@RequestBody JSONObject param) throws Exception{
        return mapManageService.selectMapList(param);
    }

    @RequestMapping(value = "/map/add_map")
    @ResponseBody
    public JSONObject addMap(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return mapManageService.addMap(param, token);
    }

    @RequestMapping(value = "/map/update_map")
    @ResponseBody
    public JSONObject updateMap(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return mapManageService.updateMap(param, token);
    }

    @RequestMapping(value = "/map/delete_map")
    @ResponseBody
    public JSONObject deleteMap(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return mapManageService.deleteMap(param, token);
    }

    @RequestMapping(value = "/map/is_default")
    @ResponseBody
    public JSONObject isDefault(@RequestBody JSONObject param, @RequestHeader(value="X-Token") String token) throws Exception{
        return mapManageService.isDefault(param, token);
    }

}
