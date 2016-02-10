package pattern_search;



public class SuffixArray {
	
	// http://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/
	static class FastApproach {

	}
	
	static class Suffix implements Comparable<Suffix> {
		int index, rank [] = new int[2];
		public Suffix(int index, int rank[]) {
			this.index = index;
			this.rank  = rank;
		}
		@Override
		public int compareTo(Suffix that) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
