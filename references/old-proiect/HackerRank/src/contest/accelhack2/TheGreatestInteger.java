package contest.accelhack2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
 * https://www.hackerrank.com/contests/accel-hack/challenges/private-mth-greatest-number
 * https://www.hackerrank.com/contests/accel-hack/challenges?utm-source=accel-hack-reminder-start&utm-medium=email&utm-campaign=accel-hack
 * https://www.hackerrank.com/feed
 * */

public class TheGreatestInteger {
	static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
	
	public static void solution(int [] list, int k) {
		SortedSet<Integer> set = new TreeSet<Integer>();
		for(Integer u : list)
			set.add(u);
		Integer[] array = (Integer[]) set.toArray(new Integer[set.size()]);;
		int  start = 0
		    ,s = array.length;
		while(start < s-1) {
			boolean add = false;
			for(int i=start; i<s-1; i++) {
				int d = array[start] - array[i+1] < 0 ? -(array[start] - array[i+1]) : array[start] - array[i+1];
				if(set.contains(d))
					continue;
				set.add(d);
				add = true;
				break;
			}
			if(!add)
				start++;
			array = (Integer[]) set.toArray(new Integer[set.size()]);;
			s = array.length;
		}
		array =  (Integer[]) set.toArray(new Integer[set.size()]);
		//int l = 0, r = array.length-1;
		//System.out.println(kthSmallest(array, l, r, k));
		Arrays.sort(array, Collections.reverseOrder());
		writer.println(array[k-1]);
		return;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader  buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(buffer.readLine()), i=0;
			StringTokenizer in = new StringTokenizer(buffer.readLine(), " ");
			int [] set = new int[n];
			while(in.hasMoreTokens()) {
				set[i++] = Integer.parseInt(in.nextToken());
			}
			int k =  Integer.parseInt(buffer.readLine());
			solution(set, k);
		} catch(IOException ioex) {}
	}
}
