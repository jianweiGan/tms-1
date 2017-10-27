package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.ScenicService;
import com.tms.business.bus.service.SmallProgramService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SmallProgramController extends BaseController{
    @Autowired
    @Qualifier(value = "service/program/operate")
    private SmallProgramService smallProgramService;

    @RequestMapping(value = "/program/select_home_page_list")
    @ResponseBody
    public JSONObject selectHomePageList(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.selectHomePageList(param);
    }

    @RequestMapping(value = "/program/get_tms_legend_activity")
    @ResponseBody
    public JSONObject getTmsLegendActivity(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.getTmsLegendActivity(param);
    }

    @RequestMapping(value = "/program/get_tms_activity_detail")
    @ResponseBody
    public JSONObject getTmsActivityDetail(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.getTmsActivityDetail(param);
    }

    @RequestMapping(value = "/program/get_min_jian_chuan_shuo")
    @ResponseBody
    public JSONObject getMinJianChuanShuo(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.getMinJianChuanShuo(param);
    }

    @RequestMapping(value = "/program/get_min_jian_chuan_shuo_detail")
    @ResponseBody
    public JSONObject getMinJianChuanShuoDetail(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.getMinJianChuanShuoDetail(param);
    }

    @RequestMapping(value = "/program/get_scenis_info")
    @ResponseBody
    public JSONObject getScenisInfo(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.getScenisInfo(param);
    }

    @RequestMapping(value = "/program/add_feed_back")
    @ResponseBody
    public JSONObject addFeedBack(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.addFeedBack(param);
    }

    @RequestMapping(value = "/program/about_tms")
    @ResponseBody
    public JSONObject aboutTms(@RequestBody JSONObject param) throws Exception{
        return smallProgramService.aboutTms(param);
    }

}
