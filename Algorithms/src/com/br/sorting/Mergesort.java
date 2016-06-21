package com.br.sorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * http://algs4.cs.princeton.edu/22mergesort/Merge.java.html
 * http://algs4.cs.princeton.edu/14analysis/Mergesort.java.html
 * http://algs4.cs.princeton.edu/lectures/22Mergesort.pdf
 * */

public class Mergesort {

	private static BufferedReader reader;

	public static <T> void copy(T [] arr, T [] aux) {
		for(int i=0; i<arr.length; i++) {
			aux[i] = arr[i];
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void merge(Comparable [] arr, Comparable [] aux
			,int lo, int md, int hi) {
		
		copy(arr, aux);
		
		// merge
		/*
		 * variavel left cuida dos elementos
		 * array [lo .. md]
		 * variavel right cuida dos elementos
		 * array[md+1 .. hi]
		 * */
		int left=lo, right=md+1;
		for(int k=lo; k<=hi; k++) {
			/*
			 * As duas primeiras condicoes so server para preencher o vetor
			 * A primeira i>mid serve para preencher o vetor com os elementos
			 * alem do meio do vetor original (em aux), pois ja nao tem
			 * elementos desordenados antes do meio (lado esquerdo)
			 * 
			 * A segunda comparacao serve para preencher os elementos do lado
			 * esquerdo do vetor (antes do meio), pois o lado direito (depois do neio)
			 * ja esta ordenado
			 * */
 			if(left>md)	// todos os elementos do lado esquerdo foram comparados
 			// preencha o vetor original com os valores restantes do lado direito do vetor copia
 				arr[k] = aux[right++];
			else if(right>hi) // todos os elementos do lado direito foram comparados
				// preencha o restando do vetor original com os elementos do lado esquerdo
				arr[k] = aux[left++];
 			/*
 			 * As duas ultimas condicoes comparam
 			 * se o i-esimo elemento do lado direito do vetor COPIA
 			 * e menor do que o i-esimo elemento do lado esquerdo
 			 * se SIM, preencha a k-esima posicao do vetor ORIGINAL
 			 * com o menor elemento (isso se quisermos ordenar o vetor
 			 * em ordem crescente)
 			 * */
			else if(lessThan(aux[right], aux[left]))
				arr[k] = aux[right++];
			else
				arr[k] = aux[left++]; 
		}
	}
	
	public static <T> void swap(T [] arr, int i, int j) {
		T aux 	= arr[i];
		arr[i] 	= arr[j];
		arr[j] 	= aux;
	}
	
	public static <T extends Comparable<T>> boolean lessThan(T a, T b) {
		return a.compareTo(b) < 0;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sorting(Comparable [] arr, Comparable [] aux, int lo, int hi) {
		if(hi <= lo)
			return;
		int md = (hi - lo) / 2 + lo;
		sorting(arr, aux, lo, md);
		sorting(arr, aux, md+1, hi);
		if(lessThan(arr[md], arr[md+1])) {
			//System.arraycopy(arr, lo, aux, lo, hi-lo+1);
			return;
		}
		merge(arr, aux, lo, md, hi);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void runTest() {
		try {
			reader = new BufferedReader(new FileReader("libs/d.txt"));
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
			sorting(arr, aux, 0, sz-1);
			System.out.println( isSorted(arr) ? "Ordenado" : "Desordenado");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		runTest();
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
	
	public static <T extends Comparable<T>> boolean isSorted(T [] array, int lo, int hi) {
		if(array.length < 2)
			return true;
		for(int i=lo+1; i<=hi; i++) {
			if(lessThan(array[i+1], array[i]))
				return false;
		}
		return true;
	}

}
