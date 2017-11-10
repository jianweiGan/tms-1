package com.tms.business.bus.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tms.business.bus.service.CustomNoticeService;
import com.tms.business.bus.service.TbLogService;
import com.tms.business.domain.CustomNotice;
import com.tms.business.mapper.CustomNoticeMapper;
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

@Transactional
@Service(value = "service/notice/operate")
public class CustomNoticeServiceImpl implements CustomNoticeService {

    @Autowired
    private CustomNoticeMapper customNoticeMapper;

    @Autowired
    private TbLogService tbLogService;

    @Override
    public JSONObject getNoticeInfo() throws Exception {

        CustomNotice customNotice = customNoticeMapper.getCustomNotice();

        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(customNotice);

        return jsonObject;
    }

    @Override
    public JSONObject addNoticeInfo(JSONObject param, String token) throws Exception {

        CustomNotice customNotice = JOHelper.jo2class(param, CustomNotice.class);
        customNotice.setId(UUIDHelper.getUUID());
        customNotice.setFlagDelete(0);
        customNotice.setCreateTime(new Date());
        customNotice.setModifyTime(new Date());

        customNoticeMapper.insert(customNotice);

        tbLogService.addTbLog(token, "custom_notice", customNotice.getId(), 1);

        JSONObject result = new JSONObject();
        result.put("data", "添加成功");
        result.put("status", 1);
        return result;
    }

    @Override
    public JSONObject updateNoticeInfo(JSONObject param, String token) throws Exception {
        if (StringUtils.isBlank(param.getString("id"))) {
            throw new BussinessException(ErrorCodeEnum.PARAMETERMISSING);
        }
        CustomNotice customNotice = JOHelper.jo2class(param, CustomNotice.class);
        customNotice.setModifyTime(new Date());

        customNoticeMapper.updateByPrimaryKey(customNotice);

        tbLogService.addTbLog(token, "custom_notice", customNotice.getId(), 2);

        JSONObject result = new JSONObject();
        result.put("data", "修改成功");
        result.put("status", 1);
        return result;
    }
}
