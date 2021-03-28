package com.br.math;

/*
 * http://www.geeksforgeeks.org/linear-diophantine-equations/
 * https://en.wikipedia.org/wiki/Euclidean_algorithm
 * */

/**
 * coeficiente bezout 
 * ax + by = mdc(a, b)
 * */

public class LinearDiophantineEq {

	public static long [] extendedEuclidianDivisor(long a, long b) {
		long ans [] = new long[3];
		long [] x = {1,0}, y = {0,1};
		
		while(a%b != 0) {
			long m = a%b;
			long q = a/b;
			a = b;
			b = m;
			
			long u = x[0] - (x[1] * q);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
	}
}
