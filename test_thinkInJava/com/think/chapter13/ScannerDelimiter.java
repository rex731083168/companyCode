package com.think.chapter13;

import java.util.Scanner;

public class ScannerDelimiter {
    public static void main(String[] args) {
		Scanner scanner = new Scanner("name,tom,age,12,sex,男");
		scanner.useDelimiter("\\s*,\\s*");
		//System.out.println(scanner);
		System.out.println(scanner.nextLine());
	}
}
