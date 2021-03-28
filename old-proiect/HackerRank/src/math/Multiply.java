package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Multiply {
	
	public static final int F = (int)1E9+7;
	
	static int sumFactorizationSlow(int n) {
		int sum = 0;
		// much slow
		/*
		for(int i=1; i<=n; i++)
			sum += n%i==0 ? i : 0;
		*/
		// betther
		return sum;
	}
	
	static class Pollard {
		
		public static int f(int x) {
			return x * x + 1;
		}
		
		// rho Pollard algorithm
		public static int rhoPollard(int n) {
			// int limit = (int)Math.sqrt(n);
			int i = 2, j = 2, d = 1;
			if(n%2==0)
				return 2;
			do {
				i = f(i) % n;
				j = f(f(j)) % n;
				d = gdc(Math.abs(i-j), n);
			} while(d==1);
			
			return d;
		}
		
		public static int gdc(int a, int b) {
			while(b>0 && a%b!=0) {
				int mod = a % b;
				a = b;
				b = mod;
			}
			return a;
		}
		
		public static boolean isCongruent(int m, int n, int p) {
			return gdc(Math.abs(m-n), p) < p;
		}
		
		public static double tailFastPow(double acc, double b, double e) {
			if(e == 0)
				return 1;
			else if(e == 1)
				return (acc * b);
			else if (e<0)
				return tailFastPow(acc, 1/b, -e);
			else if(((int) e)%2 == 0)
				return tailFastPow(acc, b*b, e/2);
			else if(((int) e)%2 == 1)
				return tailFastPow(acc*b, b*b, (e-1)/2);
			return 0;
		}
		
		public static int sumFactor(int n) {
			int sum = 0;
			return sum;
		}
		/*
		public static void rhoTest(int n) {
			long a = 2;
			int limit = (int)Math.sqrt(n);
			for(int i=2; i<limit; i++) {
				a = ((long)tailFastPow(1, a, i)) % n;
				int g = gdc((int)a-1, n);
				if(g > 1) {
					System.out.printf("%d\n", g);
				}
			}
		}
		*/
		static void test(int n) {
			while(n>1) {
				int d = rhoPollard(n);
				n /= d;
				System.out.println(n);
			}
		}
	}
	
	static class Fermat {
		static long factorization(long n) {
			long a = (long)Math.ceil(Math.sqrt(n));
			long b = a*a-n;
			while(!isQuadratic(b)) {
				a++;
				b = a*a-n;
			}
			long r1 = a - (long)Math.sqrt(b);
			long r2 = n / r1;
			System.out.printf("%d %d", r1, r2);
			return 0;
		}
		
		static boolean isQuadratic(long n) {
			long sqrt = (long) Math.sqrt(n);
			return sqrt * sqrt == n || (sqrt+1)*(sqrt+1) == n? true : false;
		}
	}
	

	public static void main(String[] args) throws IOException {
		int N, Q, X;
		String enter;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		StringTokenizer token;
		//enter = reader.readLine();
		//token = new StringTokenizer(enter, " ");
		//writer.println(sumFactorizationSlow(150));
		Pollard.test(300);
		
	}

}
