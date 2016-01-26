package tests.math;

/**
 * Hamming Theory
 * https://en.wikipedia.org/wiki/Hamming_weight
 * http://cs-fundamentals.com/tech-interview/c/c-program-to-count-number-of-ones-in-unsigned-integer.php
 * https://en.wikipedia.org/wiki/Hamming_code
 * 
 * https://en.wikipedia.org/wiki/Digit_sum
 * 
 * 
 * Distance Hamming
 * https://en.wikipedia.org/wiki/Hamming_distance
 * 
 * */

public class HammingTheory {
	
	public static long countBitON(long n) {
		long counter = 0;
		while(n > 0) {
			counter += (n & 1) /*== 0 ? 0 : 1*/;
			n/=2;
		}
		return counter;
	}
	
	public static long hammingDistance(long a, long b) {
		long v = a ^ b, counter = 0;
		while(v>0) {
			counter++;
			v = v & v - 1;
		}
		return counter;
	}
	
	// https://pt.wikipedia.org/wiki/Dist%C3%A2ncia_de_Hamming#Algoritmo_de_exemplo
	public static void main(String[] args) {
		//System.out.println(Integer.bitCount(100));
		//System.out.println(Long.bitCount(100));
		System.out.println(countBitON( 127 ));
		System.out.println(hammingDistance(10, 5));


	}

}
