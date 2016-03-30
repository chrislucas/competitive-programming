package test;

import java.util.*;

/**
 * Created by christoffer on 22/03/16.
 */
public class Korasaju {

    static List<ArrayList<Edge>> graph;
    // uma outra forma de montar uma lista de adjacencia
    static Hashtable<Integer, List<Edge>> table;
    static Set<Set<Edge>> components;

    static class Edge implements Comparable<Edge> {
        int s, d, w;
        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
        @Override
        public int compareTo(Edge that) {
            return this.w - that.w;
        }
    }

    static void init(int vertices) {
        graph  = buildGraph(vertices);
        //for(int i=0; i<vertices; i++) {
            // visited[i] = false;  // no java nao precisa inicializar
        //}
        components = new LinkedHashSet<>();
        return;
    }

    static List<ArrayList<Edge>> buildGraph(int vertices) {
        List<ArrayList<Edge>> graph  = new ArrayList<>();
        for(int i=0; i<vertices; i++)
            graph.add(new ArrayList<Edge>());
        return graph;
    }

    static void add(int u, int v, int w) {
        graph.get(u).add(new Edge(u, v, w));
        return;
    }

   public  static Edge get(int u, int v) {
        return graph.get(u).get(v);
    }


    public static List<ArrayList<Edge>> transpose(int vertices, List<ArrayList<Edge>> graph) {
        List<ArrayList<Edge>> inverse = buildGraph(vertices);
        for(ArrayList<Edge> edges : graph) {
            for (Edge edge : edges) {
                inverse.get(edge.d).add(new Edge(edge.d, edge.s, 0));
            }
        }
        return inverse;
    }

    public static Stack<Integer> fill(int vertice, boolean[] visited, Stack<Integer> stack) {
        visited[vertice] = true;
        for(Edge edge : graph.get(vertice)) {
            if( ! visited[edge.d] ) {
                fill(edge.d, visited, stack);
            }
        }
        stack.push(vertice);
        return stack;
    }

    /*
    * O algoritmo de kosaraju-sharir eh baseado na busca em profundidade (DFS)
    * duas DFS sao aplicadas, uma com o grafo original e outra num grafo cujas
    * arestas foram invertidas
    *
    * Se a partir de qualquer vertice, todos os N-1 vertices sao alcancaveis
    * a DFS gera uma arvore de com todos os vertices, caso contrario, DFS gera uma 'floresta'
    *
    * So DFS of grapf with only one SCC (Strong connected component) always produces a tree
    *
    * */

    public static void dfs(int vertice, List<ArrayList<Edge>> g, boolean [] visited) {
        visited[vertice] = true;
        for(Edge edge : g.get(vertice)) {
            if( ! visited[edge.d] ) {
                System.out.printf(" %d", edge.d);
                dfs(edge.d, g, visited);
            }
        }
    }

    public static void korosaju(int vertices) {
        add(0, 2, 0);
        add(0, 3, 0);
        add(1, 0, 0);
        add(2, 1, 0);
        add(3, 4, 0);

        boolean [] visited = new boolean[vertices];

        Stack<Integer> stack = fill(0, visited, new Stack<Integer>());
        List<ArrayList<Edge>> g = transpose(vertices, graph);

        for(int i=0; i<vertices; i++)
            visited[i] = false;

        while( ! stack.empty() ) {
            int u = stack.pop();
            if(!visited[u]) {
                System.out.printf("%d:", u);
                dfs(u, g, visited);
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        init(5);
        korosaju(5);
    }
}
