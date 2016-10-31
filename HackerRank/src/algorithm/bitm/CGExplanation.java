package algorithm.bitm;

/*
 * https://en.wikipedia.org/wiki/Power_of_two
 * https://www.hackerrank.com/challenges/counter-game
 * http://stackoverflow.com/questions/757059/position-of-least-significant-bit-that-is-set/757266#757266
 * http://marvin.cs.uidaho.edu/Teaching/CS472/bitOps.html
 * */

public class CGExplanation {

	/**
	 * https://www.hackerrank.com/challenges/counter-game/forum/comments/51109
	 	------------------- N is not power of 2 ----------------------
		N = 1101001100          Louise will reduce it by 1000000000
		N =  101001100          Richard will reduce it by 100000000
		N =    1001100          Louise will reduce it by    1000000
		N =       1100          Richard will reduce it by      1000
		
		------------------- N(100) is power of 2 ----------------------
		N =        100          Louise will reduce counter by half
		N =        10           Richard will reduce counter by half
		N =        1            Louise can't make a move, hence, loses
		                        Richard is the winner !
	 * */
	// flip the msb bit
	// http://stackoverflow.com/questions/7790233/how-to-clear-the-most-significant-bit
	public static long setMSBBit(long n) {
		long mask = n;
		mask |= mask >> 1;
		mask |= mask >> 2;
		mask |= mask >> 4;
		mask |= mask >> 8;
		mask |= mask >> 16;
		mask >>=  1;
		return n & mask;
	}
	
	// POT: power of two
	public static long roundPOT(long mask) {
		int x = 0;
		while(x<7) {
			mask |= mask >> (1<<x);
			x++;
		}
		mask += 1;
		mask = mask >> 1;
		return mask;
	}
	
	public static boolean ipot(long n) {
		return n+(n-1) == (n^(n-1));
	}
	
	public static boolean ipot2(long n) {
		return n>0 && (n&(n-1))==0;
	}
	
	public static boolean solver(long n) {
		boolean flag = false;
		while(n > 1) {
			if(!ipot(n))
				n = setMSBBit(n);
			else
				n >>= 1;
			flag = ! flag;
		}
		return flag;
	}
	
	public static boolean solver2(long n) {
		boolean flag = false;
		while(n > 1) {
			if(!ipot(n))
				n = n - roundPOT(n);
			else
				n >>= 1;
			flag = ! flag;
		}
		return flag;
	}
	
	public static void main(String[] args) {
		//System.out.println(setMSBBit(15));
		//System.out.println(solver(4));
		/*
		 * http://marvin.cs.uidaho.edu/Teaching/CS472/bitOps.html
		 * */
		System.out.printf("%d %d %d %d\n",
			 0x80000000L
			,0x7fffffff
			,0x80000000L - roundPOT(0x80000000L)
			,0x7fffffff - roundPOT(0x7fffffff)
		);
	}

}
