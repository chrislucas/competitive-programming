package algorithm.sort;


/*
 * https://www.hackerrank.com/challenges/quicksort2
 * 
 * */

public class Quicksort {
	
	public static <T> void swap(T [] set, int a, int b) {
		T aux = set[a];
		set[a] = set[b];
		set[b] = aux;
		return;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort2(Comparable [] set, int left, int right) {
		right--;
		int i = left, j = right, mid = ((right - left) / 2) + left;
		Comparable item = set[mid];
		do {
			while(set[i].compareTo(item) < 0  && i < right)
				i++;
			while(item.compareTo(set[j]) < 0 && j > left)
				j--;
			if(i<j) {
				//Comparable aux = set[i];set[i] = set[j]; set[j] = aux;
				swap(set, i, j);
				i++;
				j--;
			}
		} while(i < j);
		if(left < j)
			sort2(set, left, j);
		if(i < right)
			sort2(set, i, right);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int partition(Comparable [] set, int lo, int hi) {
		Comparable c = set[hi/*(hi - lo) / 2 + lo*/];
		int i = lo-1;
		for(int j=lo; j<=hi-1; j++) {
			if(set[j].compareTo(c) <=0 ) {
				i++;
				swap(set, i, j);
			}
		}
		swap(set, i+1, hi);
		return i+1;
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort3(Comparable [] set, int lo, int hi) {
		if(hi<=lo)
			return;
		int i = partition(set, lo, hi);
		sort3(set, lo, i-1);
		sort3(set, i+1, hi);
	}
	
	public static void qSortIterative() {
		
	}
	

	public static void main(String[] args) {
		Character [] set = {'a', 'd', 'e', 'z', 'i', 'f', 'g', 'b', 'u', 'o', 'l', 'c',/* 'h', 'k'*/}; 
		
		sort2(set, 0, set.length-1);
		for(Character c : set)
			System.out.printf("%c ", c);
		/*
		sort3(set, 0, set.length-1);
		for(Character c : set)
			System.out.printf("%c ", c);
		 */
	}

}
