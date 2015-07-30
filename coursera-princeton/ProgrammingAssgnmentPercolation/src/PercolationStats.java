

public class PercolationStats {
	/**
	 * @param n integer representing the size of a matrix
	 * @param t integer representing 
	 * */
	private static final double T = 1.96;
	private double[] results;
	
	public PercolationStats(int n, int t) {
		if(n <= 0 || t <= 0)
			throw new IllegalArgumentException("Illegal Argument");
		results = setResults(n, t);
	}
	
	private double[] setResults(int n, int t) {
		results = new double[t];
		for(int i=0; i<t; i++){
			int counter = 0;
			Percolation perc = new Percolation(n);
			while(!perc.percolates()){
				int q;
				int p;
				do {
					p = StdRandom.uniform(1, n+1);
					q = StdRandom.uniform(1, n+1);
				} while(perc.isOpen(p, q));
				perc.open(p, q);
				counter++;
			}
			results[i] = ((double) counter) / (n*n); 
		}
		return this.results;
	}
	
	private double[] getResults() {
		return this.results;
	}
	
	private double confidenceInterval() {
		return T * stddev() / Math.sqrt(results.length);
	}
	
	public double mean() {
		return StdStats.mean(getResults());
	}
	
	public double stddev() {
		return StdStats.stddev(getResults());
	}
	
	public double confidenceLo() {
		return mean() - confidenceInterval();
	}
	public double confidenceHi() {
		return mean() + confidenceInterval();
	}
	
	public static void main(String[] args) {		
		int n = 0 , t = 0;
		/*
		if(args.length == 2) {
			n = Integer.parseInt(args[0]);
			t = Integer.parseInt(args[1]);
		}
		*/
		/**
		In in = new In();
		String line = in.readLine();
		String number[] = line.split(" ");
		*/
	}
	
	private static void teste(int n, int t) {
		
		PercolationStats pStats = new PercolationStats(n, t);
		double mean = pStats.mean();
		double stddev = pStats.stddev();
		double cLow = pStats.confidenceLo();
		double cHigh = pStats.confidenceHi();
		/*
		String fmt = String.format("mean %18s = %f\nstddev %18s = %f\n95% confidence interval = %f, %f",
				" ", mean, " ", stddev, cLow, cHigh);
				*/
		
		String fmt = String.format("mean %17s = %s\nstddev %15s = %s\n95 confidence interval = %s, %s", 
				" ",
				String.valueOf(mean).replace(',', '.'), " ",
				String.valueOf(stddev).replace(',', '.'),
				String.valueOf(cLow).replace(',', '.'),
				String.valueOf(cHigh).replace(',', '.'));
		String fmt2 = String.format("mean %17s = %.10f\nstddev %15s = %.10f\n95 confidence interval = %.10f, %.10f", 
				" ",mean, " ",stddev,cLow,cHigh);
		
		StdOut.println(fmt);
		StdOut.println(fmt2);
	}
}
