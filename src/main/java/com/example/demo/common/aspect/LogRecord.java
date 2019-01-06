package com.example.demo.common.aspect;

import com.example.demo.common.annotation.Log;

import java.lang.reflect.Method;

public class LogRecord {
    public static void writeLog(Object obj){
        Class<?> clazz=obj.getClass();
        Method[] methods=clazz.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method=methods[i];
            Log logAnnotaion=(Log)method.getAnnotation(Log.class);
            if(logAnnotaion!=null){
                System.out.println("methodName:"+method.getName());
                System.out.println("log_value:"+logAnnotaion.value());
                System.out.println("log_des:"+logAnnotaion.description());
            }

        }


    }

}
