package com.bruce.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProcessThread extends Thread {
	private Object mainLock = null;
	private ExecutorService dataExtractorService = null;
	private Object lock = new Object();

	public ProcessThread(Object mainLock) {
		this.mainLock = mainLock;
	}

	public void init() {
		this.setName("ProcessThread");
		ProcessCache.setProcessRunning(Boolean.TRUE);
		dataExtractorService = Executors.newFixedThreadPool(ProcessCache.getProcessPoolCount());
	}

	@Override
	public void run() {
		List<Future> futures = new ArrayList<>();
		while (ProcessCache.getProcessRunning()) {
			if (ProcessCache.getSize() != 0) {
				boolean stop = isFutureDone();
				// 如果线程池任务列表执行完毕和队列为空
				if (stop && ProcessCache.getSize() == 0) {
					System.out.println("队列执行完毕----->线程等待");
					synchronized (mainLock) {
						try {
							ProcessCache.setProcessRunning(Boolean.FALSE);
							mainLock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				System.out.println("目前还没有苹果哦，进入等待-------");
				synchronized (mainLock) {
					try {
						ProcessCache.setProcessRunning(Boolean.FALSE);
						mainLock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public List<Future> getFutures() {
		List<Future> futures = new ArrayList<Future>();
		for (int i = 0; i < ProcessCache.getProcessPoolCount(); i++) {
			AppleConsumption aConsumption = new AppleConsumption(i + 1, lock);
			Future future = dataExtractorService.submit(aConsumption);
			futures.add(future);
		}
		return futures;
	}
	public Boolean isFutureDone() {
		Boolean stop = false;
		List<Future> futures = new ArrayList<Future>();
		for (int i = 0; i < ProcessCache.getProcessPoolCount(); i++) {
			AppleConsumption aConsumption = new AppleConsumption(i + 1, lock);
			Future future = dataExtractorService.submit(aConsumption);
			futures.add(future);
		}
		while(!stop) {
			synchronized (lock) {
				try {
					lock.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (Future future : futures) {
					stop = true;
					if (!future.isDone()) {
						stop = false;
					}
				}
			}
		}
		System.out.println("task任务执行完毕--->"+stop);
		return stop;
	}
}
