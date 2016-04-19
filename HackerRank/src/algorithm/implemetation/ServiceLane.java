package algorithm.implemetation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/service-lane?utm-source=infinitum15-reminder-24hr&utm-medium=email&utm-campaign=infinitum15
 *DONE
 *
 * */

public class ServiceLane {

	
	public static int s(int [] array, int i, int j) {
		int min = array[i++];
		while(i<=j) {
			if(min>array[i])
				min = array[i];
			i++;
		}
		return min;
	}
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			StringTokenizer tk = new StringTokenizer(buffer.readLine(), " ");
			int N = Integer.parseInt(tk.nextToken());
			int T = Integer.parseInt(tk.nextToken());
			int []  set = new int[N];
			tk = new StringTokenizer(buffer.readLine(), " ");
			for(int i=0; tk.hasMoreTokens(); i++)
				set[i] = Integer.parseInt(tk.nextToken());
			
			for(int i=0; i<T; i++) {
				tk = new StringTokenizer(buffer.readLine(), " ");
				int a = Integer.parseInt(tk.nextToken());
				int b = Integer.parseInt(tk.nextToken());
				writer.printf("%d\n", s(set, a, b));
			}
		} catch(IOException ioex) {}
	}
}
