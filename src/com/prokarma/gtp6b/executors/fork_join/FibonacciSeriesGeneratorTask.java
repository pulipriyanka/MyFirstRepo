package com.prokarma.gtp6b.executors.fork_join;

import java.util.concurrent.RecursiveTask;

public class FibonacciSeriesGeneratorTask extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	
	private Integer index = 0;

	public FibonacciSeriesGeneratorTask(Integer index) {
		this.index = index;
	}

	@Override
	protected Integer compute() { // 1
		if (index == 0) {
			return 0;
		}
		if (index < 2) {
			return 1;
		}
		final FibonacciSeriesGeneratorTask worker1 = new FibonacciSeriesGeneratorTask(index - 1);
		worker1.fork();
		final FibonacciSeriesGeneratorTask worker2 = new FibonacciSeriesGeneratorTask(index - 2);

		return worker2.compute() + worker1.join();
	}

}
