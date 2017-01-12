package com.Dmeo.myspce;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialize implements Serializable {
	private static final long serialVersionUID = 1L;
	public int num = 12;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("D:\\bruce\\Serialize.dat");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fs = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fs);
		Serialize serialize = new Serialize();
		oos.writeObject(serialize);
		oos.flush();
		byte[] by = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] bb = new byte[2048];
		int ch;
		ch = fis.read(bb);
		while (ch != -1) {
			bos.write(bb, 0, ch);
			ch = fis.read(bb);
		}
		by = bos.toByteArray();
		System.out.println(by.length);
		/*
		 * ObjectInputStream ois = new ObjectInputStream(fis); Serialize ss =
		 * (Serialize) ois.readObject(); System.out.println("******"+ss.num);
		 */
		oos.close();
		fis.close();
	}
}
