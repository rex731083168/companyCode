package com.Dmeo.myspce;

public class TestSplit {
    public static void main(String[] args) {
		String arr = "爱康体检，为未来做准备*****想知道自己有多健康吗？想知道自己的身体有哪些潜在的危机吗？只要99分，兑换爱康国宾体检卡，让你随时知道你自己有多棒，只限金钻用户哦。";
		String[] arr1 = arr.split("\\*\\*\\*\\*\\*");
		System.out.println(arr1[1]);
	}
}
