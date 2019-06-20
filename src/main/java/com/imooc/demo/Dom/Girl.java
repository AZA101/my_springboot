package com.imooc.demo.Dom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @author YJB
 * 2019-05-31
 */
@Entity//该注解表示该类对应数据库的一个表
public class Girl {
    @Id
    @GeneratedValue //系统自增
    private Integer id;
    private String cupSize;
    @Min(value =18,message = "年龄不能低于18岁")  //最小值注解
    private Integer age;
//建立构造方法，选择无参数的，必须选择无参数的
    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }

}
