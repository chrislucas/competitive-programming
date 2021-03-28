package bit;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NextPOT {
/*
 * round to next power of 2
 * https://en.wikipedia.org/wiki/Power_of_two
 * http://stackoverflow.com/questions/4398711/round-to-the-nearest-power-of-two
 * http://www.geeksforgeeks.org/next-power-of-2/
 * http://stackoverflow.com/questions/466204/rounding-up-to-nearest-power-of-2
 * https://www.hackerearth.com/practice/notes/round-a-number-to-the-next-power-of-2/
 * http://graphics.stanford.edu/~seander/bithacks.html
 * http://graphics.stanford.edu/~seander/bithacks.html#IntegerLog
 * 
 * */
	public static boolean ipot(long n) {
		return n+(n-1) == (n^(n-1));
	}

	public static long roundDownNPOT(long n) {
		n--;
		n |= n >> 1;
		n |= n >> 2;
		n |= n >> 4;
		n |= n >> 8;
		n |= n >> 16;
		n++;
		return n >> 1;
	}
	
	public static double mpow(double base, long exp) {
		if(exp == 0)
			return 1;
		else if(exp < 0) {
			base = 1/base;
			exp = -exp;
		}
		double acc = 1.0;
		while(exp > 0) {
			if((exp&1)==1) {
				acc *= base;
			}
			exp >>= 1;
			base *= base;
		}
		return acc;
	}
	
	public static long roundDownNPOT2(long n) {
		return (long) Math.pow(2, Math.floor(mlog(n, 2)));
		//return (long)mpow(2,(long) Math.floor(mlog(n, 2)));
	}
	
	public static BigInteger roundDownPOT(BigInteger n) {
		n = n.subtract(BigInteger.ONE);
		n = n.or(n.shiftRight(1));
		n = n.or(n.shiftRight(2));
		n = n.or(n.shiftRight(4));
		n = n.or(n.shiftRight(8));
		n = n.or(n.shiftRight(16));
		n = n.add(BigInteger.ONE);
		return n.shiftRight(1);
	}
	
	public static boolean ipot(BigInteger n) {
		BigInteger o = n.subtract(BigInteger.ONE);
		return n.add(o).equals(n.xor(o));
	}
	
	public static double mlog(double lg, double base) {
		return Math.log10(lg) / Math.log10(base);
	}
	
	public static int countSetBit(BigInteger n) {
		//n = n.subtract(BigInteger.ONE);
		int bc = n.bitCount();
		return bc;
	}
	
	public static long countSetBit2(BigInteger n) {
		long bc = 0;
		BigInteger o;
		while(n.compareTo(BigInteger.ZERO) == 1) {
			o = n.subtract(BigInteger.ONE);
			n = n.and(o);
			bc++;
		}
		return bc;
	}
	
	public static long countSetBit3(long n) {
		long bc = 0;
		while(n>0) {
			n &= (n-1);
			bc++;
		}
		return bc;
	}
	
	public static void main(String[] args) {
		long n = 31;//4294967295L;
		/*
		System.out.printf("%d %d\n", roundDownNPOT(n),  roundDownNPOT2(n));
		System.out.println((long)Math.floor(mlog(n, 2)));
		System.out.println((long)mpow(24, 8));
		System.out.println(roundDownPOT(new BigInteger(String.valueOf(n))).toString());
		
		for(int i=0; i<31; i++) {
			System.out.printf("%d %s\n", 1 << i, ipot(new BigInteger(String.valueOf(1 << i))));
		}
		*/
		String str [] = {
			 "144115188075855872" // 2 ^ 57
			,"16321580746870438227"
			,"2147483648"
			,"2015609655232651722"
			,"262144"
			,"155096674590280324"
			,"2621445"
			,"1441151801"
			,"2015609655232651722"
		};
		BigInteger num = new BigInteger(str[8]);
		System.out.printf("%s", ipot(num));
		/*
		System.out.printf("%d %d %d\n"
				,countSetBit(new BigInteger(str[7]))
				,countSetBit2(new BigInteger(str[7]))
				,countSetBit3(1441151801));
		*/
	}

}
