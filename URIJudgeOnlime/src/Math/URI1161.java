package Math;
//Done
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1161 {
	
	public static final int MAX = 22;
	public static final long[] fatorial = new long[MAX];

	public static void init() {
		fatorial[0] = 1;
		fatorial[1] = 1;
		for(int i=2; i<MAX; i++) {
			fatorial[i] = fatorial[i-1] * i;
		}
	}
	static class CompReader {
		BufferedReader buffer;
		InputStream in;
		InputStreamReader inr;
		PrintWriter out;
		StringTokenizer token;
		
		public CompReader() {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			token = null;
		}
		
		public String next(String delimiter) {
			return tokenize(delimiter) ? token.nextToken() : null;
		}
		
		private boolean tokenize(String delim) {
			String line = null;
			while(token == null || !token.hasMoreTokens()) {
				// leitura ate o EOF
				try {
					if( (line = buffer.readLine()) == null )
						return false;
					/*if( (line = buffer.readLine()).equals("0 0") )
						return false;*/
				} catch (IOException e) {}
				token = new StringTokenizer(line, delim);
			}			
			return true;
		}
		public int nextInt(String del) { return Integer.parseInt(next(del)); }
		public int[] arrayInt(String del, int size) {
			int array[] = new int[size];
			for(int idx = 0;idx<size;) {
				String ans = next(del);
				if(ans == null)
					return null;
				else
					array[idx++] = Integer.parseInt(ans);
			}
			return array;
		}
		public double nextDouble(String del) { return Double.parseDouble(next(del)); }
		public double[] arrayDouble(String del, int size) {
			double[] array = new double[size];
			for(int idx=0;idx<size;) {
				array[idx++] = nextDouble(del);
			}
			return array;
		}
		public long nextLong(String del) { return Long.parseLong(next(del)); }
		public long[] arrayLong(String del, int size) {
			long[] array = new long[size];
			for(int idx=0;idx<size;) {
				array[idx++] = nextLong(del);
			}
			return array;
		}
	}
	//Done
	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		CompReader reader = new CompReader();
		PrintWriter out = new PrintWriter(System.out, true);
		int[] in = new int[2];
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//String enter;
		while ( (in = reader.arrayInt(" ", 2)) != null ) {
			//String in[] = enter.split(" ");
			int n = in[0];//Integer.parseInt(in[0]);
			int m = in[1];//Integer.parseInt(in[1]);
			out.println(fatorial[n] + fatorial[m]);
		}
	}
}
