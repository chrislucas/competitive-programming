package algorithm.implemetation;

import java.math.BigDecimal;
import java.math.BigInteger;

/*
 * http://www.tutorialspoint.com/java/math/java_math_biginteger.htm
 * 
 * */

public class StudyBigInteger {
	
	public static BigInteger fb(int k) {
		BigInteger [] set = {BigInteger.ZERO, BigInteger.ONE};
		for(int i=2; i<k; i++) {
			set[i%2] = set[(i-1)%2].add(set[(i-2)%2]);
		}
		return set[k%2==0?1:0];
	}
	

	public static void main(String[] args) {
		System.out.println(fb(1000));

	}

}
