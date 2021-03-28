package com.br.test.oi;

//import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;

// https://docs.oracle.com/javase/7/docs/api/java/util/StringTokenizer.html
// https://gist.github.com/kerimdzhanov/7529623
// http://tutorials.jenkov.com/java-io/streamtokenizer.html
public class CompTokenizer {
	//http://docs.oracle.com/javase/7/docs/api/java/util/Random.html#nextInt%28int%29
	private static int randomBet(int min, int max, Random random) {
		int n = Math.abs(random.nextInt());
		// min+((n%max)%(max-min))
		// min+ 	-> mantem o numero maior igual a min
		// (n%max)	-> mantem o numero menor igual a max
		// %(max-min) mantem novamente o numero entre o min,
		// pois quando n > min se fizermos min+(n%max) iremos ultrapassar o max
		// exemplo min: 65. max: 90 e n iguak 89, teremos 65+89 > 90
		// não a necessidade de ter um condicional
		return min+((n%max)%(max-min));
		//return n > (min - 1) && n  < (max + 1) ? n : min+((n%max)%(max-min));
	}
	
	// gerar q palavras de tamanho t
	public static String generate(int q, int t, char d) {	
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		char c[];
		int min = 65, max = 90;
		for(int i=0; i<q; i++) {
			c = new char[t+1];
			for(int j=0; j<t; j++) {
				//System.out.printf("%d\n", randomBet(min,max));
				// para manter o n entre 65 e 90
				//c[j] = (char) randomBet(min, max, random);
				//c[j] = (char)(min+((Math.abs(random.nextInt())%max)%(max-min)));
				c[j] = (char) (Math.abs(random.nextInt(max - min + 1) + min));
			}
			c[t] = d;
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		//http://stackoverflow.com/questions/2915276/what-is-the-default-maximum-heap-size-for-suns-jvm-from-java-se-6
		System.out.println(Runtime.getRuntime().maxMemory());
		long s = System.currentTimeMillis();
		Character c = ' ';
		// M<<N shiftlefnt: M*(2 ^ N); M>>N shiftright: M/(2 ^ N)
		int ARRAY_MAX_SIZE = 1<<21; // teste cheuei no max 2200000
		new StringTokenizer(CompTokenizer.generate(ARRAY_MAX_SIZE, 15, c), c.toString());
		System.out.println(System.currentTimeMillis() - s);
		s = System.currentTimeMillis();
		CompTokenizer.generate(ARRAY_MAX_SIZE, 15, c).split(c.toString());
		System.out.println(System.currentTimeMillis() - s);
		StringTokenizer token = new StringTokenizer(CompTokenizer.generate(ARRAY_MAX_SIZE, 15, c), c.toString());
		
/*
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
*/
		/**
		 * Difference between hasMoreElements and hasMoreTokens
		 * hasMoreElements e nextElement sao metodo da interface Enumeration
		 * a classe StringTokenizer os implementa retornando os metodos
		 * hasMoreTokens e nextToken respectivamente
		 * */
/*		
		while(token.hasMoreElements()) {
			System.out.println(token.nextElement());
		}
*/		
		
		
	}

}
