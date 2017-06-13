package com.Dmeo.myspce;

public class NameTest {
	public static void main(String[] args) {
        String name = "罗团";
        if(name.length()==2){
        	name = name.replace(name.substring(1, name.length()), "*");
        }else if (name.length()==3) {
        	name = name.replace(name.substring(1, name.length()-1), "*");
		}else if (name.length()==4) {
			name = name.replace(name.substring(1, name.length()-1), "**");
		}
        System.out.println(name);
	}
}
