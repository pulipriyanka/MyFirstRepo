package com.prokarma.gtp6b.executors.demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newCachedThreadPool();
		List<Future<String>> futures = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			futures.add(service.submit(new SimpleTask("Task-" + i)));
		}

		System.out.println("Finished submitting...");

		List<String> results = new ArrayList<>();
		for (Future<String> future : futures) {
			results.add(future.get());
		}
		
		for(String result : results) {
			System.out.println(result);
		}

		System.out.println("Finished execution...");

		service.shutdown();

	}
}
