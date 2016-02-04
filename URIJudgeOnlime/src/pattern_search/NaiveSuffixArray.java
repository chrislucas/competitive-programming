package pattern_search;

import java.util.Arrays;


// http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
	
public class NaiveSuffixArray {

	static class Suffix implements Comparable<Suffix> {
		int index;
		String suffix;
		public Suffix(int index, String suffix) {
			this.index = index;
			this.suffix = suffix;
		}
		@Override
		public int compareTo(Suffix that) {
			return this.suffix.compareTo(that.suffix);
		}
	}
	
	static int buildSuffixArray(String[] text, int sizeText) {
		Suffix [] suffix = new Suffix[sizeText];
		for(int i=0; i<sizeText; i++) {
			//suffix[i] = new Suffix(i, text[i]);
			suffix[i].index = i;
			suffix[i].suffix = text[i];
		}
		Arrays.sort(suffix);
		return 0;
	}
	
	public static void main(String[] args) {
		

	}

}
