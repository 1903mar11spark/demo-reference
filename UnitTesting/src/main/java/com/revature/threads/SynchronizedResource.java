package com.revature.threads;



public class SynchronizedResource {
	
	synchronized void blockingMethod() {
		try {
			System.out.println(Thread.currentThread().getName() + "Is using resource");
			Thread.currentThread().join();
			System.out.println(Thread.currentThread().getName() + "Is done with resource");
		} catch (InterruptedException e) {
			e.getStackTrace();
		}
	}
}
