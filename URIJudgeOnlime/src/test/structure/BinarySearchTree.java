package test.structure;

public class BinarySearchTree {
	
	class Node<T extends Comparable<T>> {
		public T item;
		public Node L, R;
		public Node() {}
	}

	public static void main(String[] args) {
		/**
		 * https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
		 * toda vez tenho q pesquisar isso.
		 * */
		BinarySearchTree.Node<Integer> node = new BinarySearchTree().new Node<>();
	}

}
