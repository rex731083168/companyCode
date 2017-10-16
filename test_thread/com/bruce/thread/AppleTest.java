package com.bruce.thread;

import com.bruce.thread2.MainLock;

public class AppleTest {
	private static final Object mainLock = MainLock.getInstance();

	public static void main(String[] args) {
		//生产苹果的线程
        Thread producer = new Thread(new AppleProducer(mainLock));
        ProcessThread process = new ProcessThread(mainLock);
        producer.start();
        process.init();
        process.start();
	}
}
