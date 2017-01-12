package com.Dmeo.myspce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFile {
	public static void main(String[] args) {
		String fileLoad = "C:/Users/admin/Desktop/111.txt";
		BufferedReader bufferedReader;
		File file = new File(fileLoad);
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "gbk"));
			String line = bufferedReader.readLine();
			while (line != null) {
               System.out.println(line);
               line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
