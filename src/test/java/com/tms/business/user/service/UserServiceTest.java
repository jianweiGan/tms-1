package com.tms.business.user.service;

/**
 * Created by xiongzhanyuan on 2017/9/18.
 */

import com.tms.Application;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
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

//    @Autowired
//    UserInfoService userInfoService;
    @Test
    public void getUserInfoTest() throws Exception {
        String[] detailArr = "3个月身份证关联手机号数：2".split("：");
        System.out.println("");

        if(NumberUtils.isNumber(detailArr[1])){

            int num = Integer.valueOf(detailArr[1]);
            if(num>=2){
                System.out.println("123");
            }
        }
//        System.out.println("=================result:");
//        System.out.println(userInfoService.getUserInfo("1").toJSONString());
    }

}
