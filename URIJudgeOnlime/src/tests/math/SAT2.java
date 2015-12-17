package tests.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.util.locale.StringTokenIterator;

/**
 * http://danielamaral.wikidot.com/paa-2007-1-projeto-1-componentes-fortemente-conectados#toc15
 * http://maratonapuc.wikidot.com/apostilas:2sat
 * http://maratonapuc.wikidot.com/apostilas:2sat
 * http://pastebin.com/BfRpi1Tw
 * https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=887
 * */
// http://codeforces.com/blog/entry/16205
// https://kartikkukreja.wordpress.com/2013/05/16/solving-2-sat-in-linear-time/
// http://www.cse.psu.edu/~kasivisw/2sat.pdf
public class SAT2 {
	
	public static String[] literals;
	public static ArrayList<ArrayList<Integer>> adjacent;
	public static boolean [] visited;

	public static int vertices;
	// esse inteiro vai representar uma variavel da expressao booleana
	// exemplo ~a = 0, a = 1, ~b = 2 ... so on
	// esses valores estarao no mapa
	public static int nextChar = 0;
	
	/**
	 * Esse metodo adicione um literal da expressão boolean no mapa
	 * e o relaciona a um inteiro. Essa relacao sera usada em um grafo. 
	 * Onde uma aresta do grafo representa uma expressao de implicação a -> b
	 * 
	 * Para a solucao de um problema 2-SAT, eh necessario inserir a -> b e b -> a
	 * na verdade a expressao eh ~a -> b && ~b -> a, uma conjuncao de implicacoes
	 * 
	 * */
	public static int addLiteral(String literal) {
		int answer = 0;
		if(nextChar == 0) {
			answer = nextChar;
			literals[answer] = literal;
			nextChar++;
		}
			
		for(int i=0; i<nextChar; i++) {
			if(literals[i].equals(literal)) {
				answer = i;
				break;
			}
		}
		
		if(answer == 0) {
			answer = nextChar;
			literals[answer] = literal;
			nextChar++;
		}
		return answer;
	}
	
	
	public static void cleanAdjacent() {
		adjacent 	= create(); 
		visited 	= new boolean[vertices];
		literals 	= new String[2*vertices];
	}
	
	public static ArrayList<ArrayList<Integer>> create() {
		ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
		for(int i=0; i<vertices; i++)
			adjacent.add(new ArrayList<>());
		return adjacent;
	}
	
	public static void addEdge(int u, int v) {
		adjacent.get(u).add(v);
	}
	
	// se o literal comecar com !, ele representa uma negacao (~A)
	public static boolean valueLiteral(String literal) {
		return literal.charAt(0) == '!';
	}
	// invertendo uma lista de adjacencia
	public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> list) {
		ArrayList<ArrayList<Integer>> reverse = create();
		for(int i=0; i<vertices; i++) {
			ArrayList<Integer> array = list.get(i); 
			for(Integer vs : array) {
				reverse.get(vs).add(i);
			}
		}
		return reverse;
	}
	
	public static void runTest() {
		String la, lb, enter;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			while( (enter = buffer.readLine()) != null) {
				int cases = Integer.parseInt(enter);
				vertices = cases * 4;
				cleanAdjacent();
				for(int i=1; i<=cases; i++) {
					String[] sentece = buffer.readLine().split(" ");
					// adicionar 2x os literais, para gerar a formula ~a -> b && ~b -> a
					int u = addLiteral(sentece[0]);
					int v = addLiteral(sentece[1]);
					addEdge(u, v);
					if(sentece[0].charAt(0) == '!') {
						u = addLiteral(sentece[0].substring(1));
					} else {
						u = addLiteral("!".concat(sentece[0]));
					}
					
					if(sentece[1].charAt(0) == '!') {
						v = addLiteral(sentece[1].substring(1));
					} else {
						v = addLiteral("!".concat(sentece[1]));
					}
					addEdge(u, v);
				}
				
				Stack<Integer> stack = new Stack<>();
			}
		} catch(IOException ioex){}
	}
	
	/**
	 * Usar o algoritmo de tarjan
	 * */
	public static void dfs(int source) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
