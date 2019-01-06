package com.example.demo.config.intercepter;

import com.example.demo.intercepter.AIntercepter;
import com.example.demo.intercepter.MyIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@SpringBootConfiguration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private MyIntercepter myIntercepter;
    @Autowired
    private AIntercepter aIntercepter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myIntercepter).addPathPatterns("/**");
        registry.addInterceptor(aIntercepter).addPathPatterns("/**");
    }
}
