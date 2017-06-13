package com.pratice;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        while(scanner.hasNext()){
        	System.out.println("您的输入是:"+scanner.next());
        }
	}
}
