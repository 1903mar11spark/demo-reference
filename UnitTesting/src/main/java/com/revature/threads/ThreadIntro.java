package com.revature.threads;

public class ThreadIntro {

	public static void main(String[] args) {
	Thread t = new BasicThread();
	
	t.start();
	
	Thread t2 = new Thread(new BasicRunnable());
	
	t2.start();
	
	while(true) {
		System.out.println("Microwave");
	}
	
	}
}
