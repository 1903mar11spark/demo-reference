package com.revature.threads;

public class SleepyThread implements Runnable{

	public void run() {
		
		
		try {
			System.out.println("Sleepy is going to go to sleep");
			Thread.sleep(10000);
			System.out.println("Sleepy thread is well rested and ready to program");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
