package grafos;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//DONE
public class URI1764 {
	// com BufferedInputStream eh mais rapido
	static final BufferedInputStream is = new BufferedInputStream(System.in);
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out, true);
	static ArrayList<Edge> edges, mst;
	static int V, E;
	
	static class Edge implements Comparable<Edge> {
		int s, d, w;
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
		public Edge(int s, int d, int w) {
			this.s = s;
			this.d = d;
			this.w = w;
		}
	}
	
	static class UF {
		static int[] subset, weight;
		static void init(int edges) {
			subset = new int[edges+5];
			weight = new int[edges+5];
			for(int i=0; i<edges+5; i++) {
				subset[i] = i;
				weight[i] = 1;
			}
		}
		
		static int root(int i) {
			while( i != subset[i])
				i = subset[i];
			return i;
		}
		
		static void union(int p, int q) {
			int i = root(p);
			int j = root(q);
			if(i == j)	// mesma raiz
				return;
			if(weight[i]>=weight[j]) {
				subset[j] = i;			// a arvore com menos nos passa ter como raiz a arvore com mais nos
				weight[i] += weight[j];	// adicionar os nos de q em p
			} else {
				subset[i] = j;
				weight[j] += weight[i];
			}
		}
	}

	static void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public static int kruskal() {
		int e = 0,	// indice para montar a arvore geradora minima
			i = 0,	// indice para pegar uma aresta da lista
			c = 0;
		while(e < V - 1) {
			Edge edge = edges.get(i++);
			int p = UF.root(edge.s);
			int q = UF.root(edge.d);
			// se as arestas nao incidem do mesmo vertice nao ha ciclos
			if(p != q) {
				mst.add(edge);
				UF.union(p, q);
				e++;
				c+= edge.w;
			}
		}
		return c;
	}
	
	public static void main(String[] args) throws IOException {
		String in;		
		while( !(in = buffer.readLine()).equals("0 0")) {
			StringTokenizer token = new StringTokenizer(in, " ");
			int v = Integer.parseInt(token.nextToken());
			int e = Integer.parseInt(token.nextToken());
			
			edges = new ArrayList<Edge>();
			mst = new ArrayList<Edge>();
			V = v;
			E = e;
			UF.init(e);
			for(int i=0; i<e; i++) {
				in = buffer.readLine();
				token = new StringTokenizer(in, " ");
				int s = Integer.parseInt(token.nextToken());
				int d = Integer.parseInt(token.nextToken());
				int w = Integer.parseInt(token.nextToken());
				Edge edge = new Edge(s, d, w);
				addEdge(edge);
			}
			Collections.sort(edges);
			out.println(kruskal());
		}
	}
}
