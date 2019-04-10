package com.pose.doc_core.enumration;

public enum ResultMessage {


    OK(0, "OK"),
    QUERY_SUCCESS(0, "查询成功"),
    EXECUTE_SUCCESS(0, "操作成功"),

    ERROR(1, "请求异常"),
    NO_LOGGED_IN(2, "未登录或登录超时"),
    QUERY_FAIL(3, "查询失败"),
    EXECUTE_FAIL(4, "操作失败"),
    NO_PERMISSION(5, "无访问权限"),
    OTHER(1000, "自定义异常");


    private Integer code;

    private String message;

    ResultMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
