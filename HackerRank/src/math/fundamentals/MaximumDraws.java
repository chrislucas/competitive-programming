package math.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.hackerrank.com/challenges/maximum-draws
 * DONE
 * */

public class MaximumDraws {
	
	static PrintWriter writer;
	static BufferedReader reader;
	
	public static int solver(int valor) {
		// n-pares * 2 =  quantidade de meias
		// quantidade / 2 + 1 = maximo de meias a se procurar
		return valor + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			int cases = Integer.parseInt(reader.readLine());
			while(cases > 0) {
				int b = Integer.parseInt(reader.readLine());
				writer.printf("%d\n", solver(b));
			}
		} catch(IOException ioex) {}
	}
}
