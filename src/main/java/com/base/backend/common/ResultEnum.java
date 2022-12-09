package com.base.backend.common;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(200, "成功"),
    ERROR(400, "失败")
    ;


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}