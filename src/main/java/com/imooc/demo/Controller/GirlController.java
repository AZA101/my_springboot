package com.imooc.demo.Controller;

import com.imooc.demo.Dom.Girl;
import com.imooc.demo.Dom.Result;
import com.imooc.demo.Repository.GirlRepository;
import com.imooc.demo.Service.GirlService;
import com.imooc.demo.Utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author YJB
 * 2019-06-01
 */
@RestController
public class GirlController {

    //定义该java类下的日志变量，用日志输出语句来替代传统的sout输出语句
    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);

    @Autowired  //按照类型装配依赖对象
    private GirlRepository girlRepository;
    @Autowired  //调用service
    private GirlService girlService;

    @GetMapping(value = "/glist")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }
    /**
     * 添加一条数据
     * @return
     */
    @PostMapping(value = "/gadd")
    /*public Girl girlAdd(@RequestParam("age") Integer age,
                        @RequestParam("cupSize") String cupSize) {
        System.out.println("age："+age+"， cupSize："+cupSize);
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }*/
  //当参数特别多的时候，可以直接定义对应数据库表的类对象
    public Result<Girl> girlAdd(@Valid  Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){

            return ResultUtils.error(0,bindingResult.getFieldError().getDefaultMessage());

           /* System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null ;*/
        }
            girl.setAge(girl.getAge());
            girl.setCupSize(girl.getCupSize());
            return  ResultUtils.success(girlRepository.save(girl));
          //  return girlRepository.save(girl);
    }

    /**
     * 查询其中一条数据
     * @param id
     * @return
     */
    @GetMapping(value = "/hh")
    public Girl girlSelect(@RequestParam("id") Integer id) {
        return girlRepository.findOne(id);

    }

    /**
     * 更新数据
     * @param id
     * @param age
     * @param cupSize
     * @return
     */
    @PutMapping(value = "/up")
    public Girl girlUpdate(@RequestParam("id") Integer id,
                           @RequestParam("age") Integer age,
                           @RequestParam("cupSize") String cupSize) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除一条数据，根据主键
     * @param id
     */
    //@DeleteMapping(value = "/de")
    @GetMapping(value="/de")
   // public void girlDelect(@PathVariable("id") Integer id) {
    public void girlDelect(@RequestParam("id") Integer id) {
        //System.out.println("显示接收的主键:" + id);
        logger.info("显示接收的主键:"+id);
         girlRepository.delete(id);
    }

    /**
     * @author YJB
     * 根据年龄查询人员信息
     */
    @GetMapping(value = "/age")
    public List<Girl> girlListByAge(@RequestParam("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @GetMapping(value="/datainsert")
    public void girlTwo(){
        girlService.grilInsert();
    }
    @PostMapping(value ="/Ages")
    public void getAge(@RequestParam("id") Integer id)throws Exception{
        girlService.getAge(id);
    }

}
