package com.tms.business.bus.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
public interface SmallProgramService {

    JSONObject selectHomePageList(JSONObject param) throws Exception;

    JSONObject aboutTms(JSONObject param) throws Exception;

    JSONObject getScenicInfo(JSONObject param) throws Exception;

    JSONObject addFeedBack(JSONObject param) throws Exception;

    JSONObject getTmsLegend(JSONObject param) throws Exception;

    JSONObject getTmsLegendActivity(JSONObject param) throws Exception;

    JSONObject getTmsActivityDetail(JSONObject param) throws Exception;

    JSONObject getMinJianChuanShuo(JSONObject param) throws Exception;

    JSONObject getMinJianChuanShuoDetail(JSONObject param) throws Exception;

    JSONObject getScenisInfo(JSONObject param) throws Exception;

    JSONObject selectWonderfulPhotoList(JSONObject param) throws Exception;

    JSONObject getWonderfulPhotoInfo(JSONObject param) throws Exception;

    JSONObject addWonderfulPhotoInfo(JSONObject param) throws Exception;

    JSONObject selectMapList(JSONObject param) throws Exception;

}
