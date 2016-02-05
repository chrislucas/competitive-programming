package pattern_search;

import java.util.Arrays;


// http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
// 
	
public class NaiveSuffixArray {

	static class Suffix implements Comparable<Suffix> {
		int index;
		String str;
		public Suffix(int index, String str) {
			this.index = index;
			this.str = str;
		}
		@Override
		public int compareTo(Suffix that) {
			return this.str.compareTo(that.str);
		}
	}
	
	static Suffix [] suffix;
	static int [] suffixArray;
	
	// poderia ter retorno void, mas nao quero :(
	static int [] buildSuffixArray(String text, int sizeText) {
		suffix = new Suffix[sizeText];
		suffixArray = new int[sizeText];
		
		for(int i=0; i<sizeText; i++) {
			suffix[i] = new Suffix(i, text.substring(i, sizeText));
		}
		
		Arrays.sort(suffix);
		
		for(int i=0; i<sizeText; i++) {
			suffixArray[i] = suffix[i].index;
		}
		return suffixArray;
	}
	
	public static void printSuffixArray() {
		for(Suffix s : suffix) {
			System.out.printf("%d %s\n", s.index, s.str);
		}
	}
	
	public static Suffix findSuffix(int n) {
		for(Suffix s : suffix) {
			if(s.index == n)
				return s;
		}
		return null;
	}
	
	public static int[] searchPattern(String pattern, String text, int[] suffixArr, int sizeText) {
		int sp = pattern.length();
		int l = 0, r = sizeText;
		
		// bsearch
		while(l<=r) {
			int middle = (r-l)/2+r;
			String prefix = text.substring(0, suffixArr[middle]);
			int comp = pattern.compareTo(prefix);
			if(comp == 0) {
				break;
			}
			
			if(comp < 0)
				r = middle - 1;
			else
				l = middle + 1;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		String text = "banana";
		suffixArray = buildSuffixArray(text, text.length());
		printSuffixArray();
		searchPattern("ana", text, suffixArray, text.length());
	}

}
