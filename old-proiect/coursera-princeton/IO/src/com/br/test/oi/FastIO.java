package com.br.test.oi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

// na verdade soh tera metodos de input
// http://www.cpe.ku.ac.th/~jim/java-io.html
public class FastIO {
	
	public static int fastReadI(int c, String delim) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		int last = 0;
		while(c-- > 0) {
			if( ! token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(buffer.readLine(), delim);
				} catch (IOException e) {}
			}
			last = Integer.parseInt(token.nextToken());
		}
		return last;
	}
	
	static class Process {
		static BufferedReader reader;
		static StringTokenizer token;
		static void init() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			token = new StringTokenizer("", " ");
		}
		
		static void init(String delim) {
			try {
				// StringTokenizer tem uma sobrecarga de construtor
				// StringTokenizer(String in); StringTokenizer(String in, String delim);  StringTokenizer(String in, Boolean)
				token = new StringTokenizer(reader.readLine(), delim);
				while(token.hasMoreElements()) { System.out.printf("%s ", token.nextElement());}
			} catch(IOException e) {}
		}
		
		private static String next() {
			while(token != null && ! token.hasMoreTokens()) {
				try {
					token = new StringTokenizer(reader.readLine());
				} catch(IOException e) {}
			}
			return token.nextToken();
		}
		
		static int nextI() {
			return Integer.parseInt(next());
		}
		
		static double nextD() {
			return Double.parseDouble(next());
		}

		static float nextF() {
			return Float.parseFloat(next());
		}
		
		static BigDecimal nextBigDecimal() {
			return new BigDecimal(next());
		}
		
		static BigInteger nextBigInteger() {
			return new BigInteger(next());
		}
	}

	public static void main(String[] args) {
		Process.init();
		//Process.init(";");
		//try {PrintStream ps = new PrintStream(System.out, true, "UTF-8");} catch (UnsupportedEncodingException e1) {}			
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "UTF-8"), true);
			pw.println(Process.nextD());
		} catch(UnsupportedEncodingException e) {}
		
		try {
			Process.reader.close();
		} catch (IOException e) {}
	}
	
}
