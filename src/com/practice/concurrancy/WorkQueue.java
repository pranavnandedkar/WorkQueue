package com.practice.concurrancy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WorkQueue {

	private BlockingQueue<Runnable> queue=null;
	private ThreadPoolExecutor executor = null;
	public WorkQueue(int corePoolSize,int maximumPoolSize,int keepAliveTime){
		queue = new LinkedBlockingQueue<Runnable>();
		executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, queue);
	}

	public void execute(Runnable r){
		try {
			executor.execute(r);
		} catch (Exception e) {
			System.err.println("Exception While Executng the thread..."+e);
		}
	}
}
