package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://www.hackerrank.com/challenges/sum-vs-xor
 * http://www.geeksforgeeks.org/equal-sum-xor/
 * */
public class SumXor {

	/*
	 * 
	 * Observacoes interessantes:
	 * 
	 * 1) Quando n eh uma potencia de 2, o resultado eh n
	 * 2) Os resultados sao sempre potencia de 2
	 * 3) quan n eh uma potencia de 2 - 1 (7, 31, 63) o
	 * resultado eh igual a 1. Somente a propriedade de identidade
	 * n Xor 0 == n+0 para esses numeros
	 * 
	 * */
	public static int sumXorSimple(int n, boolean debug) {
		int count = 0;
		for(int x=0; x<=n; x++) {
			if(debug)
				System.out.printf("%d %d %d\n", x, n, (x^n));
			if(x+n == (x^n)){
				//System.out.printf("%d %d %d\n", x,n,(x^n));
				count++;
			}
		}
		//System.out.printf("%d %d\n", n, count);
		return count;
	}
	
	public static long sumXorFast(long n) {
		if(ipot3(n)) {
			return n;
		}
			
		else if(ipot3(n+1)) {
			return 1;
		}
			
		else {
			// a + b = a ^ b + a & b
			// o que implica que a & b = 0
			// para um valor a qualquer, quais sao os valores
			// que b deve assumir para zerar todos os bits de a
			int count = 0;
			while(n > 0) {
				if( (n & 1) == 0)
					count++;
				n /= 2;
			}
			
			return 1 << count;
		}
	}
	
	public static void runTest() {
		for (int i=0; i <=10000; i++) {
			System.out.printf("%d %d\n", i, sumXorSimple(i, false));
		}
	}
	
	public static double _log(double b, double g) {
		return Math.log10(b) / Math.log10(g);
	}
	
	// http://www.exploringbinary.com/ten-ways-to-check-if-an-integer-is-a-power-of-two-in-c/
	// http://www.purplemath.com/modules/logs2.htm
	public static boolean isPowOfTwoLog(int n) {
		return 1 << (int)(_log(n,2)) == n;
	}
	
	public static boolean ipot2(long n) {
		return n+(n-1) == (n^(n-1));
	}
	
	// algo interessante ocorre na arquitetura que implementa
	// complemento a 2. -2 ^ 31 = 10000000000000000000000000000000. 
	// pode ser considerado uma potencia de 2 se nao observarmos
	// que esse numero eh negativo, Se quisermos considerar somente
	// numeros positivos, temos a funcao abaixo
	public static boolean ipot3(long n) {
		return n > 0 && (n&(n-1)) == 0;
	}
	
	public static void runTest2() {
		System.out.println(ipot2(15));
		/*
		long n = Integer.MAX_VALUE;
		n += 1;
		for(;n<Long.MAX_VALUE;n *= 2) {
			System.out.printf("%d %s %s\n", n, ipot2(n), ipot3(n));
		}
		*/
		/*
		for(int i=0; i<=31; i++) {
			System.out.printf("%d %s %s\n", 1 << i, ipot2(1 << i), ipot3(1 << i));
		}
		*/
	}
	
	public static void runTest3() {
		//System.out.println(Long.MAX_VALUE ^ 12056546546544L);
		//System.out.println(_log(Long.MAX_VALUE, 2));
		System.out.println(ipot3(4611686018427387904L));
		System.out.println(sumXorSimple(1<<21, false));
		System.out.println(sumXorFast(1<<21));
	}
	
	public static void runToggleXOR(int x, int y, int q) {
		/*
		 * observando algumas propriedades
		 * comutativa 		(A xor B) xor B = (B xor B) xor A
		 * assossiativa 	(A xor B) xor B
		 * auto inversao 	(B xor B) xor A
		 * identidade		 0 Xor B = B
		 * */
		for(int i=0, n=x; i<q; i++) {
			n ^= (x^y);
			System.out.println(n);
		}
		System.out.printf("%d %d", x, y);
	}
	
	
	public static void main(String[] args) {
		//runTest();
		//System.out.println( 1 << (int)_log(100,2) );
		//System.out.println(_log(50,2));
		//runTest2();
		//runTest3();
		//runToggleXOR(10, 17, 156);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			long n = Long.parseLong(reader.readLine());
			System.out.println(sumXorFast(n));
		} catch(IOException ioex) {}
	}
}
