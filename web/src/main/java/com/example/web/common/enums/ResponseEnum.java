package com.example.web.common.enums;

public enum ResponseEnum {
    SUCCESS(200, "操作成功:)"),
    FAIL(500, "失败:(");

    private Integer code;

    private String message;


    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
