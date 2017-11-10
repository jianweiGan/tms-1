package com.tms.business.bus.service;

public interface TbLogService {
    void addTbLog(String userId, String tableName, String dataId, Integer flag) throws Exception;
}
