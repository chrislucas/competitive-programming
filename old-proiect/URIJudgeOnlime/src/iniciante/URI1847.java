package iniciante;

//DONE

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1847 {
	
	static class IO {
		public static InputStream in;
		public static BufferedReader reader1;
		public static BufferedReader reader2;
		public static PrintWriter out1;
		public static PrintWriter out2;
		public static StringTokenizer token;
		static void init() {
			in = new BufferedInputStream(System.in);
			reader1 = new BufferedReader(new InputStreamReader(in));
			reader2 = new BufferedReader(new InputStreamReader(System.in));
			out1 = new PrintWriter(new OutputStreamWriter(System.out), true);
			out2 = new PrintWriter(System.out, true);
		}
		
		static void initToken(String in, String delimiter) {
			token = new StringTokenizer(in, delimiter);
		}
		
		static String next() {
			return token != null && token.hasMoreTokens() ? token.nextToken() : null;
		}
		
		static int nextInt() {
			String in = next();
			return Integer.parseInt(in);
		}
	}
	
	//http://stackoverflow.com/questions/28390404/how-system-in-of-type-inputstream-is-initialized
	//static { System.out.printf("%s\n%s", System.in.getClass().getName(), System.out.getClass().getName()); }
		
	// DONE
	public static void main(String[] args) throws IOException {
		IO.init();
		//while(true) {
			String get = IO.reader2.readLine();
			IO.initToken(get, " ");
			int x[] = new int[3];
			int count = 0;
			while(IO.token.hasMoreTokens()) {
				String in = IO.next();
				if(in == null)
					break;
				else
					x[count++] = Integer.parseInt(in);
			}
			
			int d1 = x[0] - x[1] < 0 ? -(x[0] - x[1]) : (x[0] - x[1]);
			int d2 = x[1] - x[2] < 0 ? -(x[1] - x[2]) : (x[1] - x[2]);
			if( (x[0] > x[1] && x[1] <= x[2]) ||
				(x[0] < x[1] && x[1] < x[2] && d1 <= d2) ||
				(x[0] > x[1] && x[1] > x[2] && d1 > d2) ||
				(x[0] == x[1] && x[1] < x[2]) )
				IO.out2.println(":)");
			else
				IO.out2.println(":(");
		//}
	}
}
