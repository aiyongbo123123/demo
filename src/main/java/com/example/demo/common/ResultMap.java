package com.example.demo.common;

/**
 * @Project: gktj
 * @Package: com.zr.common
 * @Author: 冯前进
 * @Date: 2018-11-29 15:39
 * @Description: TODO
 **/
public class ResultMap<T> {

    private String msg;

    private int code;

    private T data;

    private int count;
    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 是否有下一页
     */
    private boolean flag;
    public ResultMap() {
        super();
    }

    public ResultMap(int code, String message) {
        super();
        this.code = code;
        this.msg = message;
    }

    public ResultMap(int code, String message, T data, int count) {
        super();
        this.code = code;
        this.msg = message;
        this.data = data;
        this.count = count;
    }
    public ResultMap(int code, String msg, T data, int count, int currentPage, int pageSize, boolean flag) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

