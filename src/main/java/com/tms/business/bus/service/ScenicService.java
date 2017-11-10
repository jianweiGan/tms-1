package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface ScenicService {

    JSONObject getScenicInfo(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

    JSONObject addScenicInfo(JSONObject param, String token) throws Exception;

    JSONObject updateScenicInfo(JSONObject param, String token) throws Exception;

    JSONObject deleteScenicInfo(JSONObject param, String token) throws Exception;

}
