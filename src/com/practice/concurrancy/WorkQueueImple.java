package com.practice.concurrancy;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class WorkQueueImple {
	int i = 0;
	WorkQueue wq = new WorkQueue(20, 40, 15*60);
	static ArrayList<Future<String>> f = new ArrayList<>();
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		WorkQueueImple impl = new WorkQueueImple();
		impl.startWork2();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Future<String> ft:f){
			System.out.println(ft.get());
		}
	}
	
	public void startWork1(){
		System.out.println("Starting....");
		for (int i =0; i<100;i++){
			DoWork work = new DoWork(i);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			wq.execute(work);
		}
		
	}
	
	public void startWork2(){
		System.out.println("Starting....");
		for (int i =0; i<100;i++){
			DoWorkWithResult work = new DoWorkWithResult(i);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			f.add((Future<String>) wq.submit(work));
			
		}
		
	}
	
	
	
}
