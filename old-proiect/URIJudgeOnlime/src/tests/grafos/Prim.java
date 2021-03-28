package tests.grafos;

public class Prim {


	public static int V, E;
	static final int INFINITY = Integer.MAX_VALUE;

	static int min(int weight[], boolean visited[]) {
		int min = INFINITY;
		int minIndex = 0;
		for(int i=0; i<V; i++) {
			if(!visited[i] && weight[i] <= min) {
				min = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	static int[] prim(int source) {
		int matrix[][] = {
			{0,4,0,0,0,0, 0, 8, 0},
            {4,0, 8, 0, 0, 0, 0, 11, 0},
            {0,8, 0, 7, 0, 4, 0, 0, 2},
            {0,0, 7, 0, 9, 14, 0, 0, 0},
            {0,0, 0, 9, 0, 10, 0, 0, 0},
            {0,0, 4, 0, 10, 0, 2, 0, 0},
            {0,0, 0, 14, 0, 2, 0, 1, 6},
            {8,11, 0, 0, 0, 0, 1, 0, 7},
            {0,0, 2, 0, 0, 0, 6, 7, 0}	
		};
		int matrix2[][] = {
			{0,3,0,0,8,0,0}
			,{3,0,2,2,0,0,0}
			,{0,2,0,3,0,0,0}
			,{0,2,3,0,6,3,0}
			,{8,0,0,6,0,5,7}
			,{0,0,0,3,5,0,4}
			,{0,0,0,0,7,4,0}
		};
		V = matrix2.length;
		// o indice do vetor spanningTree representa o no origem
		// o valor o no destino
		int [] spanningTree = new int[V];
		int [] weight = new int [V];
		boolean[] visited = new boolean[V];
		for(int v=0; v<V; v++) {
			weight[v] = INFINITY;
			visited[v] = false;
		}		
		weight[source] = 0;
		spanningTree[source] = source;	// vertice source nao possue
		for(int k=0; k<V-1; k++) {
			// pega o vertice menos custoso do grafo
			int u = min(weight,visited);
			// marca-0 como visitado
			visited[u] = true;
			// loop para atualizar o peso das arestas alcancadas pelo vertice u
			for(int v=0; v<V; v++) {
				// se ha um caminho de u - v, se v nao foi inserido na spannigTree
				// e se o custo de u - v eh o menor possivel, atualize o custo dos vertices
				// alcancaveis
				if(matrix2[u][v] != 0 && !visited[v] && matrix2[u][v] < weight[v]){
					spanningTree[v] = u;
					weight[v] = matrix2[u][v];
				}
			}
		}
		int total = 0;
		for(int v=0; v<V; v++) {
			int u = spanningTree[v];
			int w = matrix2[v][u];//weight[v];
			System.out.printf("V(%d, %d) W %d\n", u, v, w);
			total += w;
		}
		System.out.printf("Total %d", total);
		return spanningTree;
	}
	
	public static void main(String[] args) {
		prim(2);
	}

}
