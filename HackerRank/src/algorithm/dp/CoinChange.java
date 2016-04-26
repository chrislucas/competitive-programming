package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * http://www.algorithmist.com/index.php/Coin_Change
 * https://sohagbuet.wordpress.com/2014/03/27/coin-change-problem/
 * https://www.hackerrank.com/challenges/coin-change
 * 
 * Problema do TROCO. Dado um conjunto de Moedas C = {C1, C2, C3 ... Cn}
 * com quantidade infinita de Cn (veja, temos ilimitadas C1 C2 Cn). De quantas
 * formas e poss�vel combina-las para atingir um valor N
 * 
 * Por exemplo
 * 
 * N = 4, C = {1,2,3}
 * S = { 
 * 	{1,1,1,1}, {1,1,2}, {2,2}, {1,3}
 * }
 * Subestrutura otima
 * 1 - solucoes com a nth moeda, 2 - solucoes sem a nth moeda
 * 2 - solucoes que com tem ao menos 1 da Cn moedas
 * 
 * */

public class CoinChange {
	
	public static int bottomUp(int [] coins, int N) {
		int s = coins.length;
		int [][] space = new int[N+1][s];
		/**
		 * Para N = 0 ou seja troco = 0
		 * ha uma solucao 1
		 * preencher a matriz com o caso 0 onde N = 0
		 * */
		for(int i=0; i<s; i++)
			space[0][i] = 1;
		
		// i rerresenta a quantidade N de troco
		// comenado com valor 1 verificamos quais moedas
		// sao usadas para cheger ao valor 'i'
		for (int i=1; i<N+1; i++) {
			// j representa a n-esima moeda do conjunto
			for (int j=0; j<s; j++) {
				// incluindo a j-esima moeda
				int d = i - coins[j];
				int x = d >= 0 ? space[d][j] : 0;
				// excluindo a jth moeda
				int y = j > 0 ? space[i][j-1] : 0;
				space[i][j] = x + y;
			}
		}
		return space[N][s-1];
	}
	
	public static int topDown(int [] coins, int changes, int N) {
		// se o valor a ser alcancado for 0, existe 1 solucao
		// nenhuma moeda
		if(N == 0)
			return 1;
		
		if(N < 0)
			return 0;
		
		if(changes <= 0 && N >= 1)
			return 0;
		
		int including = topDown(coins, changes - 1, N);
		int excluding = topDown(coins, changes, N - coins[changes - 1]);
		
		return including + excluding;
	}
	
	
	/**
	 * Diminuindo o custo de espaço para N
	 * */
	public static int reduceSpaceBottomUp(int [] coins, int N) {
		int s = coins.length;
		int [] space = new int[N+1];
		/**
		 * Novamente o caso base 0 de troco, tem 1 solucao
		 * nao usar moeda alguma
		 * */
		space[0] = 1;
		for(int i=0; i<s; i++) {
			for(int j=coins[i]; j<=N; j++) {
				space[j] += space[j - coins[i]];
			}
		}
		
		return space[N];
	}
	

	/**
	 * Tentando algo diferente
	 * */
	public static int f(int [] coins, int N) {
		int s = coins.length;
		int [] space = new int[N+1];

		space[0] = 1;		
		//como sera que esse parte de comporta ?
		for(int i=1; i<=N; i++) {
			for(int j=0; j<s; j++)
				space[i] += space[ i - coins[j] < 0 ? 0 : i - coins[j] ];
		}
		return space[N];
	}
	
	public static void run() {
		int [] coins = {1,2,3};
		int N = 4;
		System.out.println(topDown(coins, coins.length, N));
		System.out.println(bottomUp(coins, N));
		System.out.println(reduceSpaceBottomUp(coins, N));
		System.out.println(f(coins, N));
	}
	
	public static void main(String[] args) {
		run();
		CompIO.init();
	}
	
	public static class CompIO {
		private CompIO() {  throw new UnsupportedOperationException(); }
		private static BufferedReader buffer;
		private static PrintWriter writer;
		private static StringTokenizer tk;
		
		public static void init() {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read(String delimiter) {
			while(tk == null || ! tk.hasMoreTokens()) {
				try {
					if(delimiter == null)
						tk = new StringTokenizer(buffer.readLine());
					else
						tk = new StringTokenizer(buffer.readLine(), delimiter);
				} catch(IOException ioex){}
			}
			return tk.nextToken();
		}
		
		public static String readLine() {
			String line = null;
			try {
				line = buffer.readLine();
			} catch(IOException ioex) {}
			return line;
		}
		
		public static String read() {
			return read(null);
		}
		
		public static int readInt(String delimiter) {
			return Integer.parseInt(read(delimiter));
		}
		
		public static double readDouble(String delimiter) {
			return Double.parseDouble(read(delimiter));
		}
		
		public static long readLong(String delimiter) {
			return Long.parseLong(read(delimiter));
		}
		
		public static int [] readInts(String delimiter) {
			StringTokenizer token = new StringTokenizer(readLine(), delimiter);
			int i = 0, array []  = new int[token.countTokens()];
			while(token.hasMoreTokens()) {
				array[i++] = Integer.parseInt(token.nextToken());
			}
			return array; 
		}
		
		public static void pritf(String format, Object ... objects) {
			writer.printf(format, objects);
		}
		
		public static void print(String data) {
			writer.printf("%s\n", data);
		}
	}

}
