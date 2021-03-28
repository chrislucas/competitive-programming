package com.br.pledge.easy.dp;

public class Kadane {

	static int [] kadane(int[] set) {
		// ans[0,1] intervalo maximo, ans[2] soma maxima
		int[] ans = new int[3];
		int mA = 0, mT = -1, temp = 0;
		for(int i=0; i<set.length; i++) {
			mA += set[i];
			if(mA < 0) {
				mA = 0;
				temp = i+1;
			}
			if(mA > mT) {
				mT =  mA;
				ans[0] = temp;
				ans[1] = i;
				ans[2] = mT;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] mat =  {
			{-2,1,-3,4,-1,2,1,-5,4}
			,{-1,1,1,-1,1}
		};
		int[] ans = kadane(mat[1]);
		System.out.printf("%d %d %d\n", ans[0], ans[1], ans[2]);
	}

}
