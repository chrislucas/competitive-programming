package tests.math.nbtheory;

import java.util.ArrayList;

public class BinominalCoefficient {

	/*
	 * https://www.quora.com/What-are-some-efficient-algorithms-to-compute-nCr
	 * http://www.luschny.de/math/factorial/FastFactorialFunctions.htm
	 * Algoritmp
	 * */
	
	public static int[] erathostenesCombinatory(int n, int p) {
		return null;
	}
	
	static class Pair <P, Q> {
		P p;
		Q q;
		Pair(P p, Q q) {
			this.p = p;
			this.q = q;
		}
	}
	
	public static ArrayList<Byte> sieveErathostenes(long n) {
		ArrayList<Byte> bag 	= new ArrayList<>();
		ArrayList<Integer> nb 	= new ArrayList<>();
		bag.add(0, (byte)0);
		bag.add(1, (byte)0);
		for(int i=2; i<=n; i++)
			bag.add(i, (byte)1);
		for(long i=2; i<=n; i++) {
			//  j=i*i // while(j<=n) // j+=i
			long j=i;
			while(j*i<=n) {
				bag.set((int) (i*j),(byte)0);
			}
		}
		return bag;
	}
	
	public static boolean[] sieveErathostenes(long n, boolean [] set) {
		ArrayList<Integer> nb = new ArrayList<>();
		set[0] = set [1] = false;
		for(int i=2; i<=n; i++)
			set[i] = true;
		for(int i=2; i<=n; i++) {
			if(set[i] == true) {
				nb.add(i);
				//  j=i*i // while(j<=n) // j+=i
				int j=i;
				while(j*i<=n && j*i<Integer.MAX_VALUE && j*i > 0) {
					set[j*i] = false;
					j++;
				}
			}
		}
		return set;
	}
	
	public static ArrayList<Long> verify(long n) {
		ArrayList<Long> bag = new ArrayList<>();
		bag.add((long) 2);
		for(long i=3; i<=n; i++) {
			boolean composite = false;
			for(long j=2; j<=Math.sqrt(i); j++) {
				if(i%j==0) {
					composite = true;
					break;
				}
			}
			if(!composite)
				bag.add(i);
		}
		return bag;
	}
	
	public static void runTest() {
		long s = System.currentTimeMillis();
		int sz = 100000000;
		boolean [] set = new boolean[sz + 1];
		sieveErathostenes(sz, set);
		System.out.println((System.currentTimeMillis() - s) / 1000);
		s = System.currentTimeMillis();
		verify(1000);
		System.out.println((System.currentTimeMillis() - s) / 1000);
	}
	
	public static void main(String[] args) {
		runTest();
	}

}
