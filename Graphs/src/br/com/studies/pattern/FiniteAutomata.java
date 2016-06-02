package br.com.studies.pattern;

/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-5-finite-automata/
 * 
 * Dado um Texto Text[0 .. n-1] e um padrao Pattern[0..m-1], onde n>m
 * encotnrar todas as ocorrencias da Pattern em Text. Indicar os indices
 * em Text[0 .. n-1] das primeiras ocorrencias
 * 
 * Exemplo
 * Text[] = "AABAACAADAABAAABAA", Pattern [] = "AABA"
 * Ocorrencia em: Text[0], Text[9], Text[13
 * Estudar isso aqui tambem
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 * 
 * 
 * */

public class FiniteAutomata {

	public static void xor() {
		boolean ans = false;
		for(int i=0; i<5; i++) {
			boolean F = (i%2) == 0 ? false : true;
			boolean S = !F;
			ans ^= F ^ S;
		}
		System.out.println(ans);
		System.out.println(0^1^0^1^0);
		System.out.println(0^1^0^1^0^1^0);
	}
	
	/*
	 * In FA (Finite Automata) algorithm, we preprocess
	 * the patetern and build a 2D array tha represents
	 * a FA. Once the FA is built, the searching is simple.
	 * 
	 * We star from the first state of automata and first char
	 * of the text, at every step, we consider next char of text
	 * look for the next state in FA and move to new state
	 * If we reach final state, then pattern was found in text.
	 * Time complexity of the search is O(n)
	 * 
	 * O numero de estados numa FA eh M+1, onde M é o comprimento
	 * do 'pattern' a ser encontrado.
	 * 
	 * A principal ação para a construção da FA é pegar o
	 * proximo estado a partir do estado atual para todos
	 * os caracteres possiveis no pattern
	 * */
	
	public static int nextState(String pattern, int lenPattern, int state, String x) {
		if(state < lenPattern && String.valueOf(pattern.charAt(state)).equals(x)) {
			return state + 1;
		}
		int i;
		for(int ns = state; ns > 0; ns--) {
			if(String.valueOf(pattern.charAt(state)).equals(x)) {
				for (i = 0; i < ns-1; i++) {
					if(pattern.charAt(i) != pattern.charAt(state-ns+i+1))
						break;
				}
				if(i == ns-1)
					return ns;
			}
		}
		return 0;
	}
	
	static final int CHARS = 1<<8;
	
	public static void compute(String pattern, int lenPattern, int [][] table) {
		for(int state=0; state<lenPattern; ++state) {
			for(int x=0; x<CHARS; ++x) {
				table[state][x] =  nextState(pattern, lenPattern, state, String.valueOf((char)x));
			}
		}
	}
	
	public static void search(String pattern, String text) {
		int lenPattern 	= pattern.length();
		int lenText		= text.length();
		// o valor 256 vem do total de numeros de caracteres
		// no patteern e no texto (segundo o tutoriall, 
		// acredito que 256 seja o numero de todos os caracters da tabela ASCII)
		int [][] table = new int [lenPattern+1][CHARS];
		compute(pattern, lenPattern, table);
		int state = 0;
		for(int i=0; i<lenText; i++) {
			state = table[state][text.charAt(i)];
			if(state == lenPattern)
				System.out.printf("Pattern encontrado no indice %d\n", i-lenPattern+1);
		}
	}
	
	public static void run() {
		String pattern 	= "AABAACAADAABAAABAA";
		String text		= "AABA";
		search(pattern, text);
	}
	
	public static void main(String[] args) {
		//xor();
		run();
	}

}
