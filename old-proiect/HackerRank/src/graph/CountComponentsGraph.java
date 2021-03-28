package graph;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * 
 * Usar a estrutura do Union Find para contar componentes Conexos de um grafo
 * */

public class CountComponentsGraph {

	public static int data[], tall[], components;
	
	public static int find(int n, int data[]) {
		while(data[n] != n)
			n = data[n];
		return n;
	}
	// o mesmo que o quick union
	public static boolean isConnected(int p, int q, int data[]) {
		return find(p, data) == find(q, data);
	}
	// agora alem de achar a raiz de p para mudar pela raiz de q 
	public static void union(int p, int q, int data[], int tall[]) {
		int i = find(p, data);
		int j = find(q, data);
		if(i == j)
			return;
		// verificamos quantos nos a arvore com a raiz p e q tem
		if(tall[i] >= tall[j]) { 	//  para arvores de tamanho igual nao faz diferenca a ligacao
			data[j] = i;			// a arvore com o menor tamanho passa ter a raiz da arovre maior
			tall[i] += tall[j]; 	// o tamanho da arovre maior aumenta com a soma da arvore menor
		} else {		
			data[i] = j;
			tall[j] += tall[i]; 	// idem acima
		}
		components--;				// numero de componentes desconexos diminui
		return;
	}
	
	public static void init(int n) {
		data = new int [n];
		tall = new int [n];
		components = n;			// numero de componentes desconexos eh igual ao numero de vertices
		for(int i=0; i<n; i++) {
			data[i] = i;
			tall[i] = 1;
		}
	}
	
	public static void main(String[] args) {
		InputStream in;
		BufferedReader buffer;
		PrintWriter out;

	}

}
