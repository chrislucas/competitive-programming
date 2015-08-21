package String;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// DONE
public class URI1238 {

	public static final PrintWriter out = new PrintWriter(System.out, true);
	public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	static class FastReader {
		public static final int SIZE = 4096;
		public static final byte buffer[] = new byte[SIZE];
		public static BufferedInputStream reader;
		public static StringTokenizer token;
		static void init(InputStream in) {
			reader = new BufferedInputStream(in, SIZE);
		}
		
		static String next(String del) {
			String ans = null;
			try {
				while(token == null || ! token.hasMoreTokens()) {
					int enter = reader.read(buffer);
					if(enter == -1)
						break;
					String data = new String(buffer, 0, enter);
					token = new StringTokenizer(clean(data), del);
				}
				ans = token.nextToken();
			} catch (IOException e) {}
			return ans;
		}
		
		static String clean(String str) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				if(c!='\n' && c!=' ' && c!='\r' && c!='\t' && c != -1)
					sb.append(c);
			}
			return sb.toString();
		}
		
		static int nextInt(String del) {
			return Integer.parseInt(next(del));
		}
		
		static double nextDouble(String del) {
			return Double.parseDouble(next(del));
		}
	}
	
	public static void main(String[] args) throws IOException {
		//FastReader.init(System.in);
		//int x = FastReader.nextInt("");
		String in[];
		String enter = reader.readLine();
		int v = Integer.parseInt(enter);
		while( v > 0 ) {
			in = reader.readLine().split(" ");
			int m = in[0].length();
			int n = in[1].length();
			int min = ((m < n) ? m : n);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<min; i++) {
				char a = in[0].charAt(i);
				char b = in[1].charAt(i);
				sb.append(Character.toString(a).concat(Character.toString(b)));
			}
			if(m < n) {
				String subs = in[1].substring(m, n);
				sb.append(subs);
			} else if(m > n) {
				String subs = in[0].substring(n, m);
				sb.append(subs);
			}
			out.println(sb.toString());
			v--;
		}
	}
}
