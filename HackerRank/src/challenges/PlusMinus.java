package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class PlusMinus {

	public static double[] solution(int [] array) {
		int s = array.length;
		double ans [] = {0 , 0, 0};
		for(int i : array) {
			if( i > 0)
				ans[0] += 1;
			else if(i < 0)
				ans[1] += 1;
			else
				ans[2] += 1;
		}
		ans[0] /= s;
		ans[1] /= s;
		ans[2] /= s;
		return ans;
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int n = Integer.parseInt(reader.readLine());
			int [] array = new int[n];
			StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
			int i = 0;
			while(token.hasMoreTokens()) {
				array[i++] = Integer.parseInt(token.nextToken());
			}
			double ans[] = solution(array);
			writer.printf("%.6f\n%.6f\n%.6f", ans[0], ans[1], ans[2]);
		} catch(IOException ioex){}	
	}
}
