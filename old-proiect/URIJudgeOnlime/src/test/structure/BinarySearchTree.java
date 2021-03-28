package test.structure;

/**
 * 
 * @author C.Lucas
 * */
public class BinarySearchTree {
	
	class Node<T extends Comparable<T>> {
		public T item;
		public Node<T> L, R;
		public Node() {}
		public Node(T item) {
			this.item = item;
		}		
	}
	
	@SuppressWarnings("rawtypes")
	public BinarySearchTree.Node root;
	public static BinarySearchTree bst; 
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void add(T value) {
		BinarySearchTree.Node<T> node = new BinarySearchTree().new Node<>(value);
		if(root == null) {
			root = node;
			return;
		}
		add(root, node);
	}
	
	private <T extends Comparable<T>> void add(Node<T> root, Node<T> node) {
		/**
		 * Se o valor da raiz eh maior que o valor do no a ser inserido
		 * inserir esse noh folha no noh raiz do lado esquerdo
		 * */ 
		if( root.item.compareTo(node.item) > 0) {
			// ultimo noh ?
			if(root.L ==  null) {
				root.L = node;
				return;
			}
			// descer recursivamente
			else {
				add(root.L, node);
			}
		}
		// no da direita
		else {
			if(root.R == null) {
				root.R = node;
				return;
			} else {
				add(root.R, node);
			}
		}
	}
	
	public <T extends Comparable<T>> void inOrder(Node<T> node) {
		if(node == null)
			return;
		inOrder(node.L);
		System.out.printf("%s ", node.item.toString());
		inOrder(node.R);
	}
	/**
	 * Essa travessia imprime primeiro os nós raiz
	 * depois as folhas esq. e dir. de cada raiz
	 * */
	public <T extends Comparable<T>> void preOrder(Node<T> node) {
		if(node == null) {
			return;
		}
		System.out.printf("%s ", node.item.toString());
		preOrder(node.L);
		preOrder(node.R);
	}
	/**
	 * Essa travessia imprime primeiro os nós folha esq. e dir.
	 * depois o no folha
	 * */
	public <T extends Comparable<T>> void postOrder(Node<T> node) {
		if(node == null) {
			return;
		}
		postOrder(node.L);
		postOrder(node.R);
		System.out.printf("%s ", node.item.toString());
	}
	/**
	 * O nó mais a direita da arvore contem o maior valor
	 * */
	public <T extends Comparable<T>> T max(Node<T> root) {
		if(root == null)
			return null;
		Node<T> current = root;
		while(current.R != null)
			current = current.R;
		return current.item;
	}
	
	public <T extends Comparable<T>> boolean exclude(T value) {
		return true;
	}
	
