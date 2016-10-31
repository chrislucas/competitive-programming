package challenges;

/*
 * https://www.hackerrank.com/challenges/sum-vs-xor
 * */
public class SumXor {

	
	
	static void init() {

	}
	
	public static int test(int n) {
		int count = 0;
		for(int x=0; x<=n; x++) {
			if(x+n == (x^n)){
				//System.out.printf("%d %d %d\n", x,n,(x^n));
				count++;
			}
		}
		//System.out.printf("%d %d\n", n, count);
		return count;
	}
	
	public static void runTest() {
		for (int i=0; i <=100; i++) {
			System.out.printf("%d %d\n", i, test(i));
		}
	}
	
	public static double _log(double b, double g) {
		return Math.log10(b) / Math.log10(g);
	}
	
	// http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
	// http://www.purplemath.com/modules/logs2.htm
	public static boolean isPowOfTwoLog(int n) {
		return 1 << (int)(_log(8,2)) == n;
	}
	
	public static boolean ipot2(long n) {
		return n+(n-1) == (n^(n-1));
	}
	
	public static boolean ipot3(long n) {
		return n > 0 && (n&(n-1)) == 0;
	}
	
	public static void runTest2() {
		System.out.println(ipot2(15));
		long n = Integer.MAX_VALUE;
		n += 1;
		/*
		for(;n<Long.MAX_VALUE;n *= 2) {
			System.out.printf("%d %s %s\n", n, ipot2(n), ipot3(n));
		}
		*/
		/*
		for(int i=0; i<=31; i++) {
			System.out.printf("%d %s %s\n", 1 << i, ipot2(1 << i), ipot3(1 << i));
		}
		*/
	}
	
	public static void main(String[] args) {
		//runTest();
		//System.out.println( 1 << (int)_log(100,2) );
		//System.out.println(_log(50,2));
		runTest2();
	}
	
}
