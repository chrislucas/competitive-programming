package challenges;

public class StudyQS {
	
	// https://www.hackerrank.com/challenges/quicksort2
	
	public static <T> void swap(T [] set, int a, int b) {
		T aux = set[a];
		set[a] = set[b];
		set[b] = aux;
		return;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
