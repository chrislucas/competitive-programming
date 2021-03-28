package adhoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1266
 * */
public class URI1266 {
	static class LiteTemplateIO {
		
		private static BufferedReader reader;
		private static PrintWriter writer;
		
		public static void init()  {
			boolean oj 	= System.getProperty("ONLINE_JUDGE") == null;
			try {
				reader 		= oj ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader("input.txt"));
				writer 		= oj ? new PrintWriter(new OutputStreamWriter(System.out), true) : new PrintWriter(new FileWriter("output.txt"));
			} catch (IOException e) {}
		}
		
		public static String read(String del) {
			StringBuilder builder = new StringBuilder();
			try {
				StringTokenizer tokenize = new StringTokenizer(reader.readLine(), del);
				while(tokenize.hasMoreTokens()) {
					builder.append(tokenize.nextToken());
				}
			} catch (IOException e) {}
			return builder.toString();
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static Integer[] readInts(String del) {
			Integer array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new Integer [tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Integer.parseInt(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	public static void solution(int [] array) {
		int S = array.length;
		int i;
		int count = 0;
	}
	
	public static void main(String[] args) {
		LiteTemplateIO.init();
		solution(new int[] {0,0,0,0,0});
	}

}
