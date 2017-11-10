package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface HomePageModuleService {

    JSONObject getHomePageModule(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

    JSONObject addHomePageModule(JSONObject param, String token) throws Exception;

    JSONObject updateHomePageModule(JSONObject param, String token) throws Exception;

    JSONObject deleteHomePageModule(JSONObject param, String token) throws Exception;

    JSONObject multiDownHome(JSONObject param, String token) throws Exception;

}
