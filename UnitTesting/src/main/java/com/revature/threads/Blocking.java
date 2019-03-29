package com.revature.threads;

public class Blocking {

	public static void main(String[] args) throws InterruptedException {
		SynchronizedResource sr1 = new SynchronizedResource();
		SynchronizedResource sr2 = new SynchronizedResource();
		Thread t1 = new Thread(new BlockingThread(sr1, sr2));
		Thread t2 = new Thread(new BlockingThread(sr2, sr1));
		t1.start();
		t2.start();
		Thread.sleep(1500);
		
		while(true) {
			System.out.println(t1.getName() + "state: " + t1.getState());
			System.out.println(t2.getName() + "state: " + t2.getState());
		}
	}

}
