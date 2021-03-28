package br.com.studies;


/*
 * http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 * http://www.programminggeek.in/2013/11/dynamic-programming-floyd-warshall-algorithm-to-compute-all-pair-shortest-path.html
 * */
public class FloydWarshall {
	
	static int grid [][]
	,vertices
	,INFINITY = Integer.MAX_VALUE;

	public static void init(int vertex) {
		FloydWarshall.vertices = vertex;
		grid = new int[vertex][vertex];
		for(int i=0; i<vertex; i++)
			for(int j=0; j<vertex; j++)
				grid[i][j] = i==j ? 0 : INFINITY;
	}
	
	public static void add(int u, int v, int w) {
		grid[u][v] = w;
	}
	
	public static void floydWarshall() {
		int [][] distance = new int[vertices][vertices];
		
		for(int i=0; i<vertices; i++)
			for(int j=0; j<vertices; j++)
					distance[i][j] = grid[i][j];
		// primeiro loop garante que passaremos por todos os vertices do grafo
		// assim ao final desse loop teremos o menor caminho entre todos os vertces
		/*
		 * loop com indice 'j' serve para passar por todos os vertices
		 * o loop com indice 'i' tambem passa por todos os vertice
		 * e serve para montar um caminho entre j e k. o primeiro loop
		 * diz que i i-esimo vertice e um vertice intermediario
		 * 'j' variavel de 0 a quantidade de vertices passando pelo vertice
		 * 'i'  e tentando chegar a 'k', se houver um caminho
		 * */
		
		//for(int i=0; i<vertices; i++) {
			/**
			 * possivelmente um vertice intermidiario entre j e k
			 * ou eh um vertice final entre j e o proprio i
			 * ou nao eh alcanado por j
			 * */
			//for(int j=0; j<vertices; j++) {
				/**
				 * j funciona como vertice inicial
				 * */
				//for(int k=0; k<vertices; k++) {
					/*
					 * verificar se ha um caminho entre o vertice j e o i
					 * e entre o vertice i e o k
					 * (distance[j][i]!=INFINITY && distance[i][k]!=INFINITY )
					 * 
					 * distance[j][i] -> peso do caminho entre j e i
					 * distance[i][k] -> peso do caminho entre i e k
					 * 
					 * distance[j][i] + distance[i][k] -> partindo de j
					 * passando por i + partindo de i chengando em k, a soma
					 * desse caminho e menor do que o caminho entre j e k ?
					 * */
			/*
					int  vertexA = distance[j][i]
						,vertexB = distance[i][k]
						,vertexC = distance[j][k];
					if( (vertexA!=INFINITY && vertexB!=INFINITY) && vertexA + vertexB < vertexC) {
						distance[j][k] = vertexA + vertexB;
					}
				}
			}
		}
		*/
		for(int from=0; from<vertices; from++) {
			for(int to=0; to<vertices; to++) {
				for(int via=0; via<vertices; via++) {
					int  vertexA = distance[from][via]
						,vertexB = distance[via][to]
						,vertexC = distance[from][to];
					if( (vertexA!=INFINITY && vertexB!=INFINITY) && vertexA + vertexB < vertexC) {
						distance[from][to] = vertexA + vertexB;
					}
				}
			}
		}
		
		for(int i=0; i<vertices; i++){
			for(int j=0; j<vertices; j++)
				System.out.printf("%d ", distance[i][j] == INFINITY ? 0 : distance[i][j]);
			System.out.println("");
		}
	}
	
	public static void runTest() {
		init(4);
		add(0,1,5);
		add(0,3,10);
		add(1,2,3);
		add(2,3,1);
		floydWarshall();
	}
	
	public static void main(String[] args) {
		runTest();
	}


}
