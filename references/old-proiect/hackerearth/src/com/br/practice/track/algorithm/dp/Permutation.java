package com.br.practice.track.algorithm.dp;

import java.util.Arrays;

/*
 * http://codeforces.com/blog/entry/3980
 * https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 * */

public class Permutation {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean np(Comparable [] S) {
		int idx = getIdx(S);
		if(idx == -1)
			return false;
		int lim = S.length - 1;
		
		// left >= right element
		while(S[idx].compareTo(S[lim]) >= 0)
			--lim;
		
		flip(idx++, lim, S);
		lim = S.length - 1;
		while(idx < lim)
			flip(idx++, lim--, S);
		
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean nthp(Comparable [] S, int nth) {
		return false;
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	public static void flip(int a, int b, Comparable [] S) {
		Comparable aux = S[a];
		S[a] = S[b];
		S[b] = aux;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int getIdx(Comparable [] S) {
		int lim = S.length - 2;
		for(int i = lim; i>=0; i--) {
			if(S[i].compareTo(S[i+1]) < 0)
				return i;
		}
		return -1;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static void runTestNextPermutation() {
		Comparable S [] = {0,1,2,3};
		np(S);
		System.out.println(S.toString());
		/*
		while(np(S)) {
			System.out.println(Arrays.toString(S));
		}
		*/
	}
	
	public static void main(String[] args) {
		runTestNextPermutation();
	}
	
}
