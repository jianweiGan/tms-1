package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.domain.UserInfo;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface UserInfoService {

    JSONObject login(JSONObject param) throws Exception;

    JSONObject getUserInfo(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

    JSONObject addUserInfo(JSONObject param, String token) throws Exception;

    JSONObject updateUserInfo(JSONObject param, String token) throws Exception;

    JSONObject deleteUserInfo(JSONObject param, String token) throws Exception;

    JSONObject resetPassword(JSONObject param, String token) throws Exception;

}
