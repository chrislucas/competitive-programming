package paradigmas.dp;



public class NumbersDP {
	/**
	 * de quantas formas podemos escrever o numero N
	 * usando o conjunto de numeros {1,2,3}
	 * exemplo
	 * 1 = 1
	 * 2 = {(1+1), (2)}
	 * 3 = {(1+1+1), (1+2), (2+1), 3}
	 * 
	 */
	public static int pdCountWayWriteNumber(int n) {
		int []  set= new int[n+1];
		set[0] = 0; set[1] = 1; set[2] = 2; set[3] = 4; 
		for(int i=4; i<=n; i++) {
			set[i] = set[i-3] + set[i-2] + set[i-1];
		}
		return set[n];
	}
	
	/**
	 * http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	 * Given a value N , if we wanna make change for N cents, and we have a 
	 * a set of coints such as S = {S1, S2, S3, SM}
	 * 
	 * How many ways can we make the change ? The order of coins does not matter
	 * 
	 * @param int [] Set : numeros que devem ser combinados e somados formando 'value'
	 * @param int sizeSet, tamanho do conjunto [0, sizeSet-1], com a recursao iremos adicionando
	 * um a um os numeros do Set original
	 * @param int value. O valor que se quer alcancar combinando os numeros em Set
	 * */
	
	public static int changeCoin(int [] Set, int sizeSet, int value) {
		// se o valor desejado for 0, a somente uma combinacao
		// formada pelo oonjunto vazio {}
		if(value == 0)
			return 1;
		// caso onde nao a solucao
		if(value < 0)
			return 0;
		
		if(sizeSet < 1 && value > 0)
			return 0;
		int x = changeCoin(Set, sizeSet - 1, value) ;
		int y = changeCoin(Set, sizeSet, value-Set[sizeSet -1]);
		return x + y;
	}
	
	public static int changeCoinBottomUp(int [] Set, int sizeSet, int value) {
		// a matriz vai auxilia na construcao da solucao
		// utilizando a tecnica de DP bottom up
		// essa matriz tem value+1 linhas, pois a linha [0][] representa
		// a solucao para value = 0;
		int [][] table = new int[value+1][sizeSet];
		// para value = 0 a resposa eh 1, um conjunto vazio
		for(int i=0; i<sizeSet; i++) {
			table[0][i] = 1;
		}
		// montando a solucao, utlizando bottom up
		for(int i=1; i<value+1; i++) {
			for(int j=0; j<sizeSet; j++) {
				// incluir  Set[j]
				int x = i-Set[j] >= 0 ? table[i-Set[j]][j] : 0;
				// excluirSet[j]
				int y = j > 0 ? table[i][j-1] : 0;
				table[i][j] = x + y;
			}
		}
		return table[value][sizeSet-1];
	}
	
	public static int bottomUpSpaceN(int [] Set, int sizeSet, int value) {
		return 0;
	}
	
	public static void testCCV1() {
		int [] Set = {1,2,3};
		int sizeSet = Set.length;
		//System.out.println(changeCoin(Set, sizeSet, 4));
		//System.out.println(changeCoin(Set, sizeSet, 5));
		System.out.println(changeCoinBottomUp(Set, sizeSet, 4));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCCV1();
	}
}