package algorithm.sort;


/*
 * https://www.hackerrank.com/challenges/quicksort2
 * 
 * */

public class Quicksort {
	
	public static <T extends Comparable<T>> void sort(T [] set, int left, int right) {
		right--;
		int i = left, j = right, mid = (right - left) / 2 + left;
		T item = set[mid];
		do {
			while(set[i].compareTo(item) < 0  && i < right)
				i++;
			while(item.compareTo(set[j]) < 0 && j > left)
				j--;
			if(i<=j) {
				T aux = set[i];
				set[i] = set[j];
				set[j] = aux;
				i++;
				j--;
			}
		} while(i <= j);
		if(left < j)
			sort(set, left, j);
		if(i < right)
			sort(set, i, right);
	}
	
	public static int partition(Comparable [] set, int lo, int hi) {
		return 0;
	}
	
	public static void qSort(Comparable [] set, int lo, int hi) {
		if(hi<=lo)
			return;
		int i = partition(set, lo, hi);
		sort(set, lo, i-1);
		sort(set,i+1, hi);
	}
	

	public static void main(String[] args) {
		Character [] set = {'a', 'd', 'c'}; 
		sort(set, 0, set.length);
		for(Character c : set)
			System.out.println(c);
		qSort(set, 0, set.length-1);
	}

}
