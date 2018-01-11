package com.prokarma.gtp6b.executors.stpe;

import java.util.concurrent.TimeUnit;

public class SimpleTask implements Runnable {

	private String name;

	public SimpleTask(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " started");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " finished");
	}

}
