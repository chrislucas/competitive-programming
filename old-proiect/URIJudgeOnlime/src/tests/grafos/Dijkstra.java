package tests.grafos;

//import java.util.ArrayList;
//import java.util.PriorityQueue;
//import java.util.Queue;

public class Dijkstra {

	static final int INFINITY = Integer.MAX_VALUE;
	static int V, E;
	/*
	static void init(int v, int e) {
		V = v;
		E = e;
	}
	*/
	// verifica Qual no nao incluso na AGM tem menor custo para ser alca�ado
	// o vertice como menor custo eh retornado
	static int minDistance(int dist[], boolean mst[]) {
		int min = INFINITY, minIdx = 0;
		for(int i=0; i<V; i++) {
			if(mst[i] == false && dist[i] < min) {
				min = dist[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	
	static int[] dijkstraMatrix(int source) {
		
		// matrix e boolean mst soh existem quando usado matriz de adhacencia
		int matrix[][] = {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
			/*{0,3,0,3,0,0}
			,{3,0,1,3,0,0}
			,{0,1,0,2,0,3}
			,{3,1,2,0,2,0}
			,{0,0,0,2,0,2}
			,{0,0,3,0,2,0}*/
		};
		V = matrix.length;
		boolean mst[] = new boolean[V];
		int distance[] = new int[V];
		int path[] = new int[V];
		for(int i=0; i<V; i++) {
			distance[i] = INFINITY;
			mst[i] 		= false;
		}
		distance[source] = 0;
		path[source] = source;
		for(int i=0; i<V; i++) {
			int minNode = minDistance(distance, mst);
			mst[minNode] = true;	// adiciona
			for(int j=0; j<V; j++) {
				int cost = distance[minNode] + matrix[minNode][j];
				if( ! mst[j] && matrix[minNode][j] > 0
						// && distance[minCost] != INFINITY
						&& cost < distance[j]) {
					distance[j] = cost;
					path[j] = minNode;
				}
			}
		}
		// find path
		for(int i=0; i<V;i++) {
			int node = i;
			int pre = path[i];
			System.out.printf("V(%d): ", i);
			while(true) {
				System.out.printf("%d ", pre);
				if(pre == source)
					break;
				node = pre;
				pre = path[node];
			}
			System.out.println("");
		}
		return distance;
	}	
	
	public static void main(String[] args) {
		//init(9, 14);
		dijkstraMatrix(0);

	}

}
