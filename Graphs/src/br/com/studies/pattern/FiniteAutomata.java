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
	
	public static void main(String[] args) {
		xor();
	}

}
