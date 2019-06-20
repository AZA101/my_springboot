package com.imooc.demo.Dom;

/**
 * @author YJB
 * 2019-06-20
 * http请求返回的最外层对象
 */
public class Result <T> {
    /*错误编码,0为失败，1为成功*/
    private  Integer  code;

    /*错误提示信息*/
    private  String  msg;

   /*错误内容*/
    private  T  datas;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
