package com.br.practice.track.datastruct.uf;

/*
 * https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/tutorial/
 * 
 * Ler
 * http://algs4.cs.princeton.edu/15uf/
 * http://algs4.cs.princeton.edu/15uf/UF.java.html
 * */

public class DisjointSet {

	static class QuickFind {
		/*
		 * Uma forma de conectar elementos de mesma classe
		 * e verificar se numa estrutura um Elemento A esta conectado
		 * diretamente ou indiretamente a um Elemento de B eh usar
		 * a estrutura de conjuntos disjuntos (Disjoint Set)
		 * 
		 * Essa estrutura possui 3 metodos importantes
		 * union (A, B) = dizer que o Pai de A sera o mesmo que o de B
		 * find(A, set) = verificar se A esta no conjunto, se estiver que
		 * eh o no Pai de A
		 * isconnected(A,B) = verificar se A esta associado a B
		 * isconnected usa a funcao
		 * 
		 * No tutorial do hackerearth a funcao find(A,B) funciona como
		 * descrevi a funcao isconnected, vou seguir o tutorial
		 * 
		 * */
		
		// conjunto de elementos
		// o indice 'i' do vetor representa o i-esimo elemento
		// o valor em set[i] diz quem eh o pai de i
		public int set [];
		public int size;
		// a operacao find nessa abordagem eh rapida
		public QuickFind(int size) {
			this.size = size+1;
			this.set = new int[this.size];
			for(int i=0; i<this.size; i++)
				this.set[i] = i;
		}
		// conectar set[p] a set[q] - quick union
		public void union(int p, int q) {
			int rootP = set[p];	// pai do indice p
			int rootQ = set[q];	// idem q
			for(int i=0; i<size; i++) {
				// todos que sao filhos de do Pai de p
				if(set[i] == rootP)
					// serao filhos do pai de q
					set[i] = rootQ;
			}
		}
		
		public void print() {
			for(int m : set)
				System.out.printf("%d ", m);
			System.out.println();
		}
		// isconnected ? quick ahm
		public boolean find(int p, int q) {
			return set[p] == set[q];
		}
	}
	// a operacao union nessa abordagem eh rapida
	static class QuickUnion{
		public int set [];
		public int size;
		public QuickUnion(int size) {
			this.size = size+1;
			set = new int[this.size];
			for(int i=0; i<this.size; i++)
				this.set[i] = i;
		}
		
		public void union(int p, int q) {
			int rootP = root(p);
			int rootQ = root(q);
			set[rootP] = rootQ;
		}
		/*
		 * O metodo root pode se tornar custoso
		 * conforme a operacao union e feita muitas vezes;
		 * Isso pq ao uniar A e B, o elemento que tem como
		 * raiz 'B' passa a carregar muitos elementos abaixo
		 * de si, entao para buscar a raiz de um elemento
		 * que esta abaixo de B o processo fuca cada vez mais
		 * demorado (O(n))
		 * */
		public int root(int p) {
			while(set[p] != p)
				p = set[p];
			return p;
		}
		
		public boolean find(int p, int q) {
			return root(p) == root(q);
		}
		
		public void print() {
			for(int m : set)
				System.out.printf("%d ", m);
			System.out.println();
		}
	}
	
	/*
	 * Para melhorar a performance da operacao root()
	 * em Quick Union, vamos rastrear a quantidade de elementos
	 * em cada subset
	 * */
	static class WQU {
		public int [] set, tall;
		public int size;
		public WQU(int size) {
			this.size = size+1;
			set = new int[this.size];
			tall = new int[this.size];
			for(int i=0; i<this.size; i++) {
				set[i] = i;
				tall[i] = 1;
			}
		}
		
