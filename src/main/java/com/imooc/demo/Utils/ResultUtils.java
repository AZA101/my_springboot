package com.imooc.demo.Utils;

import com.imooc.demo.Dom.Result;

/**
 * @author YJB
 * 2019-06-20
 * 调用返回成功或者失败的方法
 */
public class ResultUtils {

    public static Result success(Object object){
        Result result=new Result();
        result.setCode(1);
        result.setMsg("操作成功");
        result.setDatas(object);
        return result;
    }

     public static Result success(){
         return success(null);
     }

     public static Result error( Integer code,Object object){
         Result result=new Result();
         result.setCode(code);
         result.setMsg("操作失败");
         result.setDatas(object);
         return result;
     }
}
