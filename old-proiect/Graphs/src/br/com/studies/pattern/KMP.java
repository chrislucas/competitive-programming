package br.com.studies.pattern;

/*
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * */

public class KMP {
	/*
	 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
	 * */
	public static void NaiveApproach(String pattern, String text) {
		int lp = pattern.length();
		int lt = text.length();
		int df = lt - lp >= 0 ? lt - lp : -(lt - lp);
		for(int i=0; i<=df; i++) {
			int j = 0;
			while(j<lp) {
				if(text.charAt(i+j) != pattern.charAt(j))
					break;
				j++;
			}
			if(j == lp) {
				System.out.printf("Pattern encontrado em %d\n", i);
				// talvez isso acelere um pouco as coisas
				i += j-1;
			}
				
		}
	}
	
	/*
	 * algoritmo KMP preprocessa o pattern e constroi um array auxiliar
	 * chamado lps[] com o tamanho do pattern.
	 * LPS = Logenst proper prefix (Maior prefixo adequado) ou suffix
	 * 
	 * Para cada sub pattern[0 .. i] onde i = 0 ate m-1 (m sendo o tamanho do pattern).
	 * lps[i] armazena o tamanho maximo do LPS ou sufixo do sub-pattern[0..1]
	 * 
	 * */
	
	public static void compLPS(String pattern, int lenPattern, int [] lps) {
		
	}
	
	public static void kmp(String pattern, String text) {
		int lenPattern 	= pattern.length();
		int lenText		= text.length();
	}
	
	public static void run() {
		String text = "AABAACAADAABAAABAA", pattern = "AABA";
		NaiveApproach(pattern, text);
		text = "ABABDABACDABABCABAB";
		pattern = "ABABCABAB";
		kmp(pattern, text);
	}

	public static void main(String[] args) {
		run();
	}

}
