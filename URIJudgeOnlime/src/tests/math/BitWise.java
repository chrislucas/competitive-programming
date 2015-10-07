package tests.math;

public class BitWise {
	
	
	public static void table(int n) {
		String format = "";
		for(int i=0; i<(1<<n)/**n*/; i++) {
			for(int j=n-1; j>=0; j--) {
				format = j < n-1 ? " %d" : "%d";
				System.out.printf(format, (i & (1<<j)) > 0 ? 1 : 0);
			}
			System.out.println("");
			//int j = i % n;
			//System.out.printf(j > 0 ? " %d" : "%d", (i & (1<<j)) > 0 ? 1 : 0);
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// para nao esquecer mais
		// shift right =  m / 2 ^ n
		System.out.println(127>>4);
		table(4);
	}

}
