package com.example.web.common.base;

import com.example.web.common.enums.ResponseEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {

    private Integer code;

    private String message;

    private T data;

    public Response(){}

    public Response(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Response<T> responseSuccess(T data){
        return new Response(ResponseEnum.SUCCESS.getCode(), ResponseEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Response<T> responseFail(T data){
        return new Response(ResponseEnum.FAIL.getCode(), ResponseEnum.FAIL.getMessage(), data);
    }
}
