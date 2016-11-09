package com.bruce.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author admin
 *
 */
public class JsonAndJavaBean {
     public static void main(String[] args) {
    	 String text = "{'Id':'testFastJson001','name':'maks','city':'广州','age':105,'date':'2016-07-20','ss':{'name':'FAIL','value':'2'}}";
    	 JSONObject jsonObject = JSON.parseObject(text);
    	 JSONObject jsonObject2  = jsonObject.getJSONObject("ss");
    	 //System.out.println(jsonObt2);
    	 Student ss =(Student) JSON.parseObject(text,Student.class);
    	 System.out.println(ss.getSs().getName());
	}
}
