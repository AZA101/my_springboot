package com.imooc.demo.Enums;

import org.springframework.context.annotation.Primary;

/**
 * @author YJB
 * 2019-06-20
 * 将提示或者错误信息进行枚举
 */
public enum ResultEnum {
     UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(1,"操作成功"),
    ERROR(0,"操作失败"),
    PRIMARY_SCHOOL(100,"应该在读小学"),
    MIDDLE_SCHOOL(101,"应该在读初中"),
    HIGH_SCHOOL(102,"应该在读高中")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

  }
