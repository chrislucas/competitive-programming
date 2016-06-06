package math.learning.numtheory;

public class ModExp {
	
	static long expmod(long b, int e, long m) {
		long ans = 1;
		int i=e;
		while(i>0) {
			if( (i & 1) == 1 ) {
				ans = ((ans%m) * (b%m)) % m;
			}
			b = ((b%m) * (b%m)) % m;
			i /= 2;
		}
		return ans;
	}
	
	static long modularBinaryExpLF(long b, int e, long m) {
		long ans = 1;
		boolean [] bin = decToBin((int)e);
		for(boolean bit : bin) {
			ans = ans * ans % m;
			if(bit)
				ans = ans * b % m;
		}
		return ans;
	}
	
	public static double log(double logt, int base) {
		// troca de base usando base 10
		//http://www.infoescola.com/matematica/logaritmo/
		return Math.log10(logt) / Math.log10(base);
	}
	
	public static boolean[] decToBin(int n) {
		int size 		= ((int)log(n, 2)+1);	
		boolean bin [] 	= new boolean[size];
		for(int i=size-1; i>=0; i--) {
			bin[i] = (n & 1) == 0 ? false : true;
			n=n>>1;
		}
		return bin;
	}
	
	public static void runTest() {
		System.out.println(decToBin(7));
		System.out.println(expmod(672, 1456, 15));
		System.out.println(modularBinaryExpLF(672, 1456, 15));
	}
	
	public static void main(String[] args) {
		runTest();
	}

}
