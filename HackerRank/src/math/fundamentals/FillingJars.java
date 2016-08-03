package math.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


/*
 * http://math.stackexchange.com/questions/1153794/adding-to-an-average-without-unknown-total-sum
 * http://math.stackexchange.com/questions/22348/how-to-add-and-subtract-values-from-an-average
 * https://en.wikipedia.org/wiki/Average
 * */

public class FillingJars {
	
	// https://www.hackerrank.com/challenges/filling-jars/topics
	//new Random().nextInt(ri - lf) + lf;
	
	public static void solver() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer tokens = new StringTokenizer(reader.readLine(), " ");
			int  m = Integer.parseInt(tokens.nextToken())
				,n = Integer.parseInt(tokens.nextToken());
			/*
			BigInteger avg = BigInteger.ZERO;
			BigInteger M = new BigInteger(String.valueOf(m));
			*/
			double avg = 0;
			for(int i=0; i<n; i++) {
				tokens = new StringTokenizer(reader.readLine(), " ");
				/*
				BigInteger a = new BigInteger(tokens.nextToken())
						,b = new BigInteger(tokens.nextToken())
						,k = new BigInteger(tokens.nextToken());
				*/
				
				long a = Long.parseLong(tokens.nextToken())
					,b = Long.parseLong(tokens.nextToken())
					,k = Long.parseLong(tokens.nextToken());
				
				/*
				BigInteger q = b.subtract(a);
				q = q.add(BigInteger.ONE);
				BigInteger x = avg.multiply(M);
				BigInteger y = q.multiply(k);
				BigInteger z = x.add(y);
				avg = z.divide(M);
				*/
			
		 		long q = b-a+1;
				avg = (avg * m + q * k) / m;
		 		//avg += q * k;
				
			}
			System.out.printf("%d", (long)avg);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stuff
		solver();
	}

}
