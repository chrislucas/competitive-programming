package com.br.test.oi;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.StringTokenizer;

public class CompStreamTokenizer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// http://docs.oracle.com/javase/7/docs/api/java/io/StreamTokenizer.html
		// classe obsoleta
		@SuppressWarnings("deprecation")
		StreamTokenizer st = new StreamTokenizer(new StringReader("Teste\n123\n456\n;\n\"\"\n \"Outroteste\" "));
		while(st.nextToken() != StreamTokenizer.TT_EOF) {
			System.out.println(st.toString());
		}
		
		// docs oracle
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer t = new StringTokenizer(r.readLine(), " ");
		for(;t.hasMoreTokens();) {
			System.out.println(t.nextToken());
		}
	}

}
