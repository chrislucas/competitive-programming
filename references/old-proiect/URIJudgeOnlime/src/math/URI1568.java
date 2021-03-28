package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1568
 * 
 * */

public class URI1568 {
	
	public static List<Integer> crive(int n) {
		List<Integer> primes = new LinkedList<Integer>();
		//int limit = (int) Math.round(Math.sqrt(n));
		boolean [] bools = new boolean[n+1];

		for(int i=2; i<=n; i++)
			bools[i] = true;
		
		for(int i=2; i*i<=n; i++) {
			if(bools[i]) {
				for(int j=i*i; j<=n; j +=i) {
					bools[j] = false;
				}
			}
		}
		
		for(int i=2; i<bools.length; i++) {
			if(bools[i])
				primes.add(i);
		}
		
		return primes;
	}
	
	
	// TLE
	public static int solver(long n, List<Integer> primes) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int limit = primes.size();
		int count = 0;
		int p = primes.get(count++);
		while(n > 1 && count < limit && p*p <= n) {
			p = primes.get(count++);
			while(n%p==0) {
				if(map.containsKey(p)) {
					map.put(p, map.get(p) + 1);
				}
				else {
					map.put(p, 1);
				}
				n /= p;
			}
		}
		
		if(n > 1) {
			if(map.containsKey(p)) {
				map.put(p, map.get(p) + 1);
			}
			else {
				map.put(p, 1);
			}
		}
		
		int ans = 1;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, Integer> pair = it.next();
			if(pair.getKey() == 2)
				continue;
			ans *= (pair.getValue() + 1);
		}
		return ans;
	}
	
	public static int so2(int n, List<Integer> primes) {
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> primes = crive(3000000);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
			String in;
			while( (in = reader.readLine()) != null) {
				long n = Long.parseLong(in);
				writer.printf("%d\n", solver(n, primes));
			}
		} catch(IOException ioex) {}
	}
}
