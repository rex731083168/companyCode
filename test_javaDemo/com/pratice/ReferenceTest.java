package com.pratice;

import java.lang.ref.WeakReference;

public class ReferenceTest {
	public static void main(String[] args) {
         String str = new String("你好啊");
         WeakReference wr = new WeakReference(str);
         str = null;
         System.out.println(wr.get());
         System.gc();
         System.runFinalization();
         System.out.println(wr.get());
	}
}
