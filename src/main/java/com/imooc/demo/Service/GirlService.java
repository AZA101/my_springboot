package com.imooc.demo.Service;

import com.imooc.demo.Dom.Girl;
import com.imooc.demo.Enums.ResultEnum;
import com.imooc.demo.Exception.GirlException;
import com.imooc.demo.Repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YJB
 * 2019-066-14
 */
@Service
public class GirlService {
    /**
     * 批量新增，测试事务操作
     */
    @Autowired
    private GirlRepository girlRepository;

    @Transactional  //事务注解
    public void grilInsert(){
       Girl girl=new Girl();
       girl.setAge(22);
       girl.setCupSize("D");
       girlRepository.save(girl);

       Girl girl1=new Girl();
        girl1.setAge(25);
        girl1.setCupSize("D");
       girlRepository.save(girl1);
    }

    /**
     * @param id
     * @throws Exception
     * 哪里调用该方法，就将异常抛回去给哪里
     */
    public void getAge(Integer id)throws Exception{
        Girl girl=girlRepository.findOne(id);
        Integer age=girl.getAge();
       if(age<=10){
           /*应该还在上小学*/
           throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
       }else if(age>=11&& age<16){
           /*应该是在读初中*/
           throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
       }else if(age>=17&& age<19){
           /*应该是在读高中*/
           throw new GirlException(ResultEnum.HIGH_SCHOOL);
       }
    }

    /**
     * service层中建立一个查询id的方法
     * @param id
     * @return
     */
    public Girl findOneId(Integer id){
       return girlRepository.findOne(id);
    }
}
