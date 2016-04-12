package algorithm.dp;


/*
 * https://www.hackerrank.com/challenges/maxsubarray
 * */

public class MaxSubArray {

	
	public static int [] kadane1D(int [] array) {
		int [] ans = {array[0], 0, 0, array[0] > - 1 ? array[0] : 0};
		int parcial = ans[0];
		for(int i=1; i<array.length; i++) {
			parcial += array[i];
			if(parcial > ans[0]) {
				ans[0] = parcial;
				ans[2] = i;
			}
			if(parcial < 0) {
				parcial = 0;
				ans[1] = i+1;
			}
			// pequena moficicacao no algoritmo para resolver um problema
			if(array[i] > 0) {
				array[3] += array[i];
			}
		}
		return ans;
	}
	
	public static void f() {
		int [][] array = {
			 {2,-1,2,3,4,-5}
			,{31,-41,59,26,-53,58,97,-93,-23,84}
			,{-1,-3,-4}
		};
		int [] ans = kadane1D(array[1]);
		System.out.printf("%d %d %d %d\n", ans[0], ans[1], ans[2], ans[3]);
	}
	
	public static void main(String[] args) {
		f();
	}

}
