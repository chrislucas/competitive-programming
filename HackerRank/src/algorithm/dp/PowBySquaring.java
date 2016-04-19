package algorithm.dp;

public class PowBySquaring {
	
	public static double pow(double b, int e) {
		double ans = 1.0;
		if(e == 0){
			return 1.0;
		} else if(e == 1) {
			return b;
		} else if(e < 0) {
			e *= -1;
			b = 1/b;
		}
		while(e > 0) {
			e /= 2;
			if(e % 2 == 0) {
				ans *= b;
			} else {
				b *= b;
			}
		}
		return ans;
	}
	
	public static double powRec(double b, int  e) {
		return 0.0;
	}
	
	public static void runTest() {
		System.out.println(pow(5, -2));
	}

	public static void main(String[] args) {
		runTest();
	}

}
