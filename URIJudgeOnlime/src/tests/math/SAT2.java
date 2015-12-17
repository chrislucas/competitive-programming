package tests.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

	static Map<Node, ArrayList<Edge>> map;
	
	static class Edge<T> {
		Node<T> u, v;
		Edge(Node<T> u, Node<T> v) {
			this.u = v;
			this.v = v;
		}
	}
	
	static class Node<T> {
		T value;
		boolean status;
		Node (T value, boolean status) {
			this.value = value;
			this.status = status;
		}
	}
	
	public static <T> void addEdge(Node<T> u, Node<T> v) {
		if(map.containsKey(u)) {
			map.get(u).add(new Edge<T>(u, v));
		} else {
			ArrayList<Edge> array = new ArrayList<Edge>();
			array.add(new Edge<T>(u, v));
			map.put(u, array);
		}
	}
	
	public static void initAdjacencyList() {
		map = new HashMap<Node, ArrayList<Edge>>();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
