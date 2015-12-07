package tests.grafos;

public class HamiltonianCycle {
	
	static int vertices;
	static boolean [] visited;

	static int [][] createMatrix() {		
		int [][] map = new int[][] {
			{0,1,0,1,0}
			,{1,0,1,1,0}
			,{0,1,0,0,1}
			,{1,1,0,0,1}
			,{0,1,1,1,0}
		};
		vertices = map.length;
		visited = new boolean[vertices];
		return map;
	}
	
	public static boolean verify(int [][] map, int[] path, int u) {
		// se 'u' eh o ultimo vertice
		if(u == vertices) {
			// se a um caminho do 'u' para o primeiro vertice 
			if(map[path[u-1]][path[0]] == 1) {
				return true;
			} else {
				return false;
			}
		}
		
		for(int v=1; v<vertices; v++) {
			boolean f = true;
			for(int i=0; i<u; i++) {
				if(path[i] == v) {
					f = false;
					break;
				}
			}
			if(!f)
				continue;
			int s = path[u-1];
			// se a um caminho de 'u-1' a 'v'
			if(map[s][v] == 1 /* && !visited[v] */) {
				path[u] = v;
				// visited[v] = true;
				if(verify(map, path, u + 1))
					return true;
				path[u] = -1;
			}
		}
		return false;
	}
	
	public static boolean hasHamiltonianCycle(int [][] map, int source) {
		int [] path = new int[vertices];
		for(int i=0; i<vertices; i++)
			path[i] = -1;
		path[source] = 0;
		if(!verify(map, path, 1)) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hasHamiltonianCycle(createMatrix(), 0));
	}

}
