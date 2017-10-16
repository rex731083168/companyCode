package com.bruce.thread;

import java.util.Random;

public class Producer implements Runnable {
	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
	}

	@Override
	public void run() {
		synchronized(drop) {
			String importantInfo[] = { "Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid eat ivy too" };
			Random random = new Random();
			for (int i = 0; i < importantInfo.length; i++) {
				drop.put(importantInfo[i]);
				try {
					Thread.sleep(random.nextInt(5000));
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
			drop.put("DONE");
		}
	}
}
