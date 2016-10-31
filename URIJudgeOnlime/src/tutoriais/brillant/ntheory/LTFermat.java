package tutoriais.brillant.ntheory;

/*
 * http://artofproblemsolving.com/wiki/index.php?title=Fermat%27s_Little_Theorem
 * https://pt.wikipedia.org/wiki/Teste_de_primalidade_de_Fermat
 * http://www.4devs.com.br/area_coroa_circular
 * https://www.youtube.com/watch?v=aXAMQ8ASEhI
 * */

public class LTFermat {
	
	
	/*
	 * 
	 * mdc(a,b) -> maximo divisor comum entre a e b
	 * se 'm' eh primo, entao para qualquer 'a'
	 * mdc(m,a) = 1
	 * 
	 * a^(m-1) congruente a 1 mod 'm' 
	 * O problema no teormea acima eh que
	 * ha 'm' composto que satisfaz tal condicao
	 * Assim se 'm' eh nao primo e 'a' um inteiro
	 * tal que mdc(a, m) = 1 e ainda
	 * a^(m-1) congruente a 1 mod 'm'
	 * diz-se que m eh um pseudoprimo de fermat
	 * 
	 * */

	public static long gdc(long m, long n) {
		while(m%n!=0) {
			long mod = m%n;
			m = n;
			n = mod;
		}
		return n;
	}
	
	public static long expmod(long a, long b, long m) {
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
	
	public static long expmod2(long a, long b, long m)  {
		long x=1; a=a%m;
		for(;b>0; b>>=1) {
			if((b&1)==1)
				x = ((x%m)*(a%m))%m;
			a = ((a%m)*(a%m))%m;
		}
		return x;
	}
	
	public static void runGdc() {
		/*
		System.out.println(gdc(54, 4));
		System.out.println(gdc(26, 4));
		int p [] = {117, 111, 151};
		int idx = 1;
		int c = 0;
		for(int x=2; x<p[idx]; x++) {
			int ans = gdc(x,p[idx]);
			if(ans!=1)
				System.out.printf("gdc(%d,%d)=%d\n", x, p[idx], ans);
			else
				c++;
		}
		System.out.printf("coprimos(%d)", c);
		*/
		/*
		 * [151,171,167]
		 * */
		int expo = 167;
		for(int base=1; base<expo; base++) {
			/*
			 * se a^p mod p == a provavelmente
			 * p eh primo, para qualquer a < p
			 * ou se
			 * a^(p-1) mod p == 1 a afirmação
			 * tambem eh valida
			 * */
			//long m = expmod(base, expo, expo);
			long m = expmod(base, expo-1, expo);
			long g = gdc(m, base);
			System.out.printf("%d %d\n", m, g);
		}	
	}
	
	/*
	 * (a^(p-1))*(p-1)! congruente (p-1)! mod p
	 * */
	public static void runTest2() {
		// para um primo p temos que  mdc(p, (p-1)!) = 1
		// visto que na sequencia (p-1)! -> [ (p-1) * (p-2) * ... * 1] 
		// quando p eh primo nao ha nenhum divisor de p
		long p = 7, acc, fat=1;
		for(acc=p-1;acc>0;acc--)
			fat*=acc;
		//System.out.println(gdc(p, fat));
		
		/*
		 * 
		 * (a^(p-1))*(p-1)! congruente (p-1)! mod p
		 * a congruencia a cima so eh verdade porque
		 * mdc(p, (p-1)!) = 1
		 * 
		 * Por isso
		 * (a^(p-1))*(p-1)! congruente (p-1)! mod p
		 * eh igual
		 * (a^(p-1)) congruente 1 mod p
		 * */
		System.out.printf("%d %d\n"
			,(expmod2(10, p-1, p) * fat) % p
			,fat % p
		);
	}
		
	// http://comnuan.com/cmnn02/cmnn02008/
	public static void runTest() {
		//System.out.println(expmod2(24,2015,1000));
		//System.out.println(expmod2(124,2015,1000));
		//System.out.println(expmod2(124,2015,1437));
		//System.out.println(expmod2(2015,124,1437));
		System.out.println(expmod2(512,2015,1000));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//runGdc();
		//runTest();
		runTest2();
	}

}
