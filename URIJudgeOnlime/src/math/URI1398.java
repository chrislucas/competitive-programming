package math;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1398
 * */
public class URI1398 {
	
	static class IO {		
		private static BufferedReader reader;
		private static PrintWriter writer;
		private static StringTokenizer token;
		
		public static void init()  {
			boolean oj 	= System.getProperty("ONLINE_JUDGE") == null;
			try {
				reader 		= oj ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader("input.txt"));
				writer 		= oj ? new PrintWriter(new OutputStreamWriter(System.out), true) : new PrintWriter(new FileWriter("output.txt"));
				token 		= null;
			} catch (IOException e) {}
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
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
				
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	private static final int MOD = 131071;
	
	public static void solver(String bin) {
		int acc = 0;
		// conversao base 2 para base 10 passo a passo
		// usando aritmetica modular
		for(int idx=0; idx<bin.length(); idx++) {
			acc = acc * 2/*acc << 1*/;
			acc += bin.charAt(idx) & 0x0f;
			acc %= MOD;
		}
		IO.printf("%s\n", acc == 0 ? "YES" : "NO");
	}
	
	public static int fromBaseToDec(String number, int base) {
		int acc = 0;
		for(char n : number.toCharArray()) {
			acc *= base;
			acc += n & 0x0f;
		}
		return acc;
	}
	
	public static void readIn() {
		IO.init();
		String line = null;
		while( (line = IO.read()) != null ) {
			StringBuilder sb = new StringBuilder();
			sb.append(line);
			while( ! sb.toString().endsWith("#") ) {
				sb.append(IO.read());
			}		
			solver(sb.toString());
		}
	}
	
	public static void opAnd() {
		//char [] ns = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		//VALOR EM HEXADECIMAL DA TABELA ASCII
		//http://ic.unicamp.br/~everton/aulas/hardware/tabelaASCII.pdf
		byte [] bs = {0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09};
		System.out.println(0x02 & 0xF);
		for(byte n : bs) {
			System.out.printf("%d %d\n", n, (int)(n & 0xF));
		}
	}
	
	public static void main(String[] args) {
		//opAnd();
		//fromBaseToDec("171", 8);
		readIn();
	}

}
