package estatistica.cap1;

import java.util.Arrays;

/**
 * Problema estudo dos documentos da universidade de Quixada
 * O problema da mediana e o algoritmo Selection
 * 
 * */
public class Mediana {

	
	public static long medianaNlogN(long [] set) {
		int s = set.length - 1	;
		Arrays.sort(set);
		return s%2==0 ? (set[s/2] + set[(s+2)/2])/2 : set[(s+1)/2];
	}
	
	public static <T> void  swap(T[] set, int idxA, int idxB) {
		T aux = set[idxA];
		set[idxA] = set[idxB];
		set[idxB] = aux;
	}
	
	public static long selection(Long [] set, int s, int e, long k) {
		int mid = (e-s)/2+e;
		long pivotVal = set[mid];
		swap(set, mid, e);
		int aux = s;
		for(int i=s; i<e; i++) {
			if(set[i] < pivotVal) {
				swap(set, aux, i);
				aux++;
			}
		}
		swap(set, aux, e);
		if(k == aux)
			return set[aux];
		else if(k < aux)
			return selection(set, s, aux-1, k);
		else
			return selection(set, aux, e, k);
	}
	
	/**
	 * Problemas relacionados
	 * http://br.spoj.pl/problems/SUPERMER/
	 * 
	 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
