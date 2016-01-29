package tests.math;

public class Fibo {
	
	static int acc = 0;
	static int fibo(int n) {
		if(n == 0 || n  == 1)
			return 1;// n;
		acc++;
		int a = fibo(n-1);
		acc++;
		int b = fibo(n-2);
		return  a + b;
	}
	
	static int fiboMat(int n) {
		int m [] = {0, 1};
		int i;
		for(i=0; i<n; i++) {
			m[i%2] = m[0] + m[1];
		}
		return m[i%2 == 0 ? 1 : 0];
	}
	
	static int fiboMat2(int n) {
		int m [] = new int[n+2];
		m[0] = 0;
		m[1] = 1;
		for(int i=2; i<n+2; i++) {
			m[i] = m[i-1] + m[i-2];
		}
		return m[n+2-1];
	}
	
	// R(1) = R(2) = 0 R(n)=2+R(n-1)+R(n-2)
	// http://delab.csd.auth.gr/papers/SBI05m.pdf
	// http://www.inpe.br/pos_graduacao/cursos/cap/arquivos/prova_ingresso_2013_respostas.pdf
	// http://www.cs.columbia.edu/~cs4205/files/CM2.pdf
	public static int countRecCalls(int n) {
		int r[] = new int[n];
		r[0] = r[1] = 0;
		for(int i=2; i<n; i++) {
			r[i] = 2 + r[i-1] + r[i-2];
		}
		return r[n-1];
	}
	
	public static void main(String[] args) {
		//System.out.printf("%d %d %d %d", fibo(8), acc, fiboMat(8), fiboMat2(8));
		System.out.println(countRecCalls(8));
	}

}
