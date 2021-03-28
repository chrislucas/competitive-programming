package regional.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * http://br.spoj.com/problems/BALDES/
 * */

public class SPOJ3241 {

	static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	
	public static void swap(int [] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static void solution(int [] array, int n) {
		boolean troca = true;
		// indice começa em 1 para facilitar o trampo, temremos arrays de [1 ... n]
		for(int i=1; i<n; i++) {
			if(array[i] != i) {
				for(int j=1; j<n; j++) {
					if(array[j] != j) {
						swap(array, j, array[j]);
						troca = ! troca;
					}
				}
				
				/*
				while(array[i] != i) {
					int aux = array[i];
					array[i] = array[aux];
					array[aux] = aux;
					troca = ! troca;
				}
				*/
			}
		}
		writer.printf("%s\n", troca ? "Carlos" : "Marcelo");
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			String in;
			while( ! (in = reader.readLine()).equals("0") ) {
				StringTokenizer token = new StringTokenizer(in, " ");
				int size 	= Integer.parseInt(token.nextToken()) + 1;
				int [] set 	= new int [size];
				for(int i=1; i<size; i++) {
					set[i] = Integer.parseInt(token.nextToken());
				}
				solution(set, size);
			}

		} catch(IOException ioex) {}
	}
}
