package com.imooc.demo.Handle;

import com.imooc.demo.Dom.Result;
import com.imooc.demo.Exception.GirlException;
import com.imooc.demo.Utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author YJB
 * 2019-06-20
 *
 */
@ControllerAdvice
public class ExceptionlHandle {
    private  final  static Logger logger= LoggerFactory.getLogger(ExceptionlHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //instanceof是Java中的二元运算符，左边是对象，右边是类；当对象是右边类或子类所创建对象时，返回true；
        if(e instanceof GirlException){
            GirlException girlException=(GirlException) e;
            /*从这调用工具类时候只传了两个参数，那边默认写了一个操作失败，所以打印出来的json格式数据msg那里都是操作失败*/
                return  ResultUtils.error(girlException.getCode(),girlException.getMessage());
        }
        logger.error("系统异常 {}",e);
       return ResultUtils.error(-1,"未知的错误");
    }
}
