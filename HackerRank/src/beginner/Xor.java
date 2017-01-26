package beginner;

// https://www.hackerearth.com/tracks/pledge-2015-easy/panda-and-xor/

/*
 * https://www.cs.umd.edu/class/sum2003/cmsc311/Notes/BitOp/xor.html
 * https://accu.org/index.php/journals/1915
 * x ^ y == (~x & y) | (x & ~y)
 * a + b = a ^ b + a & b
 * */
public class Xor {
	
	public static int complement1(int n) {
		return ~n;
	}
	
	public static int complement2(int n) {
		return complement1(n) + 1;
	}
	
	public static int opXorSimulate(int x, int y) {
		return (~x & y) | (x & ~y);
	}
	

	public static void main(String[] args) {
		System.out.println(opXorSimulate(15,7));

	}

}
