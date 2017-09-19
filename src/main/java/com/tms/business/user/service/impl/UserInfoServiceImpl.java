package com.tms.business.user.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.domain.UserInfo;
import com.tms.business.mapper.UserInfoMapper;
import com.tms.business.user.service.UserInfoService;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import com.tms.common.helper.JOHelper;
import com.tms.common.helper.UUIDHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * Created by xiongzhanyuan on 2017/2/21.
 */
@Transactional
@Service(value = "service/user/operate")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public JSONObject login(JSONObject param) throws Exception {

        String userName = param.getString("userName");
        String password = param.getString("password");

        UserInfo userInfo = userInfoMapper.getUserInfoByUserName(userName);

        if (ObjectUtils.isEmpty(userInfo)) {
            throw new BussinessException(ErrorCodeEnum.ACCOUNTNOTEXIST);
        }

        if (!password.equals(userInfo.getPassword())) {
            throw new BussinessException(ErrorCodeEnum.ERRORPASSWORD);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", "ok");
        jsonObject.put("token", userInfo.getId());
        return jsonObject;
    }

    @Override
    public JSONObject getUserInfo(String id) throws Exception {

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(userInfo);

        jsonObject.remove("password");

        return jsonObject;
    }

    @Override
    public JSONObject selectList(JSONObject param) throws Exception {

        JSONObject pageJson = param.getJSONObject("page");

        PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(param.getString("userName"));
        userInfo.setRealName(param.getString("realName"));

        Page<UserInfo> page =  userInfoMapper.selectList(userInfo);

        for (UserInfo user : page.getResult()) {
            user.setPassword("");
        }

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject addUserInfo(JSONObject jsonObject) throws Exception {

        UserInfo userInfo = JOHelper.jo2class(jsonObject, UserInfo.class);
        userInfo.setId(UUIDHelper.getUUID());
        userInfo.setFlagDelete(0);
        userInfo.setRoleName("admin");
        userInfoMapper.insert(userInfo);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateUserInfo(JSONObject param) throws Exception {

        if (StringUtils.isBlank(param.getString("id")) ||
                StringUtils.isBlank(param.getString("userName")) ||
                StringUtils.isBlank(param.getString("password")) ||
                StringUtils.isBlank(param.getString("realName")) ||
                StringUtils.isBlank(param.getString("checkPass"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        if (!param.getString("password").equals(param.getString("checkPass"))) {
            throw new BussinessException(ErrorCodeEnum.PASSWORDNOTSAME);
        }

        UserInfo userInfo = JOHelper.jo2class(param, UserInfo.class);

        userInfoMapper.updateByPrimaryKey(userInfo);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteUserInfo(JSONObject param) throws Exception {

        String id = param.getString("id");
        Integer flagDelete = param.getInteger("flagDelete");
        if (StringUtils.isBlank(id) || ObjectUtils.isEmpty(flagDelete)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setFlagDelete(flagDelete);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject resetPassword(JSONObject param) throws Exception {
        if (StringUtils.isBlank(param.getString("id")) ||
                StringUtils.isBlank(param.getString("oldPassword")) ||
                StringUtils.isBlank(param.getString("password")) ||
                StringUtils.isBlank(param.getString("checkPass"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        if (!param.getString("password").equals(param.getString("checkPass"))) {
            throw new BussinessException(ErrorCodeEnum.PASSWORDNOTSAME);
        }

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(param.getString("id"));
        if (ObjectUtils.isEmpty(userInfo)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        if (!userInfo.getPassword().equals(param.getString("oldPassword"))) {
            throw new BussinessException(ErrorCodeEnum.ERRORPASSWORD);
        }

        userInfo.setPassword(param.getString("password"));

        userInfoMapper.updateByPrimaryKeySelective(userInfo);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }
}
