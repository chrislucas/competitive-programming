package tests.math.nbtheory;

public class MatrixFibonacci {

	static double fexp(double base, double exp) {
		if(exp < 0) {
			base = 1/base;
			exp = -exp;
		}
		else if(exp == 0)
			return 1;
		else if(exp == 1)
			return base;
		double y = 1.0;
		while(exp>1) {
			if(((int)exp & 1) == 0) {
				exp /=  2; 
			} else {
				y *= base;
				exp = (int)(exp-1)/2;
			}
			base *= base;
		}
		return base * y;
	}
	
	static double fExp(double acc, double b, double e) {
		if(e < 0)
			return fExp(acc, 1/b, -e);
		else if(e == 0)
			return acc;
		else if(e == 1)
			return acc*b;
		else
			return fExp(((int)e & 1) == 0 ? acc : acc * b, b * b, ((int)e & 1) == 0 ? e/2 : (int)(e-1)/2);
	}
	
	static int nth(int n) {
		int f[][] = {{1,1},{1,0}};
		int f0[][] = {{1,1},{1,0}};
		for(int i=0; i<n-1; i++){
			// elevando f ^ 2
			int a = f[0][0] * f0[0][0] + f[0][1] * f0[1][0];
			int b = f[0][0] * f0[0][1] + f[0][1] * f0[1][1];
			int c = f[1][0] * f0[0][0] + f[1][1] * f0[1][0];
			int d = f[1][0] * f0[0][1] + f[1][1] * f0[1][1];
			f[0][0] = a;
			f[0][1] = b;
			f[1][0] = c;
			f[1][1] = d;
		}
		return f[1][1];
	}
	// log b base c = (log b base d) / (log c base d)
	static double log(long l, long base) {
		return Math.log10(l) / Math.log10(base);
	}
	
	static long fastDoubling(long n) {
		long f[] = {0,1}; // [f(n), f(n+1)]
		int bdigits = ((int)log(n, 2)) + 1;
		//int init = 31-Integer.numberOfLeadingZeros((int) n);
		for(int i=bdigits; i>=0; i--) {
			long a = f[0], b = f[1];
			// f(2n) = f(n)[2*f(n+1)-f(n)]
			long c = a*(2*b-a);
			// f(2n+1) =  f(n)^2 + f(n+1)^2
			long d = (a*a+b*b);
			if((int)(1<<i&n)!=0) {
				f[0] = d;
				f[1] = d+c;
			} else {
				f[0] = c;
				f[1] = d;
			}
		}
		return f[0];
	}
	
	public static void main(String[] args) {
		System.out.println(nth(10));
		System.out.println(log(3125, 125));
		System.out.println(fastDoubling(8));
		System.out.println(fExp(1, 5, 10));
	}

}
