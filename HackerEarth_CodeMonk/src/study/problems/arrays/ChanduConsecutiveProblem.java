package study.problems.arrays;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ChanduConsecutiveProblem {

	static final InputStream is = new BufferedInputStream(System.in, 2<<12);
	static final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	static final PrintWriter out = new PrintWriter(System.out, true);
	
	public static void main(String[] args) {
		int n;
		try {
			n = Integer.parseInt(reader.readLine());
			for(int i=0; i<n; i++) {
				String str = reader.readLine();
				for(int j=0; j<str.length(); j++) {
					if(j>0) {
						char a = str.charAt(j);
						char b = str.charAt(j-1);
						if( a != b)
							out.printf("%c", a);
					} else {
						out.printf("%c", str.charAt(j));
					}
				}
				out.println("");
			}
		} catch(Exception ex) {}
	}
}
