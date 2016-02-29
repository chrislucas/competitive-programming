package study.dp;

public class Kadane {
	
	// https://pt.wikipedia.org/wiki/Sublista_cont%C3%ADgua_de_soma_m%C3%A1xima
	
	public static int[] kadane1D(int [] array) {
		int s = array.length
		   ,sc = 0; 	// soma atual;
		// vetor com, soma final, indice de inicio e fim do maior subintervalo de soma maixma
		int ans[] = new int[3];
		ans[0] = 0; ans[1] = 0; ans[2] = 0;
		for(int i=0, idxtemp=0; i<s; i++) {
			sc += array[i];
			if(sc > ans[0]) {
				ans[0] = sc;
				ans[1] = idxtemp;
				ans[2] = i;
			}
			if(sc <= 0) {
				sc = 0;
				idxtemp = i + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int [][] m = {
			 {10,5,-15,20,50,-1,3,-30,10}
			,{1,-2,6,3,2,-12,-6,7,1}
		};
		int [] n = kadane1D(m[1]);
		System.out.printf("%d %d %d", n[0], n[1], n[2]);
	}

}
