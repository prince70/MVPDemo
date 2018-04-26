package com.niwj.mvptest.net;

/**
 * code : 0
 * message : 成功
 * content :
 *
 * Created by Administrator on 2017/6/19.
 */

public class BasePojo<T> {

    private int code;
    private String message;
    private T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BasePojo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
