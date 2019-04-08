package com.taotao.config;

import com.taotao.filter.Log4jFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @version:
 * @author: dongkaijia
 * @create: 2019-04-08 13:59
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean buildLog4jFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(new Log4jFilter());
        filterRegistrationBean.setName("log4jFilter");
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

}
