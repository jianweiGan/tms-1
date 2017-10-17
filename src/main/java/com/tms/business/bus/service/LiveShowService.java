package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface LiveShowService {

    JSONObject fetchLiveShowList(JSONObject param) throws Exception;

    JSONObject getLiveShowInfo(@RequestParam("id") String id) throws Exception;

    JSONObject addLiveShowInfo(JSONObject param) throws Exception;

    JSONObject updateLiveShowInfo(JSONObject param) throws Exception;

    JSONObject deleteLiveShowInfo(JSONObject param) throws Exception;

}
