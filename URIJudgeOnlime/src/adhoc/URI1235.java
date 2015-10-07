package adhoc;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1235 {
	static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

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
	
	public static void main(String[] args) throws IOException {
		//CompReader reader = new CompReader();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String in = reader.readLine();
		int x = Integer.parseInt(in);
		for(int i=0; i<x; i++) {
			//int size[] = reader.arrayInt(" ", 3);
			in = reader.readLine();
			int sizeStr = in.length();
			int mid = sizeStr/2;
			//char[] answer = new char[sizeStr];
			String answer = "";
			int limit = in.charAt(mid) == ' ' ? sizeStr-1 : sizeStr;
			for(int j=0; j<limit; j++) {
				if(j < mid) {
					char c = in.charAt(mid - (j+1));
					answer = answer.concat(Character.toString(c));
					//answer[mid - (j+1)] = in.charAt(j);
				} else {
					char c = in.charAt(sizeStr -(j - mid  + 1));
					answer = answer.concat(Character.toString(c));
					//answer[mid + (sizeStr-j-1)] = in.charAt(j);
				}	
			}
			//answer = answer.charAt(answer.length() - 1) == ' ' ? answer.substring(0, (answer.length()-2)) : answer;
			String format = (i<x-1) ? "%s\n" : "%s";
			out.printf(format, answer);
		}
	}
}
