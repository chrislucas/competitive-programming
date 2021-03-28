package beginner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
/*
 * https://www.hackerrank.com/challenges/birthday-cake-candles
 * DONE
 * */

public class BirthdayCC {
	
	public static void getData() {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String ans = "";
        try {
            int n = Integer.parseInt(buffer.readLine());
            ans = buffer.readLine();
            s2(n, ans);
        } catch(Exception e) {
            
        }
	}

	public static void s2(int n, String in) {
		int max = 0;
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer  tk = new StringTokenizer(in, " ");
        while(tk.hasMoreTokens()) {
            int d = Integer.parseInt(tk.nextToken());
            if(d > max)
                max = d;
            if(map.containsKey(d)) {
            	map.put(d, map.get(d) + 1);
            }
            else {
            	map.put(d, 1);
            }
        }
        System.out.println(map.get(max));
	}
	
	public static void s1(int n, String in) {
        int height[] = new int[10000000];
        int max = 0;
        StringTokenizer  tk = new StringTokenizer(in, " ");
        while(tk.hasMoreTokens()) {
            int d = Integer.parseInt(tk.nextToken());
            if(d > max)
                max = d;
            height[d]++;
        }
        System.out.println(height[max]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getData();
	}
}
