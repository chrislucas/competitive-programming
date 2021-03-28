package algorithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/maxsubarray
 * 
 * ALMOST DONE
 * NOW DONE BARALHO
 * 
 * */

public class MaxSubArray {

	
	public static long [] kadane1D(long [] array) {
		long [] ans = {array[0], 0, 0, array[0]/*array[0] > - 1 ? array[0] : 0*/};
		long parcial = ans[0];
		for(int i=1; i<array.length; i++) {
			parcial += array[i];
			if(parcial > ans[0]) {
				ans[0] = parcial;
				ans[2] = i;
			}
			
			if(parcial < 0) {
				parcial = 0;
				ans[1] = i+1;
			}
			// pequena moficicacao no algoritmo para resolver o problema
			// da soma maxima nao consecutivas
			
			if(array[i] > 0) {
				// para o caso de nem todos os elementos do array serem negativos
				// pois ans[3] eh responsavel pelo somatorio do array e pode ocorrer
				// desse somatorio comecar com numero negativo e nem todos os elementos
				
				// existem 2 casos : o array so possui elementos negativos, entao a soma
				// nao contigua eh o menor numero negativo desse array
				// o segundo caso eh um array com todos ou pelo menos 1 numero negativo
				// entao a soma maxima nao continua e a soma dos elementos positivos
				if(ans[3] < 0)
					ans[3] = 0;
				ans[3] += array[i];
			}
			
			// para os numeros negativos. BUscar o menor numero negativo (mais prox. do 0)
			// isso se a soma ate o momento for negativa
			if(ans[3] < 0) {
				// se o valor atual for maior que o anterior
				// guarde o menor valor
				if(array[i] > array[i-1]) {
					ans[3] = array[i];
				}
				// se o valor atual for maior que o menor valor ja registrado
				// guarde esse menor valor
				if(array[i] > ans[0]) {
					ans[0] = array[i];
				}	
			}
		}
		return ans;
	}
	
	public static void runTest() {
		long [][] array = {
			 {2,-1,2,3,4,-5}
			,{31,-41,59,26,-53,58,97,-93,-23,84}
			,{-1,-3,-4}
		};
		long [] ans = kadane1D(array[1]);
		System.out.printf("%d %d %d %d\n", ans[0], ans[1], ans[2], ans[3]);
	}
	
	public static void main(String[] args) {
		run();
	}
	
	public static void run() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			reader(buffer);
		} catch(IOException ioex) {}
	}
	
	public static void reader(BufferedReader buffer) throws IOException {
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		int n = Integer.parseInt(buffer.readLine());
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(buffer.readLine());
			long [] set = new long[x];
			StringTokenizer tk = new StringTokenizer(buffer.readLine(), " ");
			for(x = 0; tk.hasMoreTokens() ;x++)
				set[x] = Integer.parseInt(tk.nextToken());
			long [] ans = kadane1D(set);
			writer.printf("\n%d %d", ans[0], ans[3]);
		}
	}
}
