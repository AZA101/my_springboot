package com.imooc.demo.Exception;

import com.imooc.demo.Enums.ResultEnum;

/**
 * @author YJB
 * 2019-06-20
 * 自定义异常类
 */
public class GirlException extends RuntimeException{
    private  Integer code;  //全局变量，并且定义为private，因此需要get和set

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
