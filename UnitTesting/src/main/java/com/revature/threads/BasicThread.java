package com.revature.threads;

public class BasicThread extends Thread{
	
	@Override
	public void run(){
		while(true) {
			System.out.println("Potato");
		}
	}
}
