package com.bruce.json;

import java.text.SimpleDateFormat;
import java.util.Date;

import se.akerfeldt.com.google.gson.Gson;
import se.akerfeldt.com.google.gson.GsonBuilder;

public class GjsonDemo {
	public static void main(String[] args) {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd");
		String text = "{'Id':'testFastJson001','name':'maks','city':'广州','age':105,'date':'2016-07-20','ss':{'name':'FAIL'}}";
		Gson gson = new GsonBuilder()
				  .serializeNulls()  
				  .disableInnerClassSerialization()
				  .setDateFormat("yyyy-MM-dd")  
				  .setPrettyPrinting()
				  .create(); 
		Student ss = gson.fromJson(text, Student.class);
		//Date date = ss.getDate();
		//ss.setDate(sFormat.format(date));
		System.out.println(ss.getAge());
	}
}
