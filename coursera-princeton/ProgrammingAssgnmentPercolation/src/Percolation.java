
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
		if(n <= 0)
			throw new java.lang.IllegalArgumentException("N should be > 0");
		this.order = n;
		// adicionando o +2 pois os indices comecao do 1
		// logo teremos indices de 1 a N inclusive
		wqu = new WeightedQuickUnionUF(order * order + 2);
		wqu2 = new WeightedQuickUnionUF(order * order + 2);
		TNode = order * order;
		BNode = order * order + 1;
		sites = new boolean[order * order];	//[0 .. (order - 1(]		
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
		return wqu2.connected(idx, TNode);
	}
	
	public boolean percolates() {
		return wqu.connected(TNode, BNode);
	}
	
	/**
	 * convert [i, j] to index in a array
	 * @param i
	 * @param j
	 * */
	private int idx2Dto1D(int i, int j) {
		return order * (i - 1) + (j - 1);
	}
	
	/**
	 * private int[] idx1Dto2D(int idx, int o) { return new int[] {idx/o, idx-o*(idx/o)}; }
	 */

	private void validate(int p, int q) {
		if(p < 1 || p > order || q < 1 || q > order) {
			String msg = String.format("row p %d or column %d are out of bounds", p , q);
			throw new IndexOutOfBoundsException(msg);
		}
	}
	
	private void connectSites(int p, int q) {
		int site = idx2Dto1D(p, q);

        if (q > 1 && q < order ) {
        	if(isOpen(p, q-1))
        		union(site, idx2Dto1D(p, q-1));
        	if(isOpen(p, q+1))
        		union(site, idx2Dto1D(p, q+1));
        }

        if (p >= 1 && p <= order){
        	if(p == 1) {
        		union(site, TNode);
        	} else if(p == order) {
        		union(site, BNode);
        	}
            if (p > 1 && isOpen(p-1, q)) 
                union(site, idx2Dto1D(p-1, q));
            if (p < order && isOpen(p+1, q))
				union(site, idx2Dto1D(p+1, q));
        } 
	}
	
	private void union(int p, int q) {
		wqu.union(p, q);
		if(q != BNode)
			wqu2.union(p, q);
	}
	
	public static void main(String[] args) {
	}
	
	
	
	private static void testOpenSite() {
		//perc = new Percolation(10);
		//perc.open(-1, 5);
		//perc.open(0, 5);
		//perc.open(11, 5);
		//perc.open(5, -1);
		//perc.open(5, 0);
		//perc.open(5, 11);
	}
	
	private void test(String uri) {
		String url[] = {
			"http://coursera.cs.princeton.edu/algs4/testing/percolation/input10.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input20.txt"
		};
		//BinaryIn bin = new BinaryIn(url[0]);
		//byte s = ! bin.isEmpty() ? bin.readByte() : 0;
		//String s = ! bin.isEmpty() ? bin.readString() : "" ; 
		//System.out.println(s);
	}
}
