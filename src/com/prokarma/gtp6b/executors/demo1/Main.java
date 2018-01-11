package com.prokarma.gtp6b.executors.demo1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		List<Callable<Object>> tasks = new ArrayList<>();
		for(int i = 1; i <= 12; i++) {
			tasks.add(Executors.callable(new SimpleTask("Task-" + i)));
		}
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		try {
			service.invokeAll(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished");
		
		service.shutdown();
		
	}
}
