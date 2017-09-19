package com.tms.business.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qiniu.util.Auth;
import com.tms.business.common.service.CommonService;
import com.tms.common.helper.JOHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by xiongzhanyuan on 2017/9/14.
 */
@Service(value = "service/common/operate")
public class CommonServiceImpl implements CommonService {

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Value("${qiniu.access.key}")
    private String accessKey;
    @Value("${qiniu.secret.key}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    private Long expire = 5400000L;

    @Override
    public JSONObject getToken() {
        Auth auth = Auth.create(accessKey, secretKey);
        return JOHelper.gen("data", auth.uploadToken(bucket, null, expire / 1000L, null));
    }
}
