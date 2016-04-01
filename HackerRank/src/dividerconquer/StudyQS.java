package dividerconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StudyQS {
	
	static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	
	// https://www.hackerrank.com/challenges/quicksort2
	public static <T> void swap(T [] set, int a, int b) {
		T aux = set[a];
		set[a] = set[b];
		set[b] = aux;
		return;
	}
	
	// esquema de Hoare, autor do algoritmo quick sort
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int partition(Comparable [] set, int lo, int hi) {
		Comparable pivot = set[lo];
		int i = lo-1;
		int j = hi+1;
		while(i<j) {
			// verificar se os elementos a direita do pivo(pois pivot eh o set[lo])
			// sao menores que o pivot, se sim, aumente o indice 'i', ate que ache um
			// elemento maior, assim o indice i indicara o elemento que esta na posicao errada
			do {
				++i;
			} while(set[i].compareTo(pivot) < 0);
				
			// para o indice  'j', veriricar quais elementos sao maiores que o pivot
			// para colocalos a direita do pivot
			do {
				--j;
			} while(set[j].compareTo(pivot) > 0);
				
			if(i<j) {
				swap(set, i, j);
			}	
		}
		return j;
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable [] set, int lo, int hi) {
		if(lo < hi) {
			int i = partition(set, lo, hi);
			sort(set, lo, i); // aparetemente para usar o metodo partition2 e partition4, o ultimo parametro deve ser i nao i-1
			sort(set, i+1, hi);
			showArray(set, lo, hi);
		}
		return;
	}
	
	
	/*
	 * 
	 * Pesquisar por quicksort in-place
	 * http://stackoverflow.com/questions/29609909/inplace-quicksort-in-java
	 * http://www.mathcs.emory.edu/~cheung/Courses/171/Syllabus/7-Sort/quick-sort2.html
	 * */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void in_place(Comparable [] set, int lo, int hi) {
		if(set.length > 1) {
			Comparable pivot = set[lo];
			int lf = lo;
			int ri = hi;
			while(lf<=ri) {
				while(set[lf].compareTo(pivot) < 0)
					lf++;
				while(set[ri].compareTo(pivot) > 0)
					ri--;
				if(lf <= ri) {
					swap(set, lf, ri);
					lf++;
					ri--;
				}
			}
			if(lo < ri)
				in_place(set, lo, ri);
			if(lf < hi)
				in_place(set, lf, hi);
			showArray(set, lf, ri);
		}
		return;
	}
	
	public static <T> void showArray(T [] set, int lo, int hi) {
		while(lo<=hi)
			writer.printf("%s ", set[lo++].toString());
		writer.println("");
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(reader.readLine());
			Integer i = 0, set [] = new Integer[n];
			StringTokenizer numbers = new StringTokenizer(reader.readLine(), " ");
			while(numbers.hasMoreTokens()) {
				set[i++] = Integer.parseInt(numbers.nextToken());
			}
			//if(set.length == 1)
				//return;
			sort(set, 0, set.length-1);
		} catch(IOException ioex) {}
	}
}
