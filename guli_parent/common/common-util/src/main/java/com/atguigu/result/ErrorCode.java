package com.atguigu.result;

/**
 * @author kyrie
 */
public enum ErrorCode {
    INNER_ERROR("服务器内部错误",500),
    NOT_FIND("请求资源不存在",404);
    private String msg;
    private int code;
    ErrorCode(String msg,int code){
        this.msg=msg;
        this.code=code;
    }
    public int getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }
}
