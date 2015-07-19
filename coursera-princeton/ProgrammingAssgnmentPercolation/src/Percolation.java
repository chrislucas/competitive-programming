
/**
 * @author C.Lucas <christoffer.luccas@gmail.com>
 * 
 * */

public class Percolation {
	private int order	//	order of matrix
	,TNode 				//	virtual node top
	,BNode;				//	virtual node bottom
	private WeightedQuickUnionUF wqu, wqu2;		// quick union objects
	private boolean sites[];					// arrays representing sites open or blocking
	
	/**
	 * constructor
	 * @param n order of matrix
	 * */
	
	public Percolation (int n) {
		this.order = n;
		// adicionando o +2 pois os indices comecao do 1
		// logo teremos indices de 1 a N inclusive
		wqu = new WeightedQuickUnionUF(order * order + 2);
		wqu2 = new WeightedQuickUnionUF(order * order + 2);
		TNode = order * order;
		BNode = order * order + 1;
		sites = new boolean[order * order + 2];		
	}
	// igual ao metodo union(p,q)
	public void open(int p, int q) {
		validate(p,q);
		if(!isOpen(p, q)) {
			int idx = idx2Dto1D(p, q);
			sites[ idx ] = true;
			connectSites(p, q);
		}
		
	}
	// igual ao metodo isConnected(p, q)
	public boolean isOpen(int p, int q) {
		validate(p,q);
		return sites[idx2Dto1D(p, q)];
	}
	
	public boolean isFull(int p, int q) {
		validate(p, q);
		int idx = idx2Dto1D(p, q);
		return wqu.connected(idx, TNode);
	}
	
	public boolean percolates() {
		return wqu.connected(TNode, BNode);
	}
	
	/**
	 * convert [i, j] to index in a array
	 * @param i
	 * @param j
	 * */
	private int idx2Dto1D(int i, int j) { return order*i + j; }
	
	/**
	 * private int[] idx1Dto2D(int idx, int o) { return new int[] {idx/o, idx-o*(idx/o)}; }
	 */

	private void validate(int p, int q) {
		if(p < 1 || p > order || q < 0 || q > order)
			throw new IndexOutOfBoundsException("row p or column q are out of bounds");
	}
	
	private void connectSites(int p, int q) {
		// inner
		if( p>1 && p<(order-1) && q>1 && q<(order-1) ) {
			// top
			if(isOpen(p-1, q)) {
				union(idx2Dto1D(p, q), idx2Dto1D(p-1, q));
			}
			// bottom
			if(isOpen(p+1, q)) {
				union(idx2Dto1D(p, q), idx2Dto1D(p+1, q));
			}
			// left
			if(isOpen(p, q+1)) {
				union(idx2Dto1D(p, q), idx2Dto1D(p, q+1));
			}
			// right
			if(isOpen(p, q-1)) {
				union(idx2Dto1D(p, q), idx2Dto1D(p, q-1));
			}
		}
		// border
		else {
			// top
			//if(p > 1 && q <)
		}
	}
	
	private void union(int p, int q) {
		wqu.union(p, q);
	}
	
	public static void main(String[] args) {
		Percolation perc = new Percolation(2);
		perc.open(1,2);
		perc.open(2,2);
		StdOut.println(perc.percolates());
		
		String url[] = {
			"http://coursera.cs.princeton.edu/algs4/testing/percolation/input10.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input20.txt"
		};
		BinaryIn bin = new BinaryIn(url[0]);
		//byte s = ! bin.isEmpty() ? bin.readByte() : 0;
		String s = ! bin.isEmpty() ? bin.readString() : "" ; 
		System.out.println(s);
	}
}
