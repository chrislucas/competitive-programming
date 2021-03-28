package tests.grafos;

import java.util.ArrayList;

public class DetectCycleGraphIII {
	

	/*
	 * Coloracao dos vertices
	 * W: WHITE, vertices que nao foram visitados ainda
	 * 
	 * G: GRAY, cor do vertice que esta sendo visitado, vertice corrente
	 * o vertice CINZA so mudara para PRETO, quando ele e seus vertices descendentes
	 * tiverem sido alcancados
	 * caso encrontemos um vertice CINZA no meio da DFS(), eh porque existe um ciclo no grafo
	 * so assim poderiamos ter voltado para o vertice CINZA
	 * 
	 * B: BLACK, indica que tal vertice e seus descententes foram todos visitados
	 * */
	
	public static final int W = 0, G = 1, B = 2;
	
	public static class Edge implements Comparable<Edge> {
		int s, d, w;
		Edge (int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge that) {
			return this.w - that.w;
		}
	}
	
	public static ArrayList<ArrayList<Edge>> list;
	public static int [] color, moment;
	public static int vertices, time = 0;
	
	public DetectCycleGraphIII(int vertx) {
		vertices 	= vertx;
		color 		= new int[vertx];
		moment		= new int[vertx];
		list 		= new ArrayList<>();
		for(int i=0; i<vertx; i++)
			list.add(new ArrayList<>());
	}
	
	public static void add(Edge edge) {
		list.get(edge.s).add(edge);
	}
	
	
	public static boolean dfs(int source) {
		color[source] = G;
		for(Edge edge : list.get(source)) {
			if(color[edge.d] == G)
				return true;
			// esse condicional
			// if(color[edge.d] == W && dfs(edge.d)) return true;
			// eh igual ao abaixo, porem para mim o debaixo eh mais intuitivo
			if(color[edge.d] == W) {
				// se encontrar um ciclo, vai ficar retornando TRUE ate devolver todos os nos da pilha
				if(dfs(edge.d))
					return true;
			}
			
		}
		color[source] = B;
		return false;
	}
	
	
	public static boolean execute() {
		// https://algocoding.wordpress.com/2015/04/02/detecting-cycles-in-a-directed-graph-with-dfs-python/
		// os grafos foram retirados do site acima
		/*
		add(new Edge(0, 1, 0));
		add(new Edge(0, 2, 0));
		add(new Edge(1, 2, 0));
		//add(new Edge(2, 0, 0));
		add(new Edge(2, 3, 0));
		add(new Edge(3, 4, 0));
		//add(new Edge(4, 1, 0));
		add(new Edge(4, 2, 0));
		*/
		
		// grafo 2
	/*	
		add(new Edge(1, 2, 0));
		add(new Edge(3, 4, 0));
		add(new Edge(4, 5, 0));
		add(new Edge(5, 3, 0));
	*/
		// grafo 3
		add(new Edge(0, 1, 0));
		add(new Edge(0, 2, 0));
		add(new Edge(1, 3, 0));
		add(new Edge(1, 4, 0));
		add(new Edge(5, 6, 0));
		add(new Edge(5, 7, 0));
		
		
		for(ArrayList<Edge> edges : list) {
			for(Edge edge : edges) {
				if(color[edge.s] == W)
					if(dfs(edge.s))
						return true;
			}
		}
		
		return false;
	}
	
	public static void runDfsColor() {
		add(new Edge(0, 1, 0));
		add(new Edge(0, 2, 0));
		add(new Edge(1, 3, 0));
		add(new Edge(1, 4, 0));
		add(new Edge(5, 6, 0));
		add(new Edge(5, 7, 0));
		
		for(ArrayList<Edge> edges : list) {
			for(Edge edge : edges) {
				if(color[edge.s] == W) {
					System.out.printf("%d:", edge.s);
					dfsColor(edge.s);
					System.out.println("");
				}
			}
		}
	}
	
	// http://www.personal.kent.edu/~rmuhamma/Algorithms/MyAlgorithms/GraphAlgor/depthSearch.htm
	public static void dfsColor(int source) {
		color[source] = G;
		moment[source] = time++;
		for(Edge edge : list.get(source)) {
			if(color[edge.d] == W) {
				System.out.printf(" %d", edge.d);
				dfsColor(edge.d);
			}
		}
		color[source] = B;
	}
	

	public static void main(String[] args) {
		new DetectCycleGraphIII(8);
		runDfsColor();
		System.out.println(execute());
	}

}
