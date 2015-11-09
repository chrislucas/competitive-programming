package study.dp;

public class Summation {
	
	/**
	 * 
	 * Problema da soma minima de moedas
	 * 
	 * */

	public static int solution(int[] coins, int S) {
		int limit = coins.length;
		int [] M = new int[S];
		for(int i=0; i<S; i++) {
			M[i] = Integer.MAX_VALUE;
		}
		M[0] = 0;
		for(int i=1; i<S; i++) {
			for(int j=0; j<limit; j++) {
				int v = coins[j];
				if(v <= 1 && M[i - v] + 1 < M[i]) {
					 M[i] = M[i - v] + 1;
				}
			}
		}
		return M[S-1];
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,3,5}, 11));

	}

}
