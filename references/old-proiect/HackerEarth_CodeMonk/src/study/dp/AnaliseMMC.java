package study.dp;

public class AnaliseMMC {
	
	static long mmc(long a, long b) {
		long mod;
		while(a%b>1) {
			mod = a % b;
			a = b;
			b = mod;
		}
		return b;
	}

	public static void main(String[] args) {
		
	}

}
