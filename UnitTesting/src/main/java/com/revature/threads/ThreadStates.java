package com.revature.threads;

public class ThreadStates {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new SleepyThread());
		Thread t2 = new Thread(new WaitingThread(t1));
		
		System.out.println(t1.getState()); // should be new
		t1.start();
		System.out.println(t1.getState());// should be runnable
		
		Thread.sleep(1000);
		t2.start();
		
		Thread.sleep(1000);
		System.out.println(t2.getState()); // should be waiting
		
		System.out.println(t1.getState()); // should be timed waiting
		
		Thread.sleep(10000);
		System.out.println(t1.getState()); // should be terminated
		
	}
	
}
