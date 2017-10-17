package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface MapManageService {

    JSONObject getMapeInfo(String id) throws Exception;

    JSONObject selectMapList(JSONObject param) throws Exception;

    JSONObject addMap(JSONObject param) throws Exception;

    JSONObject updateMap(JSONObject param) throws Exception;

    JSONObject deleteMap(JSONObject param) throws Exception;

    JSONObject isDefault(JSONObject param) throws Exception;

}
