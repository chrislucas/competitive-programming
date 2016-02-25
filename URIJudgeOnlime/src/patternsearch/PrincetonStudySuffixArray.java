package patternsearch;

/**
 * http://algs4.cs.princeton.edu/63suffix/
 * http://algs4.cs.princeton.edu/63suffix/SuffixArray.java.html
 * */

public class PrincetonStudySuffixArray {
	
	
	public static class Suffix implements Comparable<Suffix> {
		int index;
		String str;
		public Suffix(int index, String str) {
			this.index = index;
			this.str = str;
		}
		@Override
		public int compareTo(Suffix that) {
			if(this == that) return 0;
			int size = Math.min(this.str.length(), that.str.length());
			for(int i=0; i<size; i++) {
				if(this.str.charAt(i) < that.str.charAt(i))
					return -1;
				else if(this.str.charAt(i) > that.str.charAt(i))
					return 1;
			}
			return 0;
		}
	}
	
	public static Suffix[] suffix;
	public static int[] LCP;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
