package com.prokarma.gtp6b.executors.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

		Integer result = pool.invoke(new FibonacciSeriesGeneratorTask(44)); 

		System.out.println(result);

	}
}
