package com.practice.concurrancy;

public class DoWork implements Runnable {
	int workerId;
	public DoWork(int id) {
		this.workerId = id;
	}
	
	@Override
	public void run() {
		System.out.println("Processing work.... "+workerId);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}