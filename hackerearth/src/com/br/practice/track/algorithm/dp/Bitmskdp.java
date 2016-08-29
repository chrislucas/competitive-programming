package com.br.practice.track.algorithm.dp;

/*
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/bit-masking/tutorial/
 * */

public class Bitmskdp {

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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
