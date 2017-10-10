package com.bruce.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Test;

public class AtomicTest {

	@Test
	public void testAtomic() {
		final int loopcount = 10000;
		int threadcount = 10;

		final NonSafeSeq seq1 = new NonSafeSeq();
		final SafeSeq seq2 = new SafeSeq();

		final CountDownLatch l = new CountDownLatch(threadcount);

		for (int i = 0; i < threadcount; ++i) {
			final int index = i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int j = 0; j < loopcount; ++j) {

						seq1.inc();
						seq2.inc();
					}

					System.out.println("finished : " + index);
					l.countDown();

				}
			}).start();
		}

		try {
			l.await();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("both have finished....");

		System.out.println("NonSafeSeq:" + seq1.get());
		System.out.println("SafeSeq with atomic: " + seq2.get());

	}
}
/**
 * 线程不安全的
 * @author bruce
 *
 */
class NonSafeSeq {
	private long count = 0;

	public void inc() {
		count++;
	}

	public long get() {
		return count;
	}
}
/**
 * 线程安全的
 * @author bruce
 *
 */
class SafeSeq {
	private AtomicLong count = new AtomicLong(0);

	public void inc() {
		count.incrementAndGet();
	}

	public long get() {
		return count.longValue();
	}
}
