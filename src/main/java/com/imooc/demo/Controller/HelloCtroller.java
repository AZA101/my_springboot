package com.imooc.demo.Controller;

import com.imooc.demo.Property.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yjb
 * *
 */
@RestController
//@Controller
public class HelloCtroller {
  /*  @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private String age;
    @Value("${content}")
    private String content;*/

  @Autowired
  private GirlProperties girlProperties;


    //@RequestMapping(value = "/hello/{id}", method = RequestMethod.GET)
    /*public String say(@PathVariable("id")Integer id) {*/
   // @RequestMapping(value = "/hello", method = RequestMethod.GET)
  @GetMapping(value="/hello")
    public String say(@RequestParam(value = "id",required = false,defaultValue="0")Integer id) {
        // return  "hello spring booot";
        //return cupSize+age;
        //return content;
      //return  girlProperties.getCupSize();
      //return "index";
      return "id="+id;

    }
}
