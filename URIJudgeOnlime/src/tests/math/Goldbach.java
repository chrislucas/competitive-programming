package tests.math;

public class Goldbach {
	
	private boolean[] primes;
	private int[] list;
	private static final int LIMIT = 1<<25;
	
	private void init() {
		primes = new boolean[LIMIT];
		list = new int[LIMIT];
	}
	
	private void crive() {
		init();
	}
	
	private void fastCrive() {
		init();
	}
	
	private boolean isPrime(int n) {
		return n < LIMIT ? primes[n] : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
