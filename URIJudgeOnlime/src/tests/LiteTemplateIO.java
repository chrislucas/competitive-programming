package tests;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LiteTemplateIO {
	
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
	
	public static int[] readInts(String del) {
		int array [] = null;
		try {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
			array = new int [tokenizer.countTokens()];
			for(int i=0; tokenizer.hasMoreTokens(); i++) {
				array[i] = Integer.parseInt(tokenizer.nextToken());
			}
		} catch (IOException e) {}
		return array;
	}
	
	public static void println(String fmt, Object ... data) {
		writer.printf(fmt, data);
	}
	
	public static void println(String fmt, Object data) {
		writer.printf(fmt, data);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
