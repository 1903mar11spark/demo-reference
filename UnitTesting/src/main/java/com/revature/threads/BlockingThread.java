package com.revature.threads;

public class BlockingThread implements Runnable{
	
	private SynchronizedResource sr1;
	private SynchronizedResource sr2;
	
	public BlockingThread(SynchronizedResource sr1, SynchronizedResource sr2) {
		this.sr1 = sr1;
		this.sr2 = sr2;
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + "Trying to use resource 1");
		sr1.blockingMethod();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "Trying to use resource 2");
		sr2.blockingMethod();
		System.out.println(Thread.currentThread().getName() + "Done with the Resource");
	}

}
