package com.br.sorting;

public class ThreeWayMergeSort {

	// http://codereview.stackexchange.com/questions/73970/3-way-merge-sort-in-java
	public static int MS_THRESHOLD = 8;
	
	public static <T> void copy(T [] arr, T [] aux) {
		for(int i=0; i<arr.length; i++) {
			aux[i] = arr[i];
		}
	}
	
	// https://pt.wikipedia.org/wiki/Insertion_sort
	@SuppressWarnings({ "rawtypes" })
	public static void insertionSort(Comparable [] array, int sz) {
		for(int i=1; i<sz; i++) {
			int left = i-1;
			Comparable cp = array[i];
			// se o i-esimo elemento for menor que o
			// elemento a sua esquerda
			while(left>=0 && lessThan(cp, array[left])) {
				// coloque os elementos que estavam a esquerda do i-esimo
				// elemento ao lado direito do mesmo
				array[left+1] = array[left--];
			}
			if(left != i-1) {
				array[left+1] = cp;
			}
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean lessThan(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	@SuppressWarnings("rawtypes")
	public static void merge(Comparable [] arr, Comparable [] aux
			, int lo, int md, int hi) {
		copy(arr, aux);
		
	}
	
	public static void sort(Comparable [] arr, Comparable [] aux, int lo, int hi) {
	
	}
	
	public static void runTestIS() {
		Integer [][] ints = {
			{5,4,3,2,1}
			,{1,5,3,4,2}
		};
		insertionSort(ints[0], 5);
	}
	
	public static void main(String[] args) {
		runTestIS();
	}

}
