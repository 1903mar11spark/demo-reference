package com.revature.threads;

public class WaitingThread implements Runnable{

	private Thread tToWaitOn;
	
	public WaitingThread(Thread t) {
		this.tToWaitOn = t;
	}
	
	
	public void run() {
		try {
			tToWaitOn.join();
			System.out.println("Has Joined other Thread");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
