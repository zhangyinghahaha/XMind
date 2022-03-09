package com.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ying.zhang01
 */
public class FastJsonTest {
    public static void main(String[] args) {
        String json = "\"hello,fastjson\"";
        JSONObject jsonObject = JSON.parseObject(json);
        System.out.println(jsonObject.getString(""));
    }
}
