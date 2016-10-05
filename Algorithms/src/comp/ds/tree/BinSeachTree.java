package comp.ds.tree;

public class BinSeachTree {

	class Node<T extends Comparable<T>>{
		public T data;
		public Node<T> left, right;
		public Node(T data) {
			this.data = data;
		}
		
		public T getData() {
			return this.data;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public BinSeachTree.Node rootBst;
	private static BinSeachTree bst;
	
	@SuppressWarnings("rawtypes")
	public BinSeachTree.Node getRoot() {
		return this.rootBst;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Comparable<T>> void insert(T value) {
		BinSeachTree.Node<T> no = new BinSeachTree().new Node<>(value);
		if(rootBst == null) {
			rootBst = no;
			return;
		}
		insert(rootBst, no);
	}
	
	public <T extends Comparable<T>> void insert(Node<T> root, Node<T> no) {
		// se o valor a ser inserido eh maior q a raiz, inserir do lado direito
		if(root.data.compareTo(no.data) > 0) {
			if(root.left == null) {
				root.left = no;
				return;
			}
			insert(root.left, no);
		}
		else {
			if(root.right == null) {
				root.right = no;
				return;
			}
			insert(root.right, no);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void run() {
		int [] values = {1,5,2,3,10,7};
		for(int value : values)
			bst.insert(value);
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bst = new BinSeachTree();
		bst.run();
	}

}
