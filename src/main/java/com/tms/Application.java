package com.tms;

import com.tms.mybatis.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by xiongzhanyuan on 2017/9/6.
 */
@Configuration
@EnableWebMvc
@SpringBootApplication
@EnableTransactionManagement
@ImportResource(value={"classpath*:spring/spring.xml"})
@Import(value = {DataSourceConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
