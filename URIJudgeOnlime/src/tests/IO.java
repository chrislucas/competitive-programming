package tests;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IO {

	/**
	 * @version 0.1
	 * */
	static class FASTIO {
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
