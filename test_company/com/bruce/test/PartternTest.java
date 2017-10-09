package com.bruce.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartternTest {
    public static void main(String[] args) {
        String regEx =  ".*[[0-9]，。<>《》？、/\\【】{}（）“”‘’：；！@#￥$%……^&*-=+__]+.*";
        String str = "马姚11";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        System.out.println(m.matches());
        System.out.println(str.matches(regEx));
        System.out.println("罗团"=="罗团");
	}
}
