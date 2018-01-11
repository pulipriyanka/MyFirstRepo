package com.prokarma.gtp6b.executors.demo1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SimpleTask implements Runnable {

	private String name;

	private Date initTime;

	public SimpleTask(String name) {
		this.name = name;
		initTime = new Date();
	}

	@Override
	public void run() {
		System.out.println("Task " + name + " has started. It's created at " + initTime);
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Task " + name + "has finished.");
	}

}
