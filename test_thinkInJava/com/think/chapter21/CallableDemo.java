package com.think.chapter21;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i=0;i<10;i++) {
        	results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> future:results) {
        	try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
        }
	}
}

class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWihtResult " + id;
	}
}