package com.br.test.oi;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;

//http://www.codechef.com/wiki/java
public class CompFastIO {

	static BufferedInputStream stream;
	static StringTokenizer token;
	static PrintStream ps;
	static PrintWriter pw;
	
	/** 
	 * BufferedInputStream
	 * @throws IOException 
	 * */
	
	public static void main(String[] args) throws IOException {
		int BUFFER_STREAM = 1<<16;
		BufferedInputStream in = new BufferedInputStream(System.in, BUFFER_STREAM);
		System.out.println(in);
	}
}
