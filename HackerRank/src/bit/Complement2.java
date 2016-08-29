package bit;

/*
 * 
 * https://www.hackerrank.com/challenges/2s-complement
 * */

public class Complement2 {

	// https://pt.wikipedia.org/wiki/Complemento_para_dois
	
	public static String toBin(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append( (n & 1) == 1 ? "1" : "0");
			n >>= 1;
		}
		return sb.reverse().toString();
	}
	
	
	public static int complementOne(int n) {
		return ~n;
	}
	
	public static int complementTwo(int n) {
		return ~n + 1;
	}
	
	public static int fx2(int n) {
		n = ((n < 0) ? -n  : n);
		int pow2 = 1 << n;
		pow2 = pow2 - (pow2 - n);
		return pow2;
	}
	
	
	public static void runTest() {
		int n = complementOne(30);
		int m = complementTwo(30);
		int o = fx2(30);
		System.out.printf("%d %d %d\n%s\n%s", m, n, o, toBin(m < 0 ? -m : m), toBin(n < 0 ? -n : n));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runComp2();
		runTest();
	}

}
