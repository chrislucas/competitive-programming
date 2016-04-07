package tests.math;


/**
 * http://www.geeksforgeeks.org/factorial-large-number/
 * 
 * */

public class BigNumber {
	
	static class Number {
		private static final int size = 1<<10;			// quantidade maxia de digitos
		private int[] number;							// array que representara o numero calculado
		private int digits;								// contador de digitos
		// representacao do numerom como string
		private static final StringBuilder representation = new StringBuilder();
		
		public Number() {
			digits = 1;
		}
		
		public Number(long n) {
			super();
		}
		
		public String factorial(int n) {
			number = new int[size];
			number[0] = 1;
			for(int x=2; x<=n; x++) {
				multiply(x);
			}
			return toString();
		}
		
		public String fibonacci(int n) {
			return null;
		}
		
		public void multiply(int n) {
			int carry = 0;
			for(int i=0; i<digits; i++) {
				// digitos * o multiplicador + o deslocador
				int rs 		= number[i] * n + carry;
				number[i] 	= rs % 10;
				carry 		= rs / 10;
			}
			while(carry>0) {
				number[digits++] = carry % 10;
				carry /= 10;
			}
			return;
		}
		
		@Override
		public String toString() {
			for(int i=digits-1; i>-1; i--)
				representation.append(number[i]);
			return representation.toString();
		}
		
		/*
		 * Mudanca de base logaritma
		 * 
		 * log 10 base 2 = log 10 base 10 / log 2 base 10
		 * 
		 * x = log10(N!)
		 * x = log10(1󫎿�...譔)
		 * x = log10(1)+log10(2)+log10(3)+...+log10(N)
		 * This is using the law log10(a * b) = log10(a) + log10(b)
		 * */
		public static double log(double n, long base) {
			return Math.log10(n) / Math.log10(base);
		}
		
		public static long countDigits(long n, int base) {
			return Math.round(log(n, base)) + 1;
		}
		
		/*
		 * http://pitcher.digitalfreehold.ca/code/computeSize
		 * 
		 * Pesquisar Kamenetsky's formula
		 * http://mathoverflow.net/questions/19170/how-good-is-kamenetskys-formula-for-the-number-of-digits-in-n-factorial
		 * */
		public static long countDigitsFactoriak(long n) {
			double acc = 0;
			for(long x=n; x>1; x--)
				acc += log(x, 10);
			return Math.round(acc);
		}
	}
	
	public BigNumber() {}
	
	public static void main(String[] args) {
		BigNumber.Number number = new Number();
		System.out.println(number.factorial(12));
		System.out.println(Number.countDigits(12, 10));
		System.out.println(Number.countDigitsFactoriak(12));
	}

}
