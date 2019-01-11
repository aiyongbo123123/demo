package com.example.demo.config.filter;

import com.example.demo.filter.RequestFilter;
import com.example.demo.filter.ResponseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

//@SpringBootConfiguration
public class FilterConfig {
//    @Autowired
//    private ResponseFilter responseFilter;
//
//    @Autowired
//    private RequestFilter requestFilter;
//
//    @Bean
//    public FilterRegistrationBean responseConfig() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(responseFilter);
//        List<String> filterList = new ArrayList<>();
//        filterList.add("/*");
//        filterRegistrationBean.setUrlPatterns(filterList);
//        filterRegistrationBean.setOrder(4);
//        return filterRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean requestConfig() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(requestFilter);
//        List<String> filterList = new ArrayList<>();
//        filterList.add("/*");
//        filterRegistrationBean.setUrlPatterns(filterList);
//        filterRegistrationBean.setOrder(3);
//        return filterRegistrationBean;
//    }
}
