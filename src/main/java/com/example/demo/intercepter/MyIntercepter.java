package com.example.demo.intercepter;

import com.example.demo.wrapper.ResponseWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyIntercepter implements HandlerInterceptor {
    /**
     * 进入handler之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * 进入handler之后，返回model之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

//        ResponseWrapper responseWrapper = new ResponseWrapper(response);
//        String contentType = responseWrapper.getContentType();
//        byte[] content = responseWrapper.getResponseData();
//        String str = "";
//        if (StringUtils.isNotBlank(contentType) && (contentType.contains(MediaType.APPLICATION_JSON_VALUE) || contentType.contains(MediaType.TEXT_HTML_VALUE))) {
//            str = new String(content);
//            str = str+",intercepter";
//            writeResponse((HttpServletResponse)responseWrapper,200,str);
//            PrintWriter writer = response.getWriter();
//            writer.write(str, 0, str.length());
//            writer.close();
//        }
    }

    /**
     * 返回model之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

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
