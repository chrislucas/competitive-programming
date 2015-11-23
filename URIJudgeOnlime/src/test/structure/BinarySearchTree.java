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
	
	public <T extends Comparable<T>>void inOrder(Node<T> node) {
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
	
	/**
	 * Metodo que constroe arvore a partir de array.
	 * Como saber qual percurso foi realizado na arvore a partir
	 * da disposicao do array
	 * @param T[] nodes
	 * 
	 * @return 1, 2 ou 3 que representa o tipo de travessia
	 * que foi realizada na arvore, preordem em ordem ou pos ordem
	 * */
	public <T extends Comparable<T>> int constructTree(T[] nodes) {
		return 1;
	}

	public static void main(String[] args) {
		codeTest();
	}
	
	@SuppressWarnings("unchecked")
	public static void codeTest() {
		/**
		 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
		 * toda vez tenho q pesquisar isso.
		 * */
		// BinarySearchTree.Node<Integer> node = new BinarySearchTree().new Node<>();
		BinarySearchTree bst = new BinarySearchTree();
		Integer values[] = new Integer[] {40, 25, 127, 78, 10, 32};
		for(Integer value : values)
			bst.add(value);
		bst.inOrder(bst.root);
		System.out.println("");
		bst.preOrder(bst.root);
		System.out.println("");
		bst.add(45);
		bst.add(79);
		bst.postOrder(bst.root);
		System.out.println("");
		// verificar se max ou min nao retornam null
		System.out.printf("%s %s\n",
				bst.max(bst.root),
				bst.min(bst.root));
		System.out.println(bst.contain(bst.root, 127));
	}

}
