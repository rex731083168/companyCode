package com.bruce.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class Worker implements Runnable {
	Thread thread = null;
	Runnable task;
	private BlockingQueue<Runnable> queues;

	public Worker(Runnable task, BlockingQueue<Runnable> queues) {
		this.thread = new Thread(this);
		this.task = task;
		this.queues = queues;
	}

	@Override
	public void run() {
		if (task != null) {
			task.run();
		}
		try {
			while (true) {
				task = queues.take();
				if (task != null) {
					task.run();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		this.thread.start();
	}

	public static void main(String[] args) {
		BlockingQueue<Runnable> queues = new ArrayBlockingQueue<>(100);
		Worker worker = new Worker(new Runnable() {

			@Override
			public void run() {
				int i =0;
				System.out.println("hello!!"+(++i));
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		}, queues);
		worker.start();
		for (int i = 0; i < 100; i++) {
			queues.offer(new Runnable() {

				@Override
				public void run() {
					int i =0;
					System.out.println("hello!!"+Thread.currentThread().getName());
					try {
						Thread.currentThread().sleep(1000);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			});
		}
	}
}
