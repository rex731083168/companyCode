package com.bruce.thread;

public class ProducerConsumerExample {
	public static void main(String[] args) {
         Drop drop = new Drop();
         Thread t1 = new Thread(new Producer(drop));
         Thread t2 = new Thread(new Consumer(drop));
         t1.start();
         t2.start();
	}
}
