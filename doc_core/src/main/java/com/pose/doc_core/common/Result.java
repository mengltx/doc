package com.pose.doc_core.common;

import com.pose.doc_core.enumration.ResultMessage;

public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构建结果
     * @param resultMessage
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> build(ResultMessage resultMessage, T data) {

        return new Result<T>(resultMessage.getCode(), resultMessage.getMessage(), data);
    }


    /**
     * 构建自定义结果 code=100
     * @param customMessage
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> buildWithCustomMsg(String customMessage, T data) {
        return new Result<T>(ResultMessage.OTHER.getCode(), customMessage, data);
    }

    /**
     * 快速构建查询结果
     * @param success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> Query(Boolean success, T data) {

        ResultMessage resultMessage = success ? ResultMessage.QUERY_SUCCESS : ResultMessage.EXECUTE_FAIL;
        return new Result<>(resultMessage.getCode(), resultMessage.getMessage(), data);
    }

    /**
     * 快速构建执行结果
     * @param success
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> execute(Boolean success, T data) {

        ResultMessage resultMessage = success ? ResultMessage.EXECUTE_SUCCESS : ResultMessage.EXECUTE_FAIL;
        return new Result<>(resultMessage.getCode(), resultMessage.getMessage(), data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
