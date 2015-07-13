package com.br.test.math;


// usando template-method com rook method
public abstract class MyBenchmark {
	public abstract void template();	
	public long process() {
		long s = System.currentTimeMillis();
		template();
		return System.currentTimeMillis() - s;
	}
}