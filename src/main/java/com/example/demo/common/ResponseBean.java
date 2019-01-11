package com.example.demo.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @Project: gktj
 * @Package: com.zr.common
 * @Author: 冯前进
 * @Date: 2018-11-06 17:18
 * @Description: TODO
 **/
public class ResponseBean implements Serializable {
    private Object code;//code 200 取data数据，否则弹出错误提示message
    private String message;
    private Object data;
    private Long datetime=new Date().getTime();

    public ResponseBean() {
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getDatetime() {
        return datetime;
    }

    public void setDatetime(Long datetime) {
        this.datetime = datetime;
    }

    public ResponseBean(Object code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseBean(Object code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
