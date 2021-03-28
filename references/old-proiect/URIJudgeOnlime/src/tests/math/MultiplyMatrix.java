package tests.math;

public class MultiplyMatrix {

	
	public static int [][] naiveMultiply(int [][] A, int [][] B) throws Exception {
		int colA, linA, colB, linB;
		colA = A[0].length;
		linA = A.length;
		colB = B[0].length;
		linB = B.length;
		if(colA != linB)
			throw new Exception("Matrizes nao podem ser multiplicadas");
		int [][] C = new int[linA][colB];
		for(int i=0; i<linA; i++)			// passar por todas as linhas de A
			// passar por colunas de B, para que a linha i de A multipliqye todas as j colubas de B
			for(int j=0; j<colB; j++)
				// passar por todas as linhas de B, cuja a quantidade eh a mesma de linhas de A
				// A i-esima linha de A multiplica todas as J-linhas de B e fazendo um somatorio
				// Cada somatorio se encaixa da Matriz C(i,j)
				for(int k=0; k<linB; k++)	
					C[i][j] += A[i][k] * B[k][j]; 
		return C;
	}
	
	public static void runTest() {
		int [][] A = {
			{0,1,2}
			,{2,1,0}
			,{1,0,1}
		},
		B = {
			{1}
			,{1}
			,{0}
		};
		int [][] C;
		try{
			C = naiveMultiply(A,B);
		} catch(Exception e) {}
		return;
	}
	
	public static void main(String[] args) {
		runTest();
	}

}
