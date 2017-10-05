package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.ScenicService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ScenicController extends BaseController{
    @Autowired
    @Qualifier(value = "service/scenic/operate")
    private ScenicService scenicService;

    @RequestMapping(value = "/scenic/get_info")
    @ResponseBody
    public JSONObject getScenicInfo(@RequestParam(value="id") String id) throws Exception{
        return scenicService.getScenicInfo(id);
    }

    @RequestMapping(value = "/scenic/select_list")
    @ResponseBody
    public JSONObject selectList(@RequestBody JSONObject param) throws Exception{
        return scenicService.selectList(param);
    }

    @RequestMapping(value = "/scenic/add_scenic")
    @ResponseBody
    public JSONObject addScenicInfo(@RequestBody JSONObject param) throws Exception{
        return scenicService.addScenicInfo(param);
    }

    @RequestMapping(value = "/scenic/update_scenic")
    @ResponseBody
    public JSONObject updateScenicInfo(@RequestBody JSONObject param) throws Exception{
        return scenicService.updateScenicInfo(param);
    }

    @RequestMapping(value = "/scenic/delete_scenic")
    @ResponseBody
    public JSONObject deleteScenicInfo(@RequestBody JSONObject param) throws Exception{
        return scenicService.deleteScenicInfo(param);
    }
}
