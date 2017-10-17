package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface WonderfulPhotoService {

    JSONObject fetchWonderfulPhotoList(JSONObject param) throws Exception;

    JSONObject getWonderfulPhotoInfo(@RequestParam("id") String id) throws Exception;

    JSONObject addWonderfulPhotoInfo(JSONObject param) throws Exception;

    JSONObject updateWonderfulPhotoInfo(JSONObject param) throws Exception;

    JSONObject onLineWonderfulPhotoInfo(JSONObject param) throws Exception;

    JSONObject offLineWonderfulPhotoInfo(JSONObject param) throws Exception;

}
