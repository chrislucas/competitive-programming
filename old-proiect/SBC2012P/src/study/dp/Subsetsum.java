package study.dp;

public class Subsetsum {

	public static <T extends Number> boolean solution(T [] array, int sum) {
		int e = array.length;		// numeros do connjunto 'array'
		int s = sum;				// soma que queremos verificar se pode ser alcancada atraves dos numeros do conjunto
		boolean dp [][] = new boolean[e+1][s+1];
		
		for(int i=0; i<e; i++) {
			// resultado onde o conjunto eh zero e a soma e zero
			dp[i][0] = true;
		}
		
		for(int i=1; i<s; i++) {
			// caso o tamanho do array for 0, para qualquer valor de 'sum' nao havera subconjunto solucao
			dp[0][i] = false;
		}
			
		// numero = indice dos numeros no conjunto 'array'
		for(int numero=1; numero<=e; numero++) {
			// soma = valor maximo da soma
			for(int soma=1; soma<=s; soma++) {
				dp[numero][soma] = dp[numero-1][soma];
				int valor  = (int)array[numero-1];
				if( ! dp[numero][soma] && soma >= valor){
					dp[numero][soma] = dp[numero][soma] || dp[numero-1][soma - valor];
				}
			}
		}
		
		return dp[e][s];
	}
	
	public static boolean solution2(int [] array, int sum) {
		return false;
	}
	
	public static void main(String[] args) {
		Integer m[][] = {
			{3, 2, 7, 1}
		};
		System.out.println(solution(m[0], 10));
	}

}
