package math.combinatory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/a-chocolate-fiesta/submissions/code/21451185
 * https://www.hackerrank.com/contests/infinitum-mar14/challenges
 * DONE
 * */

public class ChocoFiesta {

	static class LiteTemplateIO {
		private static BufferedReader reader;
		private static PrintWriter writer;
		public static void init()  {
			boolean oj 	= System.getProperty("ONLINE_JUDGE") == null;
			try {
				reader 		= oj ? new BufferedReader(new InputStreamReader(System.in)) : new BufferedReader(new FileReader("input.txt"));
				writer 		= oj ? new PrintWriter(new OutputStreamWriter(System.out), true) : new PrintWriter(new FileWriter("output.txt"));
			} catch (IOException e) {}
		}
		
		public static String read(String del) {
			StringBuilder builder = new StringBuilder();
			try {
				StringTokenizer tokenize = new StringTokenizer(reader.readLine(), del);
				while(tokenize.hasMoreTokens()) {
					builder.append(tokenize.nextToken());
				}
			} catch (IOException e) {}
			return builder.toString();
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static int[] readInts(String del) {
			int array [] = null;
			try {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), del);
				array = new int[tokenizer.countTokens()];
				for(int i=0; tokenizer.hasMoreTokens(); i++) {
					array[i] = Integer.parseInt(tokenizer.nextToken());
				}
			} catch (IOException e) {}
			return array;
		}
		
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}
	
	public static void subset(int [] array) {
		int sz 			= array.length;
		for(int i=0; i<(1<<sz); i++) {
			for(int j=sz-1; j>=0; j--) {
				if( (i & 1<<j) > 0) {
					System.out.printf("%d", array[j]);
				}
			}
			System.out.println("");
		}
	}
	
	public static long subsetEven(int [] array) {
		int sz 			= array.length;
		//long [] subset 	= new long[sz];
		long counter = 0;
		int szps = (1<<sz);
		for(int i=0; i<szps; i++) {
			int idx = 0;
			long odd = 0;
			for(int j=sz-1; j>=0; j--) {
				if( (i & 1<<j) > 0 ) {
					//subset[idx++] = array[j];
					idx++;
					if( (array[j] & 1) == 1)
						odd = (odd + 1) % 1000000007;
				}
			}
			if(odd%2==0 && idx > 0)
				counter = (counter + 1) % 1000000007;
		}
		return counter;
	}
	
	public static double log(double logt, int base) {
		// troca de base usando base 10
		//http://www.infoescola.com/matematica/logaritmo/
		return Math.log10(logt) / Math.log10(base);
	}
	
	static long expmod(long b, int e, long m) {
		long ans = 1;
		int i=e;
		while(i>0) {
			if( (i & 1) == 1 ) {
				ans = ((ans%m) * (b%m)) % m;
			}
			b = ((b%m) * (b%m)) % m;
			i /= 2;
		}
		/*
		for(int x=0; x<e; x++) {
			ans = (ans * b) % m;
		}
		*/
		return ans;
	}
	
	static int knaryLRMethod(int b, int e, int m) {
		return 0;
	}
	
	public static long solution(int [] array) {
		ArrayList<Integer> odd, even;
		odd = new ArrayList<>();
		even = new ArrayList<>();
		for(int a : array) {
			if( (a & 1) == 1)
				odd.add(a);
			else
				even.add(a);
		}
		/*
		long cEven = 0;
		long setEven = expmod(2,even.size(), 1000000007) - 1;
		for(int i=0; i<setEven; i++) {
			boolean flag = false;
			for(int j=even.size()-1; j>=0; j--) {
				if( (i & 1<<j) > 0 ) {
					//System.out.printf("%d", even.get(j));
					flag = true;
				}
			}
			if(flag)
				cEven = (cEven + 1) % 1000000007;
			//System.out.println("");
		}
		*/
		/*
		int cOdd = 0;
		long setOdd = expmod(2,odd.size(), 1000000007);
		for(int i=0; i<setOdd; i++) {
			int oddSum = 0;
			for(int j=odd.size()-1; j>=0; j--) {
				if( (i & 1<<j) > 0 ) {
					//System.out.printf("%d", odd.get(j));
					oddSum++;
				}
			}
			if(oddSum > 0 && (oddSum & 1) == 0) {
				cOdd = (cOdd + 1) % 1000000007;
			}
			//System.out.println("");
		}
		*/
		int k =(odd.size() == 0) ? 0 : 1;
		return (expmod(2, array.length - k, 1000000007) - 1) % 1000000007;
		//return cOdd + cEven + (cOdd * cEven);
	}
	/*
	 * 
	 * */
	public static long solution2(int [] array) {
		int even = 0, odd = 0;
		for(int a : array) {
			if( (a & 1) == 1)
				odd++;
			else
				even++;
		}
		int k =(odd == 0) ? 0 : 1;
		return (expmod(2, array.length - k, 1000000007) - 1) % 1000000007;
	}
	
	public static void run() {
		LiteTemplateIO.init();
		int n 		= Integer.parseInt(LiteTemplateIO.read());
		int [] set 	= LiteTemplateIO.readInts(" ");
		LiteTemplateIO.printf("%d\n", solution(set));
	}

	public static void main(String[] args) {
		//System.out.println(log(1000, 10));
		//System.out.println(expmod(2,47,Integer.MAX_VALUE-1));
		//System.out.println(expmod(2,47,1000000007));
		run();
	}

}
