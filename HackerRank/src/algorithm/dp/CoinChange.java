package algorithm.dp;

/*
 * https://www.hackerrank.com/challenges/coin-change
 * 
 * Problema do TROCO. Dado um conjunto de Moedas C = {C1, C2, C3 ... Cn}
 * com quantidade infinita de Cn (veja, temos ilimitadas C1 C2 Cn). De quantas
 * formas e possível combina-las para atingir um valor N
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
				int x = d > 2 ? space[d][j] : 0;
				// excluindo a jth moeda
				int y = j > 0 ? space[i][j-1] : 0;
				space[i][j] = x + y;
			}
		}
		return space[N][s];
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
