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
	public static void sort(Comparable [] set, int left, int right) {
		int i = left, j = right, mid = /*right */((right - left) / 2) + left;
		Comparable pivot = set[mid];
		/*do*/while(i <= j) {
			// varrer da esquerda para direita enquatno
			// os elementos a esquerda do 'pivot' forem menores
			// e descobrir o indice do elemento que nao atende a essa prerrogativa
			while(set[i].compareTo(pivot) < 0  && i < right)
				i++;
			// varrer da direita ate a esquerda enquanto
			// os elementos da direira do pivot forem maiores
			// e descobrir o indice o elemento que nao atende a essa prerrogativa
			while(set[j].compareTo(pivot) > 0 && j > left)
				j--;
			// indice i eh o indice do elemento a esquerda do pivot que eh maior que 'ele' (o pivot)
			// indice j eh o indice do elemento a direita do pivot que eh menor do que ele (o pivot)
			// assim trocar os elementos da esquera e direita de lugar
			if(i<=j) {
				//Comparable aux = set[i];set[i] = set[j]; set[j] = aux;
				swap(set, i, j);
				i++;
				j--;
			}
		} /*while(i <= j)*/;
		if(left < j)
			sort(set, left, j);
		if(i < right)
			sort(set, i, right);
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort2(Comparable [] set, int lo, int hi) {
		if(lo < hi) {
			int i = partition(set, lo, hi);
			sort2(set, lo, i-1);
			sort2(set, i+1, hi);
		}
		return;
	}
	
	//http://www.geeksforgeeks.org/iterative-quick-sort/
	@SuppressWarnings("rawtypes")
	public static void sort3(Comparable [] set, int lo, int hi) {
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int partition(Comparable [] set, int lo, int hi) {
		//int mid = ((hi-lo)/2)+lo;
		Comparable c = set[hi/*mid*/];
		int i = lo;
		for(int j=lo; j<=hi-1; j++) {
			Comparable p = set[j];
			if(p.compareTo(c)<=0) {
				swap(set, i, j);
				i++;
			}
		}
		swap(set, i, hi);
		return i;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int partition2(Comparable[]set, int lo, int hi) {
		int i=lo, j=hi;
		Comparable pivot = set[(hi - lo) / 2 + lo];	// middle
		while(i <= j) {
			while(set[i].compareTo(pivot) < 0 && i < hi)
				i++;
			while(set[j].compareTo(pivot) > 0 && j > lo)
				j--;
			if(i <= j) {
				swap(set, i, j);
				i++;
				j--;
			}	
		}
		return i;
	}
	
	public static void main(String[] args) {
		Character [] set = {'z', 'v', 'e', 'a', 'w', 'p', 's', 'S'
				,'i', 'f', 'g', 'b', 'm', 'o', 'l', 'a', 'r', 't', 'A', 'c'
				,'c', 'h', 'k', 'y', 'j', 'A', 'B', 'c', 'm', 'u', 'q', 'x'}; 
		/*
		sort(set, 0, set.length-1);
		for(Character c : set)
			System.out.printf("%c ", c);
	*/
		
		sort2(set, 0, set.length-1);
		for(Character c : set)
			System.out.printf("%c ", c);
		 
	}

}
