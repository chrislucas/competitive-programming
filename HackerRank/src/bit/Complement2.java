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
			n <<= 1;
		}
		return sb.reverse().toString();
	}
	
	
	public static int complementOne(int n) {
		return ~n;
	}
	
	public static int complementTwo(int n) {
		return ~n + 1;
	}
	
	public static int comp2(int n) {
		n = ((n < 0) ? -n  : n);
		int pow2 = 1 << n;
		pow2 -= n;
		String rs = toBin(pow2);
		System.out.println(rs);
		return 0;
	}
	
	
	public static int comp1(int n) {
		return 0;
	}
	
	public static void runComp2() {
		comp2(-2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runComp2();
	}

}
