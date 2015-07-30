

/**
 * @author C.Lucas <christoffer.luccas@gmail.com>
 * 
 * */

public class Percolation {
	private int order	//	order of matrix
	,tNode 				//	virtual node top
	,bNode;				//	virtual node bottom
	private WeightedQuickUnionUF wqu, wqu2;		// quick union objects
	private boolean[] sites;					// arrays representing sites open or blocking
	
	/**
	 * constructor
	 * @param n order of matrix
	 * */
	
	public Percolation(int n) {
		if(n <= 0)
			throw new java.lang.IllegalArgumentException("N should be > 0");
		this.order = n;
		// adicionando o +2 pois os indices comecao do 1
		// logo teremos indices de 1 a N inclusive
		wqu = new WeightedQuickUnionUF(order * order + 2);
		wqu2 = new WeightedQuickUnionUF(order * order + 2);
		tNode = order * order;
		bNode = order * order + 1;
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
		return wqu2.connected(idx, tNode);
	}
	
	public boolean percolates() {
		return wqu.connected(tNode, bNode);
	}
	
	/**
	 * convert [i, j] to index in a array
	 * @param i
	 * @param j
	 * */
	private int idx2Dto1D(int i, int j) {
		return order*(i-1)+(j-1);
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

		// look left and right
		if (q >= 1 && q <= order && order > 1) {
			if(q == 1) {
	        	if(isOpen(p, q+1))
	        		union(site, idx2Dto1D(p, q+1));	
			} else if (q == order){
				if(isOpen(p, q-1))
	        		union(site, idx2Dto1D(p, q-1));
			} else {
				if(isOpen(p, q-1))
	        		union(site, idx2Dto1D(p, q-1));
	        	if(isOpen(p, q+1))
	        		union(site, idx2Dto1D(p, q+1));	
			}
        }

		// look top and bottom
        if (p >= 1 && p <= order){
        	if(p == 1) {
        		union(site, tNode);
        	} else if(p == order) {
        		union(site, bNode);
        	}
            if (p > 1 && isOpen(p-1, q) && order > 1) 
                union(site, idx2Dto1D(p-1, q));
            if (p < order && isOpen(p+1, q) && order > 1)
				union(site, idx2Dto1D(p+1, q));
        }
	}
	
	private void union(int p, int q) {
		wqu.union(p, q);
		if(q != bNode)
			wqu2.union(p, q);
	}
	
	public static void main(String[] args) {
		test();
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
	
	public static void test() {
		String URLS[] = {
			"http://coursera.cs.princeton.edu/algs4/testing/percolation/input6.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input7.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input10.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input20.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/jerry47.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/wayne98.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input1.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input1-no.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input2.txt"
			,"http://coursera.cs.princeton.edu/algs4/testing/percolation/input2-no.txt"
		};
		//BinaryIn bin = new BinaryIn(url[0]);
		//byte s = ! bin.isEmpty() ? bin.readByte() : 0;
		//String s = ! bin.isEmpty() ? bin.readString() : "" ; 
		//System.out.println(s);
		//for(String url : URLS){}
		int DELAY = 5;
        
		In in = new In(URLS[9]);       // input file
        int N = in.readInt();         // N-by-N percolation system
        // turn on animation mode
        StdDraw.show(0);
        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        PercolationVisualizer.draw(perc, N);
        StdDraw.show(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            PercolationVisualizer.draw(perc, N);
            StdDraw.show(DELAY);
        }
	}
}
