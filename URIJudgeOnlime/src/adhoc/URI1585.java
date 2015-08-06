package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1585 {
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
				array[idx++] = nextInt(del);
			}
			return array;
		}
		public double nextDouble(String del) { return Double.parseDouble(next(del)); }
		public long nextLong(String del) { return Long.parseLong(next(del)); }
	}
	
	public static void main(String[] args) {
		CompReader reader = new CompReader();
		PrintWriter out = new PrintWriter(System.out, true);
		int n = reader.nextInt("");
		while(n>0){
			int data[] = reader.arrayInt(" ", 2);
			// http://www.mundoeducacao.com/matematica/area-losango.htm
			// 3 formas de calcular área de um losango
			// multiplicando as diagonais e dividir 2
			// multiplicando base * altura
			// Lado^2 *  seno(um dos angulos do losango)
			out.printf("%d cm2\n", (data[0] * data[1]) / 2);
			n--;
		}
	}
}
