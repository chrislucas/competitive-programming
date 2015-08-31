package Math;

public class Multiply {

	static long gcd(long a, long b) {
		while(a%b!=0) {
			long c = a%b;
			a=b;
			b=c;
		}
		return b;
	}
	static long fastexp(long a, long p, long m) {
		long x;
		if(p==0) return 1;
		if(p==1) return a;
		//if(p<0) fastexp(1/a, -p, m);
		if(p%2==0){
			x = fastexp(a, p/2, m)%m;
			return (x*x)%m;
		} else {
			return(a * fastexp(a, p-1, m))%m;
		}
			
	}
	// iv de x tal que ax = 1 mod p
	static long inv(long a, long p) {
		long x;
		for(x=1; x<=p; x++) {
			if((a*x)%p==1)
				break;
		}
		return x;
	}
	
	static void inv2(long a, long p) {
		long x, ans[] = new long[(int) (p+2)];
		if(ans[(int)a] != 0) {
			System.out.println(ans[(int)a]);
			return;
		}
		for(x=1; x<=p; x++) {
			if((a*x)%p == 1) {
				ans[(int)a] = x;
				ans[(int)x] = a;
			}
		}
		System.out.printf("%d %d\n", ans[(int)a], ans[(int)x]);
		return;
	}
	
	public static void main(String[] args) {
		//System.out.println(inv(51,100));
		//inv2(51,100);
		System.out.println(fastexp(31,-3,150));
		System.out.println(gcd(250,15));
	}

}