	public <T extends Comparable<T>> boolean contain(Node<T> root, T value) {
		if(root == null)
			return false;
		if(root.item.compareTo(value) == 0) {
			return true;
		} else {
			// se o valor da raiz eh menor que o valor de busca
			// percorrer a arvore pela direita
			if(root.item.compareTo(value) < 0) {
				return contain(root.R, value);
			} else {
				return contain(root.L, value);
			}
		}
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	/**
	 * O nó mais a esquerda da arvore contem o maior valor
	 * */
	public <T extends Comparable<T>> T min(Node<T> root) {
		if(root == null)
			return null;
		Node<T> current = root;
		while(current.L !=  null)
			current = current.L;
		return current.item;
	}
	
	public <T extends Comparable<T>> void add(/*BinarySearchTree bst,*/ T[] values) {
		for(T value : values)
			bst.add(value);
		return;
	}
	/**
	 * 
	 * http://javabypatel.blogspot.in/2015/09/construct-binary-tree-from-inorder-and-pre-order-traversals.html
	 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
	 * http://algorithms.tutorialhorizon.com/make-a-binary-tree-from-given-inorder-and-preorder-traveral/
	 * 
	 * @param
	 * T[] in, pre: array inorder and array preorder respectively
	 * int sIn: start Index array inorder
	 * int eIn: end index array inorder
	 * int sPre: start Index array preorder
	 * int ePre: end Index array preorder
	 * */
	public <T extends Comparable<T>> Node<T> add(T[] in, T[] pre, int sIn, int eIn, int sPre, int ePre) {
		if(sIn > eIn)
			return null;
		BinarySearchTree.Node<T> node = new BinarySearchTree().new Node<>(pre[sPre]);
		if(sIn == eIn)
			return node;
		int idx;
		for(idx=sIn;idx<eIn;idx++) {
			if(in[idx].equals(node.item))
				break;
		}
		/**
		 * InOrder array
		 * idx:
		 * O indice do elemento no array "inorder" que corresponde ao array "preorder"
		 * sPre+1:
		 * incrementar sPre para na proxima chamada recursiva, pegar o proximo elemento no array preorder
		 * 
		 * PreOrder array
		 * sPre+(idx-sIn): 
		 * "idx" divide o array ao meio, o que esta a esquerda de "idx" vai para sub arvore
		 * a esquerda e o restante a subarvore a direita. Entao sPre+idx diz qual o indice do ultimo
		 * elemento do array preorder
		 * */
		node.L = add(in, pre, sIn, idx-1, sPre+1, sPre+(idx-sIn));
		/**
		 * InOrder array
		 * idx+1: "onde a subarvore a direita comeca"
		 * Quando o elemento do array "preorder" eh encontrado em "inorder"
		 * o array e divido em 2, entao idx+1 diz onde comeca os elementos
		 * da subarvore a direita
		 * eIn:
		 * onde termina o array "inorder"
		 * 
		 * PreOrder array
		 * sPre+(idx-sIn)+1:
		 * Onde o preorder array inicia para montar a subarvore a direita da BST
		 * ePre:
		 * a sub arvore a direita termina no final do array preorder
		 * */
		node.R = add(in, pre, idx+1, eIn, sPre+(idx-sIn)+1, ePre);
		return node;	
	}
	/**
	 * Montar uma arvore a partir do percurso inorder e postorder
	 * 
	 * */
	public <T extends Comparable<T>> Node<T> build(T[] in, T[] pos, int sIn, int eIn, int sPos, int ePos) {
		BinarySearchTree.Node<T> node = new BinarySearchTree().new Node<>(pos[sPos]);
		return node;
	}
	
	public void testAddInOrderPreOrder() {
		Character [] pre = {'A','B','D','E','C','F'};
		Character [] ino = {'D','B','E','A','F','C'};
		Node<Character> node = add(ino, pre, 0, ino.length-1, 0, pre.length -1);
		postOrder(node);
		System.out.println("");
		preOrder(node);
		System.out.println("");
		inOrder(node);
		System.out.println("");
		//bst.add(in, pre, s, e);
	}
	
	@SuppressWarnings("unchecked")
	public void codeTest() {
		//T values[] = new Integer[] {40, 25, 127, 78, 10, 32};
		/**
		 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
		 * toda vez tenho q pesquisar isso.
		 * */
		// BinarySearchTree.Node<Integer> node = new BinarySearchTree().new Node<>();
		//BinarySearchTree bst = new BinarySearchTree();
		Character[][] values = new Character[][] {
			{'J','C','B','A','D','E','F','I','G','H','K','L'}
			,{'C','A','B','L','I','M','D','G','E','F','H','N'}
		};// {'a', 'e', 'd', 'c', 'b'};
		bst.add(values[1]);

		bst.inOrder(bst.root);
		System.out.println("");
		bst.preOrder(bst.root);
		System.out.println("");
		//bst.add(new Character('4'));
		//bst.add(new Character('9'));
		bst.postOrder(bst.root);
		System.out.println("");
		// verificar se max ou min nao retornam null
		System.out.printf("%s %s\n",
				bst.max(bst.root),
				bst.min(bst.root));
		System.out.println(bst.contain(bst.root, '9'));
	}
	
	public static void main(String[] args) {
		bst = new BinarySearchTree();
		//bst.codeTest();
		bst.testAddInOrderPreOrder();
		//pfx();
	}
	
	public static void pfx() {
		double total = 1000.0;
		double q = 0.0;
		int i=0;
		for(i=0; !almostEqual(q, total); i++) {
			q += (total - q) * 0.1;
			System.out.printf("%ds valor: %.30f\n", i, q);
		}
		System.out.println(1000.0 - 999.9999999999995);
		double f = 0.0000000000005 - 10e-12;
		System.out.printf("%.30f", f < 0 ? -f : f);
	}
	
	public static boolean almostEqual(double a, double b) {
		// 0.0000000000005
		double F = 0.0000000000005; //10e-12 * 5;
		if( ((a-b) < F && (a-b) > 0)|| -(a-b) < F ) {
			return true;
		}
		return false;
	}
}
