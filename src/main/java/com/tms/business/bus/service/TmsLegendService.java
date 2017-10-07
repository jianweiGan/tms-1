package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface TmsLegendService {

    JSONObject getLegendInfo() throws Exception;

    JSONObject addLegendInfo(JSONObject param) throws Exception;

    JSONObject updateLegendInfo(JSONObject param) throws Exception;

    JSONObject fetchLegendActivityList(JSONObject param) throws Exception;

    JSONObject getLegendActivityInfo(@RequestParam("id") String id) throws Exception;

    JSONObject addLegendActivityInfo(JSONObject param) throws Exception;

    JSONObject updateLegendActivityInfo(JSONObject param) throws Exception;

    JSONObject deleteLegendActivityInfo(JSONObject param) throws Exception;

}
