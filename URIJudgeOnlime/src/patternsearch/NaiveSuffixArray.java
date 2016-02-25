package patternsearch;

import java.util.Arrays;


// http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
// https://en.wikipedia.org/wiki/Suffix_array
	
public class NaiveSuffixArray {

	static class Suffix implements Comparable<Suffix> {
		int index;
		String str;
		public Suffix(int index, String str) {
			this.index = index;
			this.str = str;
		}
		@Override
		public int compareTo(Suffix that) {
			return this.str.compareTo(that.str);
		}
	}
	/**
	 * Suffix[] suffix; Esse array contem em cada indice, um objeto
	 * com uma Substring S (uma String menor) de uma data String T e um
	 * inteiro I que demarca onde essa substring começa dentro da String
	 * Exemplo: String = "banana"
	 * suffix[0] = {Sustring subs = "banana", 0}
	 * suffix[1] = {Sustring subs = "anana", 1}
	 * */
	static Suffix [] suffixes;
	/**
	 * 
	 * Ao ordenar lexograficamente o array Suffix[] suffix
	 * temos os indices de onde cada substring comeca;
	 * Esses indices sao armazenados no array int [] suffixArray
	 * */
	static int [] suffixArray;
	
	/**
	 * Longest common prefix;
	 * 
	 * esse array indica o tamanho da maior string common entre
	 * dois prefixos subjacentes
	 * */
	static int [] lcp;
	
	// poderia ter retorno void, mas nao quero :(
	static int [] buildSuffixArray(String text, int sizeText) {

		suffixes 			= new Suffix[sizeText];
		int [] suffixArray 	= new int[sizeText];
		lcp 				= new int[sizeText];
		
		for(int i=0; i<sizeText; i++) {
			suffixes[i] = new Suffix(i, text.substring(i, sizeText));
		}
		
		Arrays.sort(suffixes);
		
		for(int i=0; i<sizeText; i++) {
			suffixArray[i] = suffixes[i].index;
		}
		
		for(int i=0; i<sizeText-1; i++) {
			lcp[i] = calcLCP(suffixes[i], suffixes[i+1]);
		}
		
		return suffixArray;
	}
	
	/**
	 * calcula o tamanho da maior string comum a dois sufixxos
	 * */
	public static int calcLCP(Suffix s, Suffix t) {
		String a = s.str, b = t.str;
		int size = Math.min(a.length(), b.length());
		for(int i=0; i<size; i++) {
			if(a.charAt(i) != b.charAt(i))
				return i;
		}
		return size;
	}
	
	public static void printSuffixArray() {
		for(Suffix s : suffixes) {
			System.out.printf("%d %s\n", s.index, s.str);
		}
	}
	
	public static Suffix findSuffix(int n) {
		return n < suffixes.length ? suffixes[n] : null;
	}
		
	public static int searchPattern(String pattern, String text, int[] suffixArr, int sizeText) {
		int sp = pattern.length();
		int l = 0, r = sizeText;
		// bsearch
		while(l<=r) {
			int middle = (r-l)/2+l;
			// suffixArr[i] nos diz aonde a i-th substring comeca
			int ith = suffixArr[middle];
			// <block>
			// esse bloco compara o pattern (padrao) procurado com os prefixos da String "text"
			// o padrao pode ser uma substring do prefixo, dessa forma procuramos o tal padrao
			// dentro da substring da variavel prefix(0, tamanho do pattern ou tamanho do prefixo)
			// como se utilizassemos a funcaon strncmp do CPP cuja assinatura eh
			// strncmp(str1, str2, maximo de caracteres a serem comparados na str1)
			String suffix = text.substring(ith, text.length());
			// pegar uma sunstring do suffix to tamanho do padrao que estamos procurando
			String subsfx = suffix.substring(0, sp > suffix.length() ? suffix.length() : sp);
			//</block>
			// comparar o padrao com um suffix de mesmo tamanho
			int comp = pattern.compareTo(subsfx);
			if(comp == 0) {
				return ith;
			}
			if(comp < 0)
				r = middle - 1;
			else
				l = middle + 1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String [] text = {"banana", "bananananica"};
		suffixArray = buildSuffixArray(text[0], text[0].length());
		printSuffixArray();
		System.out.println(searchPattern("anan", text[0], suffixArray, text[0].length()));
	}

}
