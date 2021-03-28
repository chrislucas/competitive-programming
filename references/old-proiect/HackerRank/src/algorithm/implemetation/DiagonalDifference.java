package algorithm.implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// DONE
public class DiagonalDifference {
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int n = Integer.parseInt(buffer.readLine());
			int dp = 0, ds = 0;
			for(int i=0; i<n; i++) {
				StringTokenizer tokenizer = new StringTokenizer(buffer.readLine(), " ");
				for(int j=0; tokenizer.hasMoreTokens(); j++) {
					int m = Integer.parseInt(tokenizer.nextToken());
					if(i == j) {
						dp += m;
					}
					if(i+j == n-1) {
						ds += m;
					}
				}
			}
			int ans = dp - ds;
			writer.printf("%d\n", ans < 0 ? -ans : ans);
		} catch(IOException ioex) {}
	}

}
