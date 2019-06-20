package com.imooc.demo;

import com.imooc.demo.Dom.Girl;
import com.imooc.demo.Service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试service
 * @RunWith 表示在测试环境中跑
 * @SpringBootTest 启动整个springboot
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlTestService {
    @Autowired
    private GirlService girlService;
    @Test
    public void findOneTest(){
        Girl girl=girlService.findOneId(4);
        //使用断言,将输入值与系统查出来的值进行比较
        Assert.assertEquals( new Integer(18),girl.getAge());
    }

}
