package com.prokarma.gtp6b.executors.demo4;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class SimpleTask implements Callable<String> {

	private String name;

	private Date initTime;
	
	private Random random;

	public SimpleTask(String name) {
		this.name = name;
		initTime = new Date();
		random = new Random();
	}

	@Override
	public String call() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return name + random.nextInt();
	}

}
