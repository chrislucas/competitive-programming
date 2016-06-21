package com.br.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MergeSortCountInversion {

	static long INVERSIONS = 0;
	static BufferedReader reader;
	
	public static <T> void copy(T [] arr, T [] aux) {
		for(int i=0; i<arr.length; i++) {
			aux[i] = arr[i];
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void merge(Comparable [] arr, Comparable [] aux
			,int lo, int md, int hi) {
		copy(arr, aux);
		int lf=lo, ri=md+1;	
		for(int k=lo; k<=hi; k++) {
			if(lf>md)
				arr[k] = aux[ri++];
			else if(ri>hi)
				arr[k] = aux[lf++];
			else if(lessThan(aux[lf], aux[ri]))
				arr[k] = aux[lf++];
			else {
				arr[k] = aux[ri++];
				INVERSIONS+= (md - lf + 1);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable [] arr, Comparable [] aux
			, int lo, int hi) {
		if(hi<=lo)
			return;
		int md = (hi-lo)/2+lo;
		sort(arr, aux, lo, md);
		sort(arr, aux, md+1, hi);
		if(lessThan(arr[md], arr[md+1])) {
			//System.arraycopy(arr, lo, aux, lo, hi-lo+1);
			return;
		}
		merge(arr, aux, lo, md, hi);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean lessThan(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	
	@SuppressWarnings("rawtypes")
	public static void test() {
		Integer [][] tests = {
			{4,80,70,23, 9, 60, 68, 27, 66, 78, 12, 40, 52, 53, 44, 8, 49, 28, 18, 46, 21, 39, 51, 7, 87, 99, 69, 62, 84, 6, 79, 67, 14, 98, 83, 0, 96, 5, 82, 10, 26, 48, 3, 2, 15, 92, 11, 55, 63, 97, 43, 45, 81, 42, 95, 20, 25, 74, 24, 72, 91, 35, 86, 19, 75, 58, 71, 47, 76, 59, 64, 93, 17, 50, 56, 94, 90, 89, 32, 37, 34, 65, 1, 73, 41, 36, 57, 77, 30, 22, 13, 29, 38, 16, 88, 61, 31, 85, 33, 54 }	
			,{5,6,7,8,9,1,2,3,4}
			,{1,3,5,2,4,6}
			,{1,5,3,2,4}
			,{5,4,3,2,1}
			,{37, 7, 2, 14, 35, 47, 10, 24, 44, 17, 34, 11, 16, 48, 1, 39, 6, 33, 43, 26, 40, 4, 28, 5, 38, 41, 42, 12, 13, 21, 29, 18, 3, 19, 0, 32, 46, 27, 31, 25, 15, 36, 20, 8, 9, 49, 22, 23, 30, 45 }
			,{9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0 }
			,{1,6,3,2,4,5}
		};
		int idx = 0;
		int sz 	= tests[idx].length;
		Comparable [] aux = new Integer[sz];
		long s = System.currentTimeMillis();
		sort(tests[idx], aux, 0, sz-1);
		long time = (System.currentTimeMillis() - s) / 1000;
		System.out.printf("%d\n%s %d", time, isSorted(tests[idx]), INVERSIONS);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void runTest() {
		try {
			reader = new BufferedReader(new FileReader("libs/IntegerArray.txt"));
			String in = "";
			ArrayList<Integer> integers = new ArrayList<>();
			while( (in = reader.readLine()) != null) {
				StringTokenizer tk = new StringTokenizer(in, " ");
				while(tk.hasMoreTokens()) {
					integers.add(Integer.parseInt(tk.nextToken()));
				}
			}
			int sz = integers.size();
			Comparable [] arr = new Integer[sz];
			for(int i=0; i<sz; i++)
				arr[i] = integers.get(i);
			Comparable [] aux = new Integer[sz];
			long s = System.currentTimeMillis();
			sort(arr, aux, 0, sz-1);
			long time = (System.currentTimeMillis() - s) / 1000;
			System.out.printf("%d\n%s %d", time, isSorted(arr) ? "Ordenado" : "Desordenado", INVERSIONS);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//runTest();
		test();
	}

	
	public static <T extends Comparable<T>> boolean isSorted(T [] array) {
		if(array.length < 2)
			return true;
		for(int i=0; i<array.length-1; i++) {
			if(lessThan(array[i+1], array[i]))
				return false;
		}
		return true;
	}
}
