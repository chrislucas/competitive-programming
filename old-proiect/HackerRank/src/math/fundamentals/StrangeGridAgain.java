package math.fundamentals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.hackerrank.com/challenges/strange-grid
// DONE
public class StrangeGridAgain {

	static final int MAT [][] = {
		 {0,2,4,6,8}
		,{1,3,5,7,9}
	};
	
	static void s1(int m, int n) {
		if(m < 2) {
			System.out.printf("%d\n", MAT[m][n]);
		}
		else {
			if((m&1)==1) {
				m = (m-1)/2;
				n = MAT[1][n];
			}
			
			else {
				m /= 2;
				n = MAT[0][n];
			}
			System.out.printf("%d%d\n", m, n);
		}
	}
	/*
	 * 	20 22 24 26 28
		11 13 15 17 19
		10 12 14 16 18
		 1  3  5  7  9
		 0  2  4  6  8
		 Se comecarmos de baixo para cima a numerar
		 as linhas (de 1 a N) notaremos que as linhas
		 pares tem numeros impares e as impares so tem numeros
		 pares
	 * */
	static void s2(long line, long col) {
		// 2 casos
		// quando a linha eh impar
		if( (line&1)==1 ) {
			 // No caso 1 (impar)
			 // temos (N-1)/2 linhas impares e pares
			// line = ((line-1)/2) * 10;
		}
		// No caso 2 (par)
		else {
			 // temos metade das linhas com todos os numeros pares
			 // e outra metade impares
			 // Os elementos das colunas na linha par sao todos impares
			 // dessa for somamos + 1
			 // line = ((line-1)/2) * 10 + 1;
		}
		
		/*
		 * Podemos resolver da seguinte forma tambe
		 * */
		line = (line & 1) == 0 ? ((line-1)/2) * 10 + 1 : ((line-1)/2) * 10;
		/*
		 * line + (2*(col-1)) ?
		 * A coluna varia entre 0 e 9
		 * quando a linha eh par os valores da coluna
		 * so podem ser impares 1,3,5,7,9  (por causa da regra que 
		 * a matriz eh montada, veja exemplo a cima)
		 * 
		 * Se a linha for par
		 * 		Teremos o calculo da linha +1(para assegurar um
		 * 		resultado impar) + 2 * (c-1) onde (0 < c < 5)
		 * 		o -1 garamte que os possiveis valores de c
		 * 		nesse caso serao 1,3,5,7,9, isso so ocorre
		 * 		pois ao calcular o valor da linha, a linha
		 * 		recebe +1 logo essa soma sempre resultara num numero impar
		 * 
		 * */
		long ans = line + (2*(col-1));
		System.out.printf("%d\n", ans);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
			int m = Integer.parseInt(tk.nextToken());
			int n = Integer.parseInt(tk.nextToken());
			//s1(m-1, n-1);
			s2(m, n);
		} catch(Exception excp) {}
	}
}