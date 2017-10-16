package com.bruce.thread;

import java.util.Collection;
import java.util.Queue;

/**
 * 
 * @author bruce
 *
 */
public class ProcessCache {
	// 主线程运行状态
	private static volatile Boolean processRunning = false;
	// 线程池大小
	private static volatile int processPoolCount = 5;
	private static volatile ProcessCache instance = null;
	//异步队列
	private static final Queue<Apple> queue = new DoubleBufferQueue<>();

	private ProcessCache() {
		super();
	}

	public static final ProcessCache getInstance() {
		if (instance == null) {
			synchronized (instance) {
				if (instance == null) {
					instance = new ProcessCache();
				}
			}
		}
		return ProcessCache.instance;
	}

	public static synchronized Boolean getProcessRunning() {
		return ProcessCache.processRunning;
	}

	public static synchronized void setProcessRunning(Boolean processRunning) {
		ProcessCache.processRunning = processRunning;
	}

	public static int getProcessPoolCount() {
		return processPoolCount;
	}

	public static void setProcessPoolCount(int processPoolCount) {
		ProcessCache.processPoolCount = processPoolCount;
	}
	/**
	 * 入列
	 * @param data
	 */
	public static void addApple(Apple data) {
        queue.offer(data);
    }
    /**
     * 
     * @param dataCollection
     */
    public static void addApples(Collection<Apple> dataCollection) {
        queue.addAll(dataCollection);
    }
    /**
     * 出列
     * @return
     */
    public static Apple pollApple() {
        return queue.poll();
    }
    /**
     * 队列是否为空
     * @return
     */
    public static Boolean dataIsEmpty() {
        return queue.isEmpty();
    }

	public static int getSize() {
		return queue.size();
	}
    
}
