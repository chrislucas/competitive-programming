package algorithm.sort;


/*
 * https://www.hackerrank.com/challenges/quicksort2
 * https://en.wikipedia.org/wiki/Quicksort#Algorithm
 * https://pt.wikipedia.org/wiki/Quicksort#Java
 * http://www.algolist.net/Algorithms/Sorting/Quicksort
 * */

public class Quicksort {
	
	public static <T> void swap(T [] set, int a, int b) {
		T aux = set[a];
		set[a] = set[b];
		set[b] = aux;
		return;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void sort(Comparable [] set, int left, int right) {
		int i = left, j = right, mid = /*right */((right - left) / 2) + left;
		Comparable pivot = set[mid];
		/*do*/while(i <= j) {
			// varrer da esquerda para direita enquatno
			// os elementos a esquerda do 'pivot' forem menores
			// e descobrir o indice do elemento que nao atende a essa prerrogativa
			while(set[i].compareTo(pivot) < 0  && i < right)
				i++;
			// varrer da direita ate a esquerda enquanto
			// os elementos da direira do pivot forem maiores
			// e descobrir o indice o elemento que nao atende a essa prerrogativa
			while(set[j].compareTo(pivot) > 0 && j > left)
				j--;
			// indice i eh o indice do elemento a esquerda do pivot que eh maior que 'ele' (o pivot)
			// indice j eh o indice do elemento a direita do pivot que eh menor do que ele (o pivot)
			// assim trocar os elementos da esquera e direita de lugar
			if(i<=j) {
				//Comparable aux = set[i];set[i] = set[j]; set[j] = aux;
				swap(set, i, j);
				i++;
				j--;
			}
		} /*while(i <= j)*/;
		if(left < j)
			sort(set, left, j);
		if(i < right)
			sort(set, i, right);
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort2(Comparable [] set, int lo, int hi) {
		if(lo < hi) {
			int i = partition2(set, lo, hi);
			sort2(set, lo, i /*i-1*/); // aparetemente para usar o metodo partition2 e partition4, o ultimo parametro deve ser i nao i-1
			sort2(set, i+1, hi);
		}
		return;
	}
	
	//http://www.geeksforgeeks.org/iterative-quick-sort/
	@SuppressWarnings("rawtypes")
	public static void sort3(Comparable [] set, int lo, int hi) {
		
	}
	
	/**
	 * Essa forma de particionar o array eh conhecida como 'Lomuto partition scheme'
	 * atribuida por Nico Lomuto e popularizada por Bentley nos seu livro programming pearls
	 * Esse esquema coloca esse algoritmo na ordem O n^2 quando o array ja esta ordenado
	 * ou todos os elementos sao iguais
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int partition(Comparable [] set, int lo, int hi) {
		Comparable pivot = set[hi];		// pegar o ultimo elemento como pivo
		int i = lo;
		for(int j=lo; j<=hi-1; j++) {
			Comparable p = set[j];			// para cada elemento a esquerda do pivo
			// verificar se tal elemento e menor que o pivot
			if(p.compareTo(pivot)<=0) {
				// se for menor que o pivo, set[i] esta no lugar de set[j] 
				swap(set, i, j);
				i++;
			}
		}
		// comportamento interessante. Essa troca ate onde meu conhecimento limitado
		// me leva a acreditar, nao faz trocas erradas, no caso de uma ordenacao em ordem
		// crescente, essa troca nao ocorre entre set[i] < set[hi]
		// as variaveis i e hi assumem duas situacoes, set[i] < set[hi] ou no caso de
		// hi for o indice do maior elemento no array (ou subarray, se ja ocorreu um particionamento),
		// no final do loop, i eh igual a hi, logo ocorre uma troca entre o mesmo elemento
		swap(set, i, hi);	
		return i;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int partition2(Comparable [] set, int lo, int hi) {
		int i=lo, j=hi;
		Comparable pivot = set[(hi - lo) / 2 + lo];	// middle
		while(i < j) {
			while(set[i].compareTo(pivot) < 0 && i < hi)
				i++;
			while(set[j].compareTo(pivot) > 0 && j > lo)
				j--;
			if(i < j) {
				swap(set, i, j);
				i++;
				j--;
			}	
		}
		return j;
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static int partition3(Comparable [] set, int lo, int hi) {
		return 0;
	}
	
	/*
	 * Esse metodo de particao segue o modelo de Hoare, nome do
	 * criador do algoritmo Quicksort Charles antony Richard Hoare : https://en.wikipedia.org/wiki/Tony_Hoare
	 * */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static int partition4(Comparable [] set, int lo, int hi) {
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
				
			if(i < j) {
				swap(set, i, j);
			}	
		}
		return j;
	}
	
	public static void main(String[] args) {
		sortArrayInt();
	}
	
	public static void sortArrayInt() {
		Integer [] set = {5,1,2,9,3,4,10,7,8,6};
		sort2(set, 0, set.length-1);
		printArray(set);
	}

	public static void sortArrayChar() {
		Character [] set = {'z', 'v', 'e', 'a', 'w', 'p', 's', 'S'
				,'i', 'f', 'g', 'b', 'm', 'o', 'l', 'a', 'r', 't', 'A', 'c'
				,'c', 'h', 'k', 'y', 'j', 'A', 'B', 'c', 'm', 'u', 'q', 'x'}; 
		sort2(set, 0, set.length-1);
		printArray(set);
	}
	
	public static <T> void printArray (T [] array) {
		for(T e : array) {
			System.out.printf("%s ", e.toString());
		}
	}

}
