package com.tms.business.bus.controller;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.UserInfoService;
import com.tms.mvc.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserInfoController extends BaseController{
    @Autowired
    @Qualifier(value = "service/user/operate")
    private UserInfoService userInfoService;

    @RequestMapping(value = "/user/login")
    @ResponseBody
    public JSONObject login(@RequestBody JSONObject param) throws Exception{
        return userInfoService.login(param);
    }

    @RequestMapping(value = "/user/get_info")
    @ResponseBody
    public JSONObject getUserInfo(@RequestHeader(value="X-Token") String token) throws Exception{
        return userInfoService.getUserInfo(token);
    }

    @RequestMapping(value = "/user/select_list")
    @ResponseBody
    public JSONObject selectList(@RequestBody JSONObject param) throws Exception{
        return userInfoService.selectList(param);
    }

    @RequestMapping(value = "/user/add_user")
    @ResponseBody
    public JSONObject addUserInfo(@RequestBody JSONObject param) throws Exception{
        return userInfoService.addUserInfo(param);
    }

    @RequestMapping(value = "/user/update_user")
    @ResponseBody
    public JSONObject updateUserInfo(@RequestBody JSONObject param) throws Exception{
        return userInfoService.updateUserInfo(param);
    }

    @RequestMapping(value = "/user/delete_user")
    @ResponseBody
    public JSONObject deleteUserInfo(@RequestBody JSONObject param) throws Exception{
        return userInfoService.deleteUserInfo(param);
    }

    @RequestMapping(value = "/user/reset_password")
    @ResponseBody
    public JSONObject resetPassword(@RequestBody JSONObject param) throws Exception{
        return userInfoService.resetPassword(param);
    }

}
