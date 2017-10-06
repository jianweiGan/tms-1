package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface FeedBackService {

    JSONObject getFeedBackInfo(String id) throws Exception;

    JSONObject selectList(JSONObject param) throws Exception;

}
