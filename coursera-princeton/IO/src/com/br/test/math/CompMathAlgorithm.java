package com.br.test.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * http://marathoncode.blogspot.com.br/2012/08/fatoracao-de-fermat.html
 * http://pt.wikipedia.org/wiki/M%C3%A9todo_de_fatora%C3%A7%C3%A3o_de_Fermat
 * http://marathoncode.blogspot.com.br/2012/08/turbinando-fatoracao-de-fermat.html
 * */

public class CompMathAlgorithm {
	
	static class Euler {
		
	}
	
	static class Eratostheenes extends MyBenchmark {
		public static int limit = (1<<23) * 2;
		public static byte [] crive = new byte[limit];
		public static boolean isPrime(int n) {
			return crive[n] == 1 ? true : false;
		}
		@Override
		public void template() {
			crive[0] = crive[1] = 0;
			for (int i = 2; i < limit; i++) {
				crive[i] = 1;
			}
			int limitn = (int)Math.sqrt(limit);
			for (int i = 2; i < limitn; i++) {
				if(crive[i] == 1) {
					for (int j = i*i; j < limit; j+=i) {
						crive[j] = 0;
					}
				}
			}
			return;
		}
	}
	
	static class Fermat {
		public static Map<Integer, Integer> facts = new HashMap();
		
		public static long factor(long n) {
			long a, b, bn, c;
			// poderia usar o vetor ans para retornar os valores de a e b que satisfazer N = (a² - b²)
			// long ans[] = new long[2];
			a = (long) Math.sqrt(n);
			while(a<=n) {
				bn = (a*a - n) < 0 ? -(a*a - n) : (a*a - n);
				if(isSquare(bn)) {
					b = (long) Math.sqrt(bn);
					c = a + b;
					/**
					 * if(a+b!=1 && a+b!=n)
					 * ans[0] = a;
					 * ans[1] = b;
					 * */
					if(c!=1 && c !=n)
						return c;
				}
				a++;
			}
			return 1;
		}
		
		public static long factors() {
			return 0;
		}
		
		public static boolean isSquare(long m) {
			// explicacao do _0.5:  caso a funcao  gere um resultado 1.99999, soma-se 
			// 0.5 para jogar para 2.49999 e depois arredonda para 2
			long n = (long) Math.sqrt(m+0.5);
			return n*n == m ? true : false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Fermat.factor(100));
		
		
		//System.out.printf("%h%n", new Fermat());
		//System.out.println(new Eratostheenes().process());
		//System.out.println(Eratostheenes.isPrime((1<<10) + 1));
	}
	
	

	
	
	private static void testValueOfMethod() {
		//http://stackoverflow.com/questions/26617224/why-for-integer-valueof500-returns-false-but-true-for-5
		//http://stackoverflow.com/questions/20877086/confusion-in-method-integer-valueofstring
		// valueOf soh vai retornar true nas comparacoes
		// de 1 a 127, pois esses valores estao num vetor numa classe
		// interna de Integer chama IntegerCache

		for (int i = 0; i < 5000; i++)
			if(! (Integer.valueOf(i) == Integer.valueOf(i)) ){
				System.out.println(i);
				break;
			}
		
		System.out.println(Integer.valueOf(5000).equals(5000));
		return;
	}

}
