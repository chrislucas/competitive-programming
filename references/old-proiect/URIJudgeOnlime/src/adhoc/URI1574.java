package adhoc;

//DONE
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1574 {
	

	static class IO {
		public static InputStream in;
		public static BufferedReader reader;
		public static PrintWriter out;
		public static StringTokenizer token;
		static void init() {
			in = new BufferedInputStream(System.in);
			reader = new BufferedReader(new InputStreamReader(in));
			out = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		static String next() {
			return token != null && token.hasMoreTokens() ? token.nextToken() : null;
		}
		
		static String read(String del){
			String ans = null;
			try {
				String in = reader.readLine();
				token = new StringTokenizer(in, del);
				ans = next();
			} catch (Exception e) {}
			
			return ans;
		}
		
		static Integer nextInt(String del) {
			String in = read(del);
			return in == null ? null : Integer.parseInt(in);
		}
	}
	
	// DONE
	public static void main(String[] args) throws IOException {
		
		IO.init();
		String enter = IO.reader.readLine();
		int n = Integer.parseInt(enter);
		int sum[] = new int[0];
		while(n > 0) {
			enter = IO.reader.readLine();
			int x = Integer.parseInt(enter);
			sum = new int[x];
			int count = 0;
			while(x > 0) {
				String in = IO.reader.readLine();
				if(in.equals("LEFT"))
					sum[count++] = -1;
				else if(in.equals("RIGHT"))
					sum[count++] = 1;
				else if(in.contains("SAME AS")) {
					String number = in.split(" ")[2];
					sum[count++] = sum[Integer.parseInt(number)-1];
				}
				x--;
			}
			int ans = 0;
			for(int i=0; i<sum.length; i++)
				ans += sum[i];
			IO.out.printf("%d\n", ans);
			n--;
		}
	}
}
