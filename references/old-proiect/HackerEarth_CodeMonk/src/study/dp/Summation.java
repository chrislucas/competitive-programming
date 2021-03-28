package study.dp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Summation {
	
	/**
	 * 
	 * Problema da soma minima de moedas
	 * 
	 * */

	public static int solution(int[] coins, int S) {
		int limit = coins.length;
		int [] SET = new int[S+1];
		for(int i=0; i<S+1; i++) {
			SET[i] = Integer.MAX_VALUE;
		}
		SET[0] = 0;
		for(int i=1; i<=S; i++) {
			for(int j=0; j<limit; j++) {
				int v = coins[j];
				if(v <= i && SET[i-v]+1 < SET[i]) {
					SET[i] = SET[i-v]+1;
				}
			}
		}
		return SET[S];
	}
	/**
	 * Retorna um mapa<Soma, Moedas usadas>
	 * */
	public static Map<Integer, List<Integer>> f(int [] coins, int sum) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		return map;
	}
	
	/**
	 * Menor subsequencia crescente (longest increase subsequence)
	 * http://www.ime.usp.br/~pf/analise_de_algoritmos/aulas/sscm.html
	 * */
	
	public static int lisFx(int [] SET) {
		int answer = 1;
		int [] memo = new int[SET.length];
		for(int i=0; i<SET.length; i++)
			memo[i] = Integer.MAX_VALUE;
		memo[0] = 1;
		for(int i=0; i<SET.length; i++) {
			
		}
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1,3,5,11}, 23));

	}

}
