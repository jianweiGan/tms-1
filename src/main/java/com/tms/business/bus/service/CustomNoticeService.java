package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface CustomNoticeService {

    JSONObject getNoticeInfo() throws Exception;

    JSONObject addNoticeInfo(JSONObject param) throws Exception;

    JSONObject updateNoticeInfo(JSONObject param) throws Exception;

}
