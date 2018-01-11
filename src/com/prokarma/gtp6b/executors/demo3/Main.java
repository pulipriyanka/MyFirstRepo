package com.prokarma.gtp6b.executors.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<?>> futures = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			futures.add(service.submit(new SimpleTask("Task-" + i)));
		}

		System.out.println("Finished submitting...");

		for (Future<?> future : futures) {
			future.get();
		}

		System.out.println("Finished execution...");

		service.shutdown();

	}
}
