package com.br.practice.track.math;

import java.math.BigInteger;

/*
 * https://www.hackerearth.com/problem/algorithm/small-factorials/
 * */

public class SmallFactorial {

	public static BigInteger f(BigInteger a) {
		BigInteger b = a.subtract(BigInteger.ONE);
		while( b.compareTo(BigInteger.ONE) != 0) {
			a = a.multiply(b);
			b = b.subtract(BigInteger.ONE);
		}
		return a;
	}
	
	public static void runTest() {
		BigInteger nums [] =  {
			 new BigInteger("5")
			,new BigInteger("6")
			,new BigInteger("7")
			,new BigInteger("8")
			,new BigInteger("9")
			,new BigInteger("10")
			,new BigInteger("11")
			,new BigInteger("60")
			,new BigInteger("100")
		};
		for(BigInteger num : nums) {
			System.out.println(f(num));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTest();
	}

}
