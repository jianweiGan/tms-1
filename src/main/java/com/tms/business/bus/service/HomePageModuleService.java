package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface HomePageModuleService {

    JSONObject getHomePageModule(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

    JSONObject addHomePageModule(JSONObject param) throws Exception;

    JSONObject updateHomePageModule(JSONObject param) throws Exception;

    JSONObject deleteHomePageModule(JSONObject param) throws Exception;

    JSONObject multiDownHome(JSONObject param) throws Exception;

}
