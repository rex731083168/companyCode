package com.bruce.thread;

public class SimpleThreads {
	public static String importantInfo[] = { "母马吃燕麦", "狗吃骨头", "小马吃奶", "小孩吃奶" };

	// 显示信息，一部分输出当前线程的名字，一部分输出传入的信息
	static void printMessage(String message) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s%n", threadName, message);
	}

	private static class MessageLoop implements Runnable {
		public void run() {

			try {
				for (int i = 0; i < importantInfo.length; i++) {
					Thread.sleep(4000);
					printMessage(importantInfo[i]);
				}
			} catch (InterruptedException e) {
				printMessage("我不想死！");
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {

		long patience = 1000 * 10;
		printMessage("创建MessageLoop线程");
		long startTime = System.currentTimeMillis();
		Thread t = new Thread(new MessageLoop());
		t.start();
		t.join(1000);
		while (t.isAlive()) {
			printMessage("等待MessageLoop线程结束");
			t.join(1000);// join有参数，会阻塞1000秒。此后不管子线程是否结束，都会执行主线程。多次调用的结果和一次调用是一样的，只不过增加了阻塞。
			if (((System.currentTimeMillis() - startTime) > patience) && t.isAlive()) {
				printMessage("等待时间过长，中断MessageLoop线程");
				t.interrupt();
				t.join();
			}
		}
		printMessage("结束!");
	}
}
