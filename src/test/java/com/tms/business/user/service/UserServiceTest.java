package com.tms.business.user.service;

/**
 * Created by xiongzhanyuan on 2017/9/18.
 */

import com.tms.Application;
import com.tms.business.user.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by xiongzhanyuan on 2017/9/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles(profiles = "dev")
public class UserServiceTest {

    @Autowired
    UserInfoService userInfoService;
    @Test
    public void getUserInfoTest() throws Exception {
        System.out.println("=================result:");
        System.out.println(userInfoService.getUserInfo("1").toJSONString());
    }

}
