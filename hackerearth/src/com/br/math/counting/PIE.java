package com.br.math.counting;

/**
 * Principio da inclusao exclusao (Conjuntos e contagem de elementos)
 * https://www.hackerearth.com/practice/math-1/counting-1/inclusion-exclusion-1/tutorial/
 * 
 * https://en.wikipedia.org/wiki/Binary_GCD_algorithm
 * https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm
 * 
 * pesquisar
 * Lehmer's GCD algorithm
 * 
 * https://en.wikipedia.org/wiki/Least_common_multiple#Reduction_by_the_greatest_common_divisor
 * 
 * Teoria dos conjutos
 * https://www.algebra.com/algebra/homework/equations/Equations.faq.question.197775.html
 * http://ocw.mit.edu/high-school/mathematics/combinatorics-the-fine-art-of-counting/lecture-notes/MITHFH_lecturenotes_3.pdf
 * 
 * http://stackoverflow.com/questions/14300507/faster-algorithm-to-find-how-many-numbers-are-not-divisible-by-a-given-set-of-nu
 * 
 * principio IE
 * http://webbuild.knu.ac.kr/~trj/disc/mat/lecture_12.pdf
 * */

public class PIE {

	public static long gdc(long a, long b) {
		while(a % b > 0) {
			long mod = a % b;
			a = b;
			b = mod;
		}
		return b;
	}
	
	public static long lcm(long a, long b) {
		return a * b / gdc(a, b);
	}
	
	// https://www.urionlinejudge.com.br/judge/pt/problems/view/1512
	// solucao do link acima
	public static long sol(long n, long a, long b) {
		return Math.floorDiv(n, a) + Math.floorDiv(n, b) - (n / lcm(a,b));
	}
	
	public static void runTest() {
		System.out.println(sol(1000000,105,245));
		System.out.println(sol(1000000,28,32));
		System.out.println(sol(10,2,3));
		System.out.println(sol(50,5,7));
	}
	
	public static void main(String[] args) {
		runTest();

	}

}
