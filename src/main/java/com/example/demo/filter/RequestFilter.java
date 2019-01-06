package com.example.demo.filter;

import com.example.demo.utils.AesEncryptUtil;
import com.example.demo.wrapper.RequestWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
@Component
public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        Enumeration<String> en = request.getParameterNames();
        Map<String, Object> extraParams = new HashMap<String, Object>();
        try {
            while (en.hasMoreElements()) {
                String key = en.nextElement();
                String[] arr = request.getParameterValues(key);
                String value = "";
                if (arr != null && arr.length > 0) {
                    value = AesEncryptUtil.desEncrypt(arr[0]);
                }
                System.out.println(key+"解密后："+value);
                extraParams.put(key, value);
            }
            //利用原始的request对象创建自己扩展的request对象并添加自定义参数
            RequestWrapper requestParameterWrapper =new RequestWrapper(request);
            requestParameterWrapper.addParameters(extraParams);
            filterChain.doFilter(requestParameterWrapper, servletResponse);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
