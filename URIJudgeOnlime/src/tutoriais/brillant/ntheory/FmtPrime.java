package tutoriais.brillant.ntheory;

import java.math.BigInteger;
import java.util.Random;

/*
 * https://brilliant.org/wiki/prime-testing/
 * https://brilliant.org/wiki/fermats-little-theorem/
 * https://pt.wikipedia.org/wiki/Teste_de_primalidade_de_Fermat
 * parece um bom material
 * http://www.orm.mtm.ufsc.br/arquivos/downloads/congruencia
 * */

public class FmtPrime {
	
	/*
	 * Pequeno teorema de Ferma
	 * 
	 * Seja 'p' um numero primo e 'a' um inteiro qualquer
	 * que nao divide 'p' entao
	 * 
	 * (a^(p-1)) - 1 eh sempre divivel por 'p'
	 * ou a^(p - 1) congruente a 1 mod p
	 * ou a^p contruente a 'a' mod 'p'
	 * 
	 * Definicao de congruencia
	 * 
	 * Dados 3 numeros inteiro a,b e n, dizemos
	 * que 'a' eh congruente a 'b' modulo 'n'
	 * se n | (a-b) ou seja (a-b) eh multiplo de 'n'
	 * 
	 * */
	
	/*
	 * Pequeno teorema de fermat
	 * se 'p' eh um numero primo e 'a'
	 * um inteiro positivo onde a < p e
	 * 'a' nao eh divisivel por 'p' Entao
	 * 
	 * (a^(p-1))-1 eh sempre divivel por p
	 * ou
	 * a^(p^1) eh congruente a 1 modulo p
	 * ou ainda
	 * a^p eh congruente a 'a' modulo 'p'
	 * 
	 * A ideia do teste de fermat eh a verificar
	 * se o numero eh composto por contra posicao
	 * 
	 * escolha um 'a' aleatoria menor que 'p'
	 * para algum a^(p-1) nao congruente 1 mod p
	 * entao p eh composto
	 * */
	
	/*
	 * Porem existem casos onde
	 * 
	 * a^(p-1) eh congruente a 1 mod p e 'p' eh composto
	 * p eh chamado pseudoprimo de fermat para base a
	 * 
	 * Existem numeros que sao pseudoprimos de fermat para todas
	 * as bases chamados de 'Numeros de Charmichael'
	 * */
	
	public static boolean fermat(int p, int it) {
		if(p < 2)
			return false;
		Random random = new Random();
		int max = (p-1);
		for(int i=0; i<it; i++) {
			int a = random.nextInt(max) + 1;
			//System.out.printf("a: %d\n", a);
			// calcular a^(p-1) mod p
			//if(expmod2(num, max, p) != 1)
				//return false;
			// a^p congruente a 'a' mod p
			if(expmod4(a, p, p) != a)
				return false;
		}
		return true;
	}
	
	public static long expmod0(long a, long b, long m) {
		long ans = 1;
		for(long acc=0; acc<b; acc++) {
			//ans = (ans * a) % m;
			//ans *= a;
			ans = ((ans % m) * (a % m)) % m;
		}
		//return ans % m;
		return ans;
	}
	
	// https://www.topcoder.com/community/data-science/data-science-tutorials/primality-testing-non-deterministic-algorithms/
	public static long expmod2(long a, long b, long m) {
		long x=1, y=a;
		// by squaring
		while(b>0) {
			// impar
			if((b&1)==1){
				//x *= y;
				//x = (x * y) % m;
				x = ((x % m) * (y % m)) % m;
			}
			//y *= y;
			//y = (y*y)%m;
			/*
			 * A cada iteracao b = b / (2 ^ i) i -> i-esima iteracao
			 * y = (y^(2^î))
			 * */
			y = ((y % m) * (y % m)) % m; 
			b >>= 1;
		}
		// return x;
		return x%m;
	}
	
	public static long expmod3(long a, long b, long m) {
		long x = 1;
		//a=a%m;
		while(b > 0) {
			if((b&1)==1)
				x = (x*a)%m;
				//x = (x+a)%m;
			a = (a*a)%m; //(a*2)%m;
			b >>= 1;
		}
		return x%m;
	}
	
	// http://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
	public static long expmod4(long a, long b, long m) {
		long x = 1; a = a%m;
		while(b > 0) {
			if((b&1)==1)
				x = ((x%m)*(a%m))%m;
				//x = (x*a)%m;
			b >>= 1;
			//a = (a*a)%m;
			a = ((a%m)*(a%m))%m;
		}
		return x;
	}
	
	public static BigInteger expmod5(BigInteger a, BigInteger b, BigInteger m) {
		BigInteger x = BigInteger.ZERO;
		a = a.mod(m);
		while( b.compareTo(BigInteger.ZERO) == 1 ) {
			if(b.testBit(0)) {
				x = x.add(a).mod(m);
			}
			a = a.multiply(new BigInteger("2")).mod(m);
			b = b.shiftRight(1);
		}
		return x.mod(m);
	}
	
	public static String expModBigInteger (BigInteger ans, BigInteger base , BigInteger mod) {
		//(int a, int b, int m) {
		//BigInteger ans 	= new BigInteger(String.valueOf(a));
		//BigInteger base = new BigInteger(String.valueOf(b));
		//BigInteger mod 	= new BigInteger(String.valueOf(m));
		return ans.modPow(base, mod).toString();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf("%.30f", (1234.0 * 564.0) / Long.MAX_VALUE);
		System.out.printf("%s %s %s\n"
			,fermat(123, 1000)
			,fermat(15, 1000)
			,fermat(151, 15100)
		);
		
		System.out.println(expmod0(2, 10, 10));
		
		/*
		BigInteger  a = new BigInteger("9223372036854775807")
				,b = new BigInteger("9223372036854775807")
				,m = new BigInteger("100000000000"); 
		System.out.printf("%s %s\n",
			expModBigInteger(a, b, m)
			,expmod5(a, b, m)
		);
		*/
/*
		long a = 1500, b = 1490, m = 1549;
		System.out.printf("%d %d %d %d\n"
				,(a+b)%m
				,((a%m)+(b%m))%m
				,(a-b)%m
				// para isso ((a%m)-(b%m))%m ser igual (a-b)%m -> m > a & b ou < a & b e  a-b <= 10
				// maluqice
				,((a%m)-(b%m))%m
		);
*/		

		System.out.printf("%d %d %d %d\n"
				,expmod0(7, 10, 3)
				,expmod2(7, 10, 3)
				,expmod3(7, 10, 3)
				,expmod4(7, 10, 3));
				
		System.out.printf("%d %d %d %d\n"
				,expmod0(62, 15, 17)
				,expmod2(62, 15, 17)
				,expmod3(62, 15, 17)
				,expmod4(62, 15, 17));

		// (7 ^ 107)%9 = 4.
		System.out.printf("%d %d %d %d\n"
				,expmod0(7, 107, 9)
				,expmod2(7, 107, 9)
				,expmod3(7, 107, 9)
				,expmod4(7, 107, 9));
		
		System.out.printf("%d %d %d %d\n"
				,expmod0(2, 1007, 9)
				,expmod2(2, 1007, 9)
				,expmod3(2, 1007, 9)
				,expmod4(2, 1007, 9));
		
	}

}
