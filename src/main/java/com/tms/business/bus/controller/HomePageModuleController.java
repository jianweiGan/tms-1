package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.HomePageModuleService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomePageModuleController extends BaseController{
    @Autowired
    @Qualifier(value = "service/home_page/operate")
    private HomePageModuleService homePageModuleService;

    @RequestMapping(value = "/home_page/get_info")
    @ResponseBody
    public JSONObject getHomePageModule(@RequestHeader(value="id") String id) throws Exception{
        return homePageModuleService.getHomePageModule(id);
    }

    @RequestMapping(value = "/home_page/select_list")
    @ResponseBody
    public JSONObject selectList(@RequestBody JSONObject param) throws Exception{
        return homePageModuleService.selectList(param);
    }

    @RequestMapping(value = "/home_page/add_info")
    @ResponseBody
    public JSONObject addHomePageModule(@RequestBody JSONObject param) throws Exception{
        return homePageModuleService.addHomePageModule(param);
    }

    @RequestMapping(value = "/home_page/update_info")
    @ResponseBody
    public JSONObject updateHomePageModule(@RequestBody JSONObject param) throws Exception{
        return homePageModuleService.updateHomePageModule(param);
    }

    @RequestMapping(value = "/home_page/delete_info")
    @ResponseBody
    public JSONObject deleteHomePageModule(@RequestBody JSONObject param) throws Exception{
        return homePageModuleService.deleteHomePageModule(param);
    }

    @RequestMapping(value = "/home_page/multi_down")
    @ResponseBody
    public JSONObject multiDownHome(@RequestBody JSONObject param) throws Exception{
        return homePageModuleService.multiDownHome(param);
    }

}
