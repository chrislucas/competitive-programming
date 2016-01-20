package tests.math;

public class Fibo {
	
	static int acc = 0;
	static int fibo(int n) {
		if(n == 0 || n  == 1)
			return 1;// n;
		acc++;
		int a = fibo(n-1);
		acc++;
		int b = fibo(n-2);
		return  a + b;
	}
	
	static int fiboMat(int n) {
		int m [] = {0, 1};
		int i;
		for(i=0; i<n; i++) {
			m[i%2] = m[0] + m[1];
		}
		return m[i%2 == 0 ? 1 : 0];
	}
	
	static int fiboMat2(int n) {
		int m [] = new int[n+2];
		m[0] = 0;
		m[1] = 1;
		for(int i=2; i<n+2; i++) {
			m[i] = m[i-1] + m[i-2];
		}
		return m[n+2-1];
	}
	
	public static void main(String[] args) {
		System.out.printf("%d %d %d %d", fibo(8), acc, fiboMat(8), fiboMat2(8));
	}

}
