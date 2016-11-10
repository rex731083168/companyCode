package com.Demo.regx;
/**
 * 正则替换字符串
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo {
    public static void main(String[] args) {
		String patten = "d[ae]{1,2}mon";
		String string = "Unix has demons and deamons in it";
		Matcher matcher = Pattern.compile(patten).matcher(string);
		System.out.println("ReplaceAll:"+matcher.replaceAll("daemon"));
		matcher.reset();
		StringBuffer sBuffer = new StringBuffer();
		while(matcher.find()){
			//将第一个匹配到的前面的字符串赋值到sbuffer，并将匹配到的变为“daemon”
			matcher.appendReplacement(sBuffer, "daemon");
		}
		//将最后匹配到的剩余字符串赋值到sbuffer，
		matcher.appendTail(sBuffer);//将
		System.out.println("Append:"+sBuffer);
	}
}
