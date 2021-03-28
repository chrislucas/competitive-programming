package paradigmas.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class URI1224 {

	// http://codeforces.com/blog/entry/13713
	// http://marathoncode.blogspot.com.br/2012/09/algoritmo-de-kadane.html
	// http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	public static int kadanepd(Integer[] array) {
		int sum = 0, aux = 0;//ls = 0, li = 0;
		for(int i=0; i<array.length; i+=2) {
			aux += array[i];
			if(aux < 0) {
				aux = 0;
				//li = i+2 < array.length ? -1 : i+2 ;
			}
			if(aux > sum){
				sum = aux;
				//ls = i;
			}
		}
		return sum;
	}
	
	public static void s(Integer[] array) {
		int n = array.length;
		int [][] memo = new int[n+1][n+1];
		for(int i=0; i<n-1; i++) {
			memo[i][i+1] = Math.max(array[i], array[i+1]);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		//writer.printf("%d\n", kadanepd(new Integer[]{10,7,8,5,3,3,2,1,-3,-2}) );
		try {
			int n = Integer.parseInt(reader.readLine());
			Integer [] array = new Integer[n];
			for(int i=0; i<n; i++) {
				array[i] = Integer.parseInt(reader.readLine());
			}
			
			
			
		} catch(Exception ex) {}

	}

}
