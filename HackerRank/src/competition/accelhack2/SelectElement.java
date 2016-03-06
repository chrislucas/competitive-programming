package competition.accelhack2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
 * 
 * */

public class SelectElement {
	
	// https://en.wikipedia.org/wiki/Quickselect
	// QuickSelect tem os seguintes metodos auxiliares
	// int kthSmallest(Integer [] set, int k)
	// int partition(T [] set, int l, int r)
	// void swap(T[] set, int a, int b)
	public static int kthSmallest(Integer [] set, int l, int r, int k) {
		if(k > 0 && k <= r-l+1) {
			int idx = partition(set, l, r);
			if(idx-1 == k-1)
				return set[idx];
			// se a posicao do elemento pivo for maior
			// do que a procurada, recuar a busca no vetor
			// da direita mais para esquerda, diminuindo o valor
			// do indice 'r'
			if(idx-1>k-1)
				return kthSmallest(set, l, idx-1, k);
			
			return kthSmallest(set, idx+1, r, k);
		}
		return 0;
	}
	
	// funcao partition do algoritmo Quick Sort
	public static <T extends Comparable<T>> int partition(T [] set, int l, int r) {
		T aux = set[r];
		int i = l, j;
		for(j=l; j<=r-i; j++) {
			//
			if(set[j].compareTo(aux) <= 0) {
				swap(set, j, i);
				i++;
			}
		}
		swap(set, j, i);
		return i;
	}
	
	public static <T> void swap(T[] set, int a, int b) {
		T aux = set[a];
		set[a] = set[b];
		set[b] = aux;
	}
	
	
	static class MinHeap {
		
	}
	
	static class MaxHeap {
		
	}
	

	
	public static void solution(int [] list, int k) {
		SortedSet<Integer> set = new TreeSet<Integer>();
		for(Integer u : list)
			set.add(u);
		Integer[] array = (Integer[]) set.toArray(new Integer[set.size()]);;
		int  start = 0
		    ,s = array.length;
		while(start < s-1) {
			boolean add = false;
			for(int i=start; i<s-1; i++) {
				int d = array[start] - array[i+1] < 0 ? -(array[start] - array[i+1]) : array[start] - array[i+1];
				if(set.contains(d))
					continue;
				set.add(d);
				add = true;
				break;
			}
			if(!add)
				start++;
			array = (Integer[]) set.toArray(new Integer[set.size()]);;
			s = array.length;
		}
		array =  (Integer[]) set.toArray(new Integer[set.size()]);
		int l = 0, r = array.length-1;
		System.out.println(kthSmallest(array, l, r, k));
		//Arrays.sort(array, Collections.reverseOrder());
		//System.out.println(array[k-1]);
		return;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BufferedReader  buffer = new BufferedReader(new InputStreamReader(System.in));
		solution(new int [] {2, 6, 10}, 2);
	}

}
