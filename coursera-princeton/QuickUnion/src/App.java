/**
 * Aplicacao do QuickUnion PC
 * Sistema percolado - fisica
 * Algoritmo Monte Carlo Simullation
 * */
public class App {

	public static int grid[][];
	public static int CLOSE = 0, OPEN = 1, EMPTY = 2;
	
	
	public static boolean isConnect(int p, int q, int grid) {
		return false;
	}
	
	public static int root(int p, int grid[][], int n) {
		while(p != grid[p/n][p%n]) {
			p = grid[p/n][p%n];
		}
		return p;
	}
	
	public static void init(int n) {
		grid = new int[n+2][n];
		for(int i=0; i<n*n; i++)
			grid[(i+10)/n][(i+10)%n] = i;
			//for(int j=0; j<n; j++)
				//grid[i][j] = i*n+j;
		return;
	}
	
	public static void main(String[] args) {
		init(10);

	}

}
