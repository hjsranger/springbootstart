package com.hjs.starter.controller;

import com.hjs.starter.model.Foo;
import com.hjs.starter.service.EhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jianshuang_huang on 2018/10/31.
 */
@RestController
public class HelloController {

    @Autowired
    private EhcacheService ehcacheService;

    @RequestMapping("/hello")
    public String hello(){
        //return "hello world!";

        Foo foo = new Foo();
        foo.setId("186");
        Foo f = ehcacheService.findOne(foo);

        System.out.println(f.getTitle());

        return "OK";
    }

}
