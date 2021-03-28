package com.br.practice.track.algorithm.dp;

/*
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 * */

public class Bitmskdp {

	
	public static int setNBit(int val, int nth) {
		return val | 1 << nth;
	}
	
	public static int unsetNBit(int val, int nth) {
		return val & ~(1 << nth);
	}
	
	public static boolean isSetNBit(int val, int nth) {
		return (val & 1 << nth) > 0;
	}
	
	public static boolean isSetNBit2(int val, int nth) {
		// val / 2 ^ nth
		return	(val >> nth & 1) > 0;
	}
	
	public static int toggleBit(int val, int nth) {
		return val ^ 1 << nth;
	}
	
	/*
	 * Problema
	 * 
	 * Imagine que temos N pessoas quaisquer para realizar N tarefas
	 * cada pessoas pode realizar somente uma tarefa, e cada tarefa
	 * sera cobrada pela pessoa que realiza-la
	 * 
	 * 
	 * Dada uma matriz NxN, tal que essa matriz seja a representacao do
	 * custo de cada tarefa realizada por cada pessoa, de modo que a 
	 * matrix[i][j] nos diz: a i-th pessoa realizara a j-th tarefa e 
	 * matrix[i][j] armazeza o custo cobrado pela i-th pessoa
	 * 
	 * Designe cada tarefa a cada pessoa de modo a minimizar o custo total
	 * 
	 * 
	 * */
	
	
	public static int nSol(int N, int [][] cost) {
		int assignment [] = new int [N];
		for(int i=0; i<N; i++)
			assignment[i] = i;
		int ans = Integer.MAX_VALUE;
		// fact(N)
		int limit = N;
		for(int i=N-1; i>1; i++) {
			limit *= i;
		}
		for(int i=0; i<limit; i++) {
			int acc = 0;
			for(int j = 0; j < N; j++) {
				acc += cost[j][assignment[j]];
			}
			ans = Math.min(ans, acc);
			npInt(assignment);
		}
		return ans;
	}
	
	public static boolean npInt(int [] S) {
		/*
		 * 
		 * 1 - achar o maior idx k tal que S[k] < S[k+1]
		 * se tal indice nao existir, ja foram todas as permutacoes
		 * */
		int k = largestIdx(S);
		
		/*
		 * 
		 * 
		 * */
		return false;
	}
	
	public static int largestIdx(int [] S) {
		int idx = S.length - 2;
		while(idx>=0) {
			if(S[idx] > S[idx+1]) {
				return idx;
			}
			--idx;
		}
		// a ultima permutacao
		return -1;
	}
	
	/*
	 * Dado um conjunto de M numeros inteiros
	 * contar quantos subconjuntos formados por M inteiros
	 * existem, tal que a soma dos M inteiros e maior ou igual
	 * a um valor arbritario
	 * 
	 * A {n+1, n+2, ..., n+n}
	 * */
	public static int countSubsets(int [] set, int value) {
		int count = 0;
		int len = set.length;
		for(int i=0; i<(1<<len); i++) {
			int acc = 0;
			for(int j=0; j<len; j++) {
			//for(int j=len-1; j>-1; j--){
				if( (i & 1<<j) > 0) {
					System.out.printf("1");
					acc += set[j];
				}
				else
					System.out.printf("0");
			}
			System.out.printf("\n");
			//count += acc >= value ? 1 : 0;
			if(acc>=value)
				count++;
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(setNBit(setNBit(10, 2), 0));
		//System.out.printf("%d %d %d\n", unsetNBit(10, 1), ~(1 << 1), ~10);
		//System.out.println(isSetNBit2(128, 6));
		//System.out.println(toggleBit(10, 2));
		int [][] multiset = {
			{1,2,3}
		};
		System.out.println(countSubsets(multiset[0], 4));
	}

}
