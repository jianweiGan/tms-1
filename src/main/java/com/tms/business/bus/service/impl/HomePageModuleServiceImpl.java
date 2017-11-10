package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tms.business.bus.service.HomePageModuleService;
import com.tms.business.bus.service.TbLogService;
import com.tms.business.domain.HomePageModule;
import com.tms.business.mapper.HomePageModuleMapper;
import com.tms.common.exception.BussinessException;
import com.tms.common.exception.ErrorCodeEnum;
import com.tms.common.helper.JOHelper;
import com.tms.common.helper.UUIDHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;

/**
 * Created by xiongzhanyuan on 2017/2/21.
 */
@Transactional
@Service(value = "service/home_page/operate")
public class HomePageModuleServiceImpl implements HomePageModuleService {

    @Autowired
    private HomePageModuleMapper homePageModuleMapper;

    @Autowired
    private TbLogService tbLogService;

    @Override
    public JSONObject getHomePageModule(String id) throws Exception {

        if (StringUtils.isBlank(id)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        HomePageModule homePageModule = homePageModuleMapper.selectByPrimaryKey(id);

        if (ObjectUtils.isEmpty(homePageModule)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(homePageModule);

        return jsonObject;
    }

    @Override
    public JSONObject selectList(JSONObject param) throws Exception {

        JSONObject pageJson = param.getJSONObject("page");

        if (ObjectUtils.isEmpty(pageJson)) {
            PageHelper.startPage(1, 10); // 核心分页代码
        } else {
            PageHelper.startPage(pageJson.getIntValue("pageNo"), pageJson.getIntValue("pageSize")); // 核心分页代码
        }

        HomePageModule homePageModule = new HomePageModule();

        Page<HomePageModule> page = homePageModuleMapper.selectList(homePageModule);

        JSONObject result = new JSONObject();
        result.put("list", page.getResult());
        result.put("totalCount", page.getTotal());
        result.put("pageSize", page.getPageSize());
        return result;
    }

    @Override
    public JSONObject addHomePageModule(JSONObject param, String token) throws Exception {

        HomePageModule homePageModule = JOHelper.jo2class(param, HomePageModule.class);
        homePageModule.setId(UUIDHelper.getUUID());
        homePageModule.setFlagDelete(7);
        homePageModule.setSort(0);
        homePageModule.setCreateTime(new Date());
        homePageModule.setModifyTime(new Date());

        homePageModuleMapper.insert(homePageModule);

        tbLogService.addTbLog(token, "home_page_module", homePageModule.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateHomePageModule(JSONObject param, String token) throws Exception {

        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        HomePageModule homePageModule = JOHelper.jo2class(param, HomePageModule.class);
        homePageModule.setModifyTime(new Date());

        homePageModuleMapper.updateByPrimaryKey(homePageModule);

        tbLogService.addTbLog(token, "home_page_module", homePageModule.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject deleteHomePageModule(JSONObject param, String token) throws Exception {
        String id = param.getString("id");
        Integer flagDelete = param.getInteger("flagDelete");
        if (StringUtils.isBlank(id) || ObjectUtils.isEmpty(flagDelete)) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }

        HomePageModule homePageModule = new HomePageModule();
        homePageModule.setId(id);
        homePageModule.setFlagDelete(flagDelete);

        homePageModuleMapper.updateByPrimaryKeySelective(homePageModule);

        tbLogService.addTbLog(token, "home_page_module", homePageModule.getId(), 3);

        JSONObject result = new JSONObject();
        result.put("data", "删除成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject multiDownHome(JSONObject param, String token) throws Exception {

        if (ObjectUtils.isEmpty(param.getJSONArray("list"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSINGByMultiDown);
        }

        if (0 >= param.getJSONArray("list").size()) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSINGByMultiDown);
        }

        JSONArray jsonArray = param.getJSONArray("list");

        jsonArray.forEach(id -> {
            HomePageModule homePageModule = new HomePageModule();
            homePageModule.setId((String) id);
            homePageModule.setFlagDelete(7);
            homePageModule.setModifyTime(new Date());

            homePageModuleMapper.updateByPrimaryKeySelective(homePageModule);

            try {
                tbLogService.addTbLog(token, "home_page_module", homePageModule.getId(), 3);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });


        JSONObject result = new JSONObject();
        result.put("data", "批量下线成功");
        result.put("status", 1);
        return result;
    }
}