		public void wUnion(int p, int q) {
			int rootP = root(p);
			int rootQ = root(q);
			if(rootP == rootQ) 	// se estao conectados, isso afeta a soma dos peosos
				return;
			int tp = tall[rootP]; 	// quantidade de elementos conectados a raiz de P
			int tq = tall[rootQ];	// idem Q
			// Se a raiz de P tiver menos elementos ligados a si do que a raiz de Q
			if(tp < tq) {
				// P passa ter como raiz a raiz de Q - conecta P a Q
				set[rootP] = rootQ;
				// A raiz de Q recebe a quantidade de elementos ligados a raiz e P
				tall[rootQ] += tall[rootP];		
			}
			else {
				// a raiz de Q passa a ter como valor a raiz de P - conecta Q a P
				set[rootQ] = rootP;
				// a quantidade de elementos abaixo da raiz de Q sao somados a raiz de P
				tall[rootP] += tall[rootQ];	
			}
		}
		
		public boolean find(int p, int q) {
			return root(p) == root(q);
		}
		
		public int root(int p) {
			while(set[p] != p)
				p = set[p];
			return p;
		}
		
		public void print() {
			System.out.println("Set");
			for(int m : set)
				System.out.printf("%d ", m);
			System.out.println("Weight");
			for(int m : tall)
				System.out.printf("%d ", m);
		}
	}
	
	static class Pathcompression {
		public int [] set, tall;
		public int size;
		public Pathcompression(int size) {
			this.size = size+1;
			set = new int[this.size];
			tall = new int[this.size];
			for(int i=0; i<this.size; i++) {
				set[i] = i;
				tall[i] = 1;
			}
		}
		// a funcao root modificada
		public int root(int i) {
			// com esse algoritmo (loop abaixo) eu ligo o i-esimo elemento que NAO
			// esta ligado diretamente ao elemento raiz do subconjutno
			while(i != set[i]) {
				// A busca e simples, Quem eh a raiz da raiz do i-esimo elemento ?
				set[i] = set[set[i]];
				i = set[i];
			}
			// ao termino do loop eu conecto diretamente os elementos
			// que estavam ligados interea
			return i;
		}
		
		public boolean find(int p, int q) {
			return root(p) == root(q);
		}
		
		public void union(int p, int q) {
			int rootP = root(p);
			int rootQ = root(q);
			if(rootP == rootQ)
				return;
			int qp = tall[rootP];
			int qq = tall[rootQ];
			if(qp < qq) {
				set[rootP] = set[rootQ];
				tall[rootQ] += tall[rootP];
			}
			else {
				set[rootQ] = set[rootP];
				tall[rootP] += tall[rootQ];
			}
		}
		
		public void print() {
			System.out.println("Set");
			for(int m : set)
				System.out.printf("%d ", m);
			System.out.println("Weight");
			for(int m : tall)
				System.out.printf("%d ", m);
		}
	}
	
	public static void runQF() {
		DisjointSet.QuickFind qf = new DisjointSet.QuickFind(15);
		qf.union(9, 8);
		qf.union(4, 3);
		qf.print();
	}
	
	public static void runQU() {
		DisjointSet.QuickUnion qu = new DisjointSet.QuickUnion(15);
		qu.union(1, 2);
		qu.union(3, 4);
		qu.union(4, 5);
		qu.union(1, 3);
		qu.print();
	}
	
	public static void runWQU() {
		DisjointSet.WQU wqu = new DisjointSet.WQU(15);
		wqu.wUnion(0, 1);
		wqu.wUnion(1, 2);
		wqu.wUnion(3, 2);
		wqu.wUnion(2, 3);
		wqu.print();
	}
	
	public static void runPC() {
		Pathcompression pc = new Pathcompression(15);
		/*
		pc.union(0, 1);
		pc.union(1, 2);
		pc.union(3, 2);
		pc.union(4, 5);
		pc.union(4, 10);
		pc.union(10, 11);
		*/
		// insert fal ke para testar o path compression
		pc.set = new int [] {0,0,1,2,4,5,6,7,8,9,10,11,12,13,14,15};
		pc.tall = new int [] {4,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1};
		pc.union(3, 10);
		pc.print();
	}
	
	
	
	public static void main(String[] args) {
		//runQF();
		//runWQU();
		runQU();
		//runPC();
	}

}
