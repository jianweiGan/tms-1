package com.tms.business.bus.service.impl;

import com.tms.business.bus.service.TbLogService;
import com.tms.business.domain.TbLog;
import com.tms.business.mapper.TbLogMapper;
import com.tms.common.helper.UUIDHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Service(value = "service/tb_log/operate")
public class TbLogServiceImpl implements TbLogService {

    @Autowired
    private TbLogMapper tbLogMapper;

    @Override
    public void addTbLog(String userId, String tableName, String dataId, Integer flag) throws Exception {

        TbLog tbLog = new TbLog();
        tbLog.setId(UUIDHelper.getUUID());
        tbLog.setUserId(userId);
        tbLog.setTableName(tableName);
        tbLog.setDataId(dataId);
        tbLog.setFlag(flag);
        tbLog.setCreateTime(new Date());

        tbLogMapper.insert(tbLog);

    }
}
