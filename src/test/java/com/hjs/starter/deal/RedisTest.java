package com.hjs.starter.deal;

import com.hjs.starter.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){

        redisUtil.set("name","hjs");

        System.out.println(redisUtil.get("name"));

    }

}
