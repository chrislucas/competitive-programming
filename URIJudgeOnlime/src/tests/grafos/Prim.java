package tests.grafos;

public class Prim {


	public static int V, E;
	static final int INFINITY = Integer.MAX_VALUE;
	static void init(int v, int e) {
		V = v;
		E = e;
	}
	
	static int min(int weight[], boolean notVisited[]) {
		int min = INFINITY;
		int minIndex = 0;
		for(int i=0; i<V; i++) {
			if(!notVisited[i] && weight[i] <= min) {
				min = weight[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	static int[] prim(int source) {
		int matrix[][] = {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 0, 10, 0, 2, 0, 0},
            {0, 0, 0, 14, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}	
		};
		// o indice do vetor spanningTree representa o no origem
		// o valor o no destino
		int [] spanningTree = new int[V];
		int [] weight = new int [V];
		boolean[] notVisited = new boolean[V];
		for(int v=0; v<V; v++) {
			weight[v] = INFINITY;
			notVisited[v] = false;
		}		
		weight[source] = 0;
		spanningTree[source] = source;	// vertice source nao possue
		for(int k=0; k<V-1; k++) {
			// pega o vertice menos custoso do grafo
			int u = min(weight,notVisited);
			// marca-0 como visitado
			notVisited[u] = true;
			// loop para atualizar o peso das arestas alcancadas pelo vertice u
			for(int v=0; v<V; v++) {
				// se ha um caminho de u - v, se v nao foi inserido na spannigTree
				// e se o custo de u - v eh o menor possivel, atualize o custo dos vertices
				// alcancaveis
				if(matrix[u][v] != 0 && !notVisited[v] && matrix[u][v] < weight[v]){
					spanningTree[v] = u;
					weight[v] = matrix[u][v];
				}
			}
		}
		int total = 0;
		for(int v=0; v<V; v++) {
			int u = spanningTree[v];
			int w = matrix[v][u];//weight[v];
			System.out.printf("V(%d, %d) W %d\n", u, v, w);
			total += w;
		}
		System.out.printf("Total %d", total);
		return spanningTree;
	}
	
	public static void main(String[] args) {
		init(9,14);
		prim(0);
	}

}
