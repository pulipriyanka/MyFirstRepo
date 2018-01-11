package com.prokarma.gtp6b.executors.demo2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<?>> futures = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			futures.add(service.submit(new SimpleTask("Task-" + i)));
		}
		
		System.out.println("Finished submitting...");

		boolean allDone = false;
		while (!allDone) {
			boolean flag = true;
			for (Future<?> future : futures) {
				if (!future.isDone()) {
					flag = false;
					break;
				}
			}
			if(flag) {
				allDone = true;
			}

		}

		System.out.println("Finished execution...");

		service.shutdown();

	}
}
