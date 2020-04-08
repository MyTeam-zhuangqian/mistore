package com.example.mistroe.util;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * @author zlin
 * @date 2020/4/7 14:22
 */
public class Result {
    private Integer status;
    private String message;
    private Integer total;
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
