package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.urionlinejudge.com.br/judge/en/problems/view/1997
 * DONE
 * */

public class URI1997 {
	
	static class CompIO {
		static BufferedReader reader;
		static PrintWriter writer;
		
		public static void construct() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	public static int run(String A, String B) {
		int ans = 0;
		boolean seq = false;
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i) != B.charAt(i)) {
				if(!seq) {
					seq = true;
					ans++;
				}
			} else {
				seq = false;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		CompIO.construct();
		String in = "";
		while( ! (in = CompIO.read()).equals("* *") ) {
			StringTokenizer tk = new StringTokenizer(in, " ");
			String A = tk.nextToken(), B = tk.nextToken();
			CompIO.printf("%d\n", run(A, B));
		}
	}
}
