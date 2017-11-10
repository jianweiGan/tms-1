package com.tms;

import com.tms.intercepter.CrossDomainInterceptor;
import com.tms.intercepter.OpearteInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ImportResource(value={"classpath*:spring/mvc.xml"})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //  跨域访问
        registry.addInterceptor(new CrossDomainInterceptor()).addPathPatterns("/**");

        //接口拦截器
        registry.addInterceptor(new OpearteInterceptor()).addPathPatterns("/**/update*");

    }

}
