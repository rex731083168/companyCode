package com.bruce.thread;

public class ThreadDmeo {
	private static boolean runable = false;
    private static Object lock = new Object();
    public static void main(String[] args) {
    	Thread t1 = new Thread(new Thread1(lock));
    	System.out.println("主线程开始");
    	try {
			Thread.sleep(2000);
			t1.start();
			Thread.sleep(3000);
			//lock.notifyAll();
			synchronized(lock) {
				lock.notifyAll();
				runable = true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    static class Thread1 extends Thread{
    	private Object lock = null;
    	public Thread1(Object lock) {
    		this.lock = lock;
    	}
    	@Override
    	public void run() {
    		synchronized (lock) {
    			while(!runable) {
    				System.out.println("我一直在等待--------");
    				try {
    					lock.wait();
    				} catch (Exception e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    			}
    		}
    		System.out.println("煎熬终于过去了------");
    	}
    }
}

