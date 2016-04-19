package pd;




public class Knapsack01 {
	

	public static int bottomUp(int weights[], int values[], int MAX, int qItems) {
		if(MAX == 0 || qItems == 0)
			return 0;
		// se o nth item ultrapassar a capacidade MAXIMA da mochila
		// remova-o
		if(weights[qItems] > MAX)
			return bottomUp(weights, values, MAX, qItems-1);
		
		/*
		 * esse problema possui uma subestrutura otima
		 * 
		 * O que estamos tentando fazer e adicionar o item com o maior valor possivel
		 * dessa forma temos 2 casos a analisar
		 * 
		 * 1) Com nth item adicionado a mochila MAXIMIZA a soma dos valores ?
		 * 2) Sem esse item adicionado a mochila a soma dos valores eh Maior ?
		 * 
		 * Temos um problema de MAXIMIZACAO
		 * 
		 * */
		// MAX(nth item incluido, sem o nth item)
		else {
			int withItem 	= values[qItems] + bottomUp(weights, values, MAX - weights[qItems], qItems);
			int withoutItem = bottomUp(weights, values, MAX, qItems - 1);
			return Math.max(withItem, withoutItem);
		}
	}
	
	public static int topDown(int weights[], int values[], int MAX, int qItems) {
		int [][] dp = new int[qItems+1][MAX+1];
		for(int item=0; item<=qItems; item++) {
			for(int weight=0; weight<=MAX; weight++) {
				if(item==0 || weight==0)
					dp[item][weight] = 0;
				else if(weights[weight-1] <= MAX) {
					int add  = values[item-1] + dp[item-1][weight - weights[item-1]];
					int nAdd = dp[item-1][weight];
					dp[item][weight] = Math.max(add, nAdd);
				}
				else
					dp[item][weight] = dp[item-1][weight];
			}
		}
		return 0;
	}
	
	public static void runTest() {
		int [][] weight = {
				
		};
		int [][] values = {
				
		};
		
		int [] capacities = {};
		
		System.out.println(topDown(weight[0], values[0], capacities[0], values[0].length));
		System.out.println(bottomUp(weight[0], values[0], capacities[0], values[0].length));
	}
	
	public static void main(String[] args) {

	}

}
