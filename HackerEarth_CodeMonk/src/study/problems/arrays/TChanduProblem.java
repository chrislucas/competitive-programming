package study.problems.arrays;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * https://www.hackerearth.com/code-monk-array-strings/algorithm/terrible-chandu/
 * */

public class TChanduProblem {

	static final InputStream is = new BufferedInputStream(System.in, 2<<12);
	static final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	static final PrintWriter out = new PrintWriter(System.out, true);
	
	public static void main(String[] args) {
		int n;
		try {
			n = Integer.parseInt(reader.readLine());
			for(int i=0; i<n; i++) {
				String str = reader.readLine();
				for(int j=str.length()-1; j>-1; j--) {
					out.printf("%c", str.charAt(j));
				}
				out.printf("\n");
			}
		} catch(Exception ex) {}
	}
}
