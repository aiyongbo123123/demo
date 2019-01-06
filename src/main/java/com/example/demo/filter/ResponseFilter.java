package com.example.demo.filter;

import com.example.demo.utils.AesEncryptUtil;
import com.example.demo.wrapper.ResponseWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

@Component
public class ResponseFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String URL = request.getRequestURL().toString();
        try {
            if (URL.indexOf(".do")<0) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) servletResponse);
                filterChain.doFilter(servletRequest, responseWrapper);
                String contentType = responseWrapper.getContentType();
                byte[] content = responseWrapper.getResponseData();
                String str = "";
                if (StringUtils.isNotBlank(contentType) && (contentType.contains(MediaType.APPLICATION_JSON_VALUE) || contentType.contains(MediaType.TEXT_HTML_VALUE))) {
                    str = new String(content);
                    str = AesEncryptUtil.encrypt(str);
                    System.out.println("filter:" + str);
                    HttpServletResponse response = (HttpServletResponse) servletResponse;
                    writeResponse(response, 200, str);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void writeResponse(HttpServletResponse response, int status, String json) {
        try {
            response.reset();//很重要
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(status);
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}