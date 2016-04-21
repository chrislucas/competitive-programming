package contest.hack101;

public class HumbleMatrix {

	public static final int M = 1000000007;
	
	public static void create(int n, int m) {
		int [][] matrix = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				matrix[i][j] = (i*m+j)+1;
			}
		}
		
		return;
	}
	
	public static void runTest() {
		create(20,2);
	}
	
	public static void main(String[] args) {
		runTest();
	}

}
