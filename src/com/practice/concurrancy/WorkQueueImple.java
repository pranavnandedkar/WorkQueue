package com.practice.concurrancy;

public class WorkQueueImple {
	int i = 0;
	WorkQueue wq = new WorkQueue(20, 40, 15*60);
	public static void main(String[] args) {
		(new WorkQueueImple()).startWork(); 
	}
	
	public void startWork(){
		System.out.println("Starting....");
		for (int i =0; i<100;i++){
			DoWork work = new DoWork(i);
			System.err.println("Start Process:--"+i);
			wq.execute(work);
			System.err.println("End Process:--"+i);
		}
		
	}
	
	
	
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Done Processing work.... "+workerId);
			
		}
		
	}
}
