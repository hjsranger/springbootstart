package com.hjs.starter.utils;

import java.util.UUID;

/**
 * Created by jianshuang_huang on 2018/10/16.
 */
public class StringUtils {

    public static String getUUID(){
        String id = UUID.randomUUID().toString();
        id = id.replace("-","");
        return id;
    }

}
