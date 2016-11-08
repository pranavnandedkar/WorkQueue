package com.practice.concurrancy;

import java.util.concurrent.Callable;

public class DoWorkWithResult implements Callable<String> {
	int workerId;
	public DoWorkWithResult(int id) {
		this.workerId = id;
	}
	

	@Override
	public String call() throws Exception {
		System.out.println("Processing work.... "+workerId);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Completed Task No :-- "+workerId;
	}
	
}