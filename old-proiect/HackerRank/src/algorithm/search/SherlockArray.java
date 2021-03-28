package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/sherlock-and-array
 * DONE
 * */

public class SherlockArray {
	
	// uma ideia O (n ^ 2)
	// resolve 90% dos casos de teste, 2 dao TLE
	public static boolean s(int [] array) {
		int s = array.length;
		if(s == 1)
			return true;
		int l, r;
		for(int i=1; i<=s-2; i++) {
			l = r = 0;
			for(int j=0; j<s; j++) {
				if(j<i)
					l += array[j];
				else if(j>i)
					r += array[j];
				if(r > l)
					break;
			}
			if(l == r)
				return true;
		}
		return false;
	}
	// tentando uma solucao linear
	public static boolean s2(int [] a) {
		int s = a.length;
		if(s == 1)
			return true;
		int l = 0, r = 0, sum = 0;
		/*
		for(int i=0, j=s-1; i!=j; ) {
			if(sum >= 0) {
				sum -= a[j--];
			} else {
				sum += a[i++];
			}
		}
		*/
		for(int i=0, j=s-1; i!=j; ) {
			sum = sum + (a[i] - a[j]);
			if(sum > -1)
				j--;
			else
				i++;
		}
		return sum==0;
	}
	
	public static boolean s3(int [] a) {
		int s = a.length;
		if(s == 1)
			return true;
		int i = 0, j = s-1;
		int l = a[i++], r = a[j--];
		while(i!=j && i<j){
			if(r<l)
				r += a[j--];
			else
				l += a[i++];
		}
		return l - r == 0;
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int n = Integer.parseInt(reader.readLine());
			for(int i=0; i<n; i++) {
				int size = Integer.parseInt(reader.readLine());
				StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
				int [] array = new int[size];
				for(int j=0; tk.hasMoreTokens(); j++) {
					array[j] = Integer.parseInt(tk.nextToken());
				}
				writer.printf("%s\n", s3(array) ? "YES" : "NO");
			}
			//writer.printf("%s", s2(new int[]{1,1,5,7,10,14}) ? "YES" : "NO");
		} catch(IOException ioex) {}
	}
}
