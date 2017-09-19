package com.tms.business.user.service;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.domain.UserInfo;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface UserInfoService {

    JSONObject login(JSONObject param) throws Exception;

    JSONObject getUserInfo(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

    JSONObject addUserInfo(JSONObject param) throws Exception;

    JSONObject updateUserInfo(JSONObject param) throws Exception;

    JSONObject deleteUserInfo(JSONObject param) throws Exception;

    JSONObject resetPassword(JSONObject param) throws Exception;

}
