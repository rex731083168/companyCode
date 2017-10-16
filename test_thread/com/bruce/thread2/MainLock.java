package com.bruce.thread2;

public class MainLock {
	private static volatile MainLock instance = null;

	private MainLock() {
		super();
	}

	public static final MainLock getInstance() {
		if (instance == null) {
			synchronized (MainLock.class) {
				if (instance == null) {
					instance = new MainLock();
				}
			}
		}
		return MainLock.instance;
	}
}
