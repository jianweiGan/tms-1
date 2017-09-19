package com.tms.business.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.common.service.CommonService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController extends BaseController{
    @Autowired
    @Qualifier(value = "service/common/operate")
    private CommonService commonService;

    @RequestMapping(value = "/common/get_token")
    @ResponseBody
    public JSONObject getToken() throws Exception{
        return commonService.getToken();
    }

}
