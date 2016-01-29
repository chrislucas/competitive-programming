package adhoc;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

// DONE
// Estudar quicksort
public class URI1495 {

	public static void swap(int [] a, int i, int j) {
		int c = a[i];
		a[i] = a[j];
		a[j] = c;
	}
	
	public static int partition(int [] array, int li, int ls) {
		int middle = (ls-li)/2+li;
		int l = li, r = ls;
		// escolhe um pivot
		int pivot = array[0]; // array[middle];
		// particiona
		while(l <= r) {
			while(array[l] < pivot) {
				l++;
			}
			while(array[r] > pivot) {
				r--;
			}
			if(l <= r) {
				swap(array, l, r);
				l++;
				r--;
			}
				
		}
		//swap(array, l-1, li);
		return l;
	}
	
	public static void qsort(int [] array, int li, int ls) {
		int idx = partition(array, li, ls);
		if(li < idx - 1) {
			qsort(array, li, idx);
		}
		if(idx < ls) {
			qsort(array, idx, ls);
		}
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);
		//int [] n = {3,2,1,-1,4,2,5,8,0,-22};
		//qsort(n, 0, n.length-1);
		
		try {
			String in;
			StringTokenizer token;
			while( (in = reader.readLine()) != null ) {
				token = new StringTokenizer(in, " ");
				int partidas 	= Integer.parseInt(token.nextToken());
				int compras 	= Integer.parseInt(token.nextToken());
				Integer [] tabela = new Integer[partidas];
				int ans = 0;
				for(int i=0; i<partidas; i++) {
					in = reader.readLine();
					token = new StringTokenizer(in, " ");
					int favor 	= Integer.parseInt(token.nextToken());
					int contra 	= Integer.parseInt(token.nextToken());
					if(favor > contra)
						ans += 3;
					tabela[i] = favor - contra;
				}
				//qsort(tabela, 0, partidas);
				Arrays.sort(tabela, Collections.reverseOrder());
				for(int i=0; i<partidas; i++) {
					if(tabela[i] > 0) {
						continue;
					} else {
						int diff = 1 - tabela[i] < 0 ? -(1 - tabela[i]) : 1-tabela[i];
						if(compras - diff >= 0) {
							ans += diff - tabela[i] > 0 ? 3 : 1;
							compras -= diff;
						} 
						// caso a o numeros de gols restante tenha diferenca de 1
						// para o saldo
						else if(compras - diff == -1) {
							compras -= 1;
							ans++;
						}
						else {
							if(tabela[i] == 0)
								ans++;
						}
					}
				}
				out.printf("%d\n", ans);
			}
		} catch(IOException ioex) {}

	}

}
