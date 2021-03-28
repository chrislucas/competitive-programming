package tests.math.nbtheory;

public class CountTecniques {

	// quantos zeros tem o numero N!
	public static long zerosFactorial(long n) {
		long acc=0;
		for(long u=5; u<=n; u+=5) {
			if(u%5==0) {
				long c = u;
				while((int)(c % 5) == 0) {
					c /= 5;
					acc++;
				}
			}
		}
		return acc;
	}
	// principio da inclusao - exclusao
	// A uniao B = |A| + |B| - |A interseccao B|
	/**
	 * Determinar quabtos numeros entre 1 e 100
	 * bao sao divisiveis por 4 nem por 9
	 * A : 1 <= 100 eh divisivel por 4
	 * B : 1 <= 100 eh divisivel por 9
	 * A intersccao B : 1 <= 100 eh divivisel por 4 e 9, 1 <= 100 divisivel por 36
	 * |A| : 100 / 4 = 25
	 * |B| : 100 / 9 = 11
	 * A uniao B = 25 + 11 - (100/36) = 34
	 * 100 - 34 = 66 nao sao divisiveis nem por 4 nem por 9
	 * */
	
	// combinatoria
	/**
	 * C(n,p) = n! / ((n-p)! * p!) 
	 * 
	 * n * (n-1)! / (n-k)(n-(k+1))!
	 * 
	 * */
	static long nCr1(long n, long p) {
		long /*diff = n-p+1,*/ ans = 1;
		for(long i=p+1; i<=n; i++) {
			ans = ans * i / (i - p);
		}
		return ans;
	}
	
	static long nCr2(long n, long p) {
		if(n == p)
			return 1;
		return nCr2(n-1, p) * n / (n-p);
	}
	
	static long gdc(long divisor, long dividendo) {
		while(divisor%dividendo!=0) {
			long rest = divisor % dividendo;
			divisor = dividendo;
			dividendo = rest;
		}
		return dividendo;
	}
	
	static long nCr3(long n, long p) {
		if(p == 1)
			return n;
		long a = nCr3(n, p-1);
		long b = n-p+1;
		long c = p;
		long d = gdc(a, c);
		a /= d;
		c /= d;
		d = gdc(b, c);
		b /= d;
		c /= d;
		return (a*b)/c;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(zerosFactorial(30));
		System.out.println(nCr1(200,5));
		System.out.println(nCr2(200,5));
		System.out.println(nCr3(200,5));
		System.out.println(gdc(50, 4));
	}

}
