package tests.math;

import java.util.Random;

/**
 * https://www.youtube.com/watch?v=3jR62Mew8X4&list=PLbVzJTKmXUiYb6IGfQ7dVO-BOBJtpIfLV
 * */


public class LearnRSA {
	
	static final int LEN =  100000;
	static int[] primes;
	static boolean[] crive;
	static Random random;
	private static int count;
	
	/**
	 * achar um numero E, tal que mdc(E, p*q) seja = 1
	 * 
	 * */
	public static int alterMDC(int pq, int P, int Q) {
		int e = 0;
		// pegar um numero primo E diferente de P e Q
		while(true) {
			e = getPrime();
			if(e != P && e != Q)
				break;
		}
		// 7
		int E = e;
		while(mdc(E, pq) != 1) {
			E++;
			mdc(E, pq);
		}
		return E;
	}
	
	/*
	 * Achar um numedo D tal que, D * E = 1 mod( (p-1) * (q-1) )
	 * T = (p-1) * (q-1);
	 * ou seja acahar um D tal que  E * D % T = 1
	 * */
	public static int modular(int E, int T) {
		int D = 1;
		while( (E*D) % T != 1) {
			D++;
		}
		return D;
	}
	
	public static int mdc (int a, int b) {
		while(a%b!=0) {
			int aux = a;
			a = b;
			b = aux % b;
		}
		return b;
	}
	
	public static int getPrime() {
		return primes[random.nextInt(count)];
	}
	
	private static int erastotenes() {
		primes = new int[LEN];
		crive = new boolean[LEN];
		crive[0] = false;
		crive[1] = false;
		// inicializa o crivo e rotula os numeros pares > 2 como numeros compostos 
		for(int i=2; i<LEN; i++)
			crive[i] = i%2==0 && i>2 ? false : true;
		int counter = -1;
		int ls = (int) Math.sqrt(LEN);
		for(int i=3; i<ls; i+=2) {
			if(crive[i]) {
				primes[++counter] = i;
				for(int j=i*i; j<LEN; j+=i) {
					crive[j] = false;
				}
			}
		}
		return counter;
	}
	
	/**
	 * https://en.wikipedia.org/wiki/Wheel_factorization
	 * */
	public static void wheelFactorization() {
		
	}
	
	public static boolean isPrime(int n) {
		return crive[n];
	}
	
	static {
		random = new Random();
		count = erastotenes();
	}
	
	/*
	 *  a ^ b mod m
	 *  usando Teoria dos numeros
	 * 
	 * */
	public static long expModular(long a , long b , long m) {
		long s = a % m;
		long p = 1;
		for(long i=1; i<=b; i++) {
			p *= s;
			p %= m;
		}
		return p;
	}
	// speedup com a ideia da exponential by squaring, reduz o numero
	// de multiplicacoes a LOG(e)
	// http://stackoverflow.com/questions/2177781/how-to-calculate-modulus-of-large-numbers
	// https://en.wikipedia.org/wiki/Modular_exponentiation#Right-to-left_binary_method
	public static long expModularSquaring(long b, long e, long m) {
		long acc = b % m;
		long p = 1;
		while(e > 0) {
			if(e % 2 == 1) {
				p *= acc;
				p %= m;
			}
			e /= 2;
			acc = (acc * acc) % m;
		}
		return p;
	}
	
	public static double expBySquaringIterative(double b, long e) {
		double acc = 1.0;
		if(e < 0) {
			e = -e;
			b = 1 / b;
		}
		while(e > 1) {
			if(e % 2 == 0) {
				e /= 2;
			} else {
				acc *= b;
				e = (e-1) / 2;
			}
			b *= b;
		}
		return b * acc;
	}
	
	public static double tailedExpBySquaring(double b, long e, double acc) {
		if(e < 0) {
			return tailedExpBySquaring(1/b, -e, acc);
		} else if (e == 0) {
			return acc;
		} else if (e == 1) {
			return b * acc;
		} else if(e % 2 == 0){
			return tailedExpBySquaring(b*b, e/2, acc);
		} 
		return tailedExpBySquaring(b*b, (e-1)/2, acc*b);
	}
	
	// a ^ E = b mod (N)
	// b = a ^ E mod N
	// como criptografar o valor a
	public static long cript(long a, int E, int N) {
		//return (long) Math.pow(a, E) % N;
		return expModular(a, E, N);
	}
	
	// b ^ D = a mod (N)
	// a =  b ^ D mod (N)
	public static long decript(long b, int D, int N) {
		//return (long) Math.pow(b, D) % N;
		return expModular(b, D, N);
	}
	
	public static void rsa() {
		// 3
		int P = getPrime();
		int q;
		while(true) {
			q = getPrime();
			if(q != P)
				break;
		}
		// 11
		int Q = q;
		// N e E sao publicos
		int N = P*Q;
		int E = alterMDC(N,P,Q);
		// a funcao phi de euler para PQ onde P e Q sao primos
		// eh igual a (P-1)*(Q-1)
		int D = modular(E, (P-1)*(Q-1));
		long vo = 2;
		long vc = cript(vo,E,N);
		vo = decript(vc, D, N);
		
		System.out.printf("%d %d %d %d %d\n",vc
				,vo
				,expModular(2,8,7)
				,expModular(5,55,221)
				,expModularSquaring(5,55,221));
	}
 
	public static void main(String[] args) {
		//rsa();
		
		System.out.printf("%f %f\n",expBySquaringIterative(5,12)
				,tailedExpBySquaring(5, 12, 1.0));
	
		
		System.out.printf("%.15f %.15f\n", expBySquaringIterative(5,-12)
				,tailedExpBySquaring(5, -12, 1.0));
		
		//System.out.println(expModularSquaring(5,55,221));
	}

}
