package tests.math;

public class Josephus {

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1032
 * http://www.spoj.com/problems/ANARC08H/
 * */	
	public static int sRecursive(int i, int n, int p) {
		if(n == i) {
			return n;
		}
		else {
			// (sRecursive(i, n-1, p) + p-1) % n + 1;
			int s = sRecursive(i, n-1, p); 
			return (s+p-1)%n+1;
		}
	}
	
	public static int sIterative(int i, int n, int p) {
		int idx = i;
		while(i<n) {
			idx = (idx+p-1)%i+1;
			i++;
		}
		return idx;
	}
	
	public static void fx() {
		for(int i=1;i<Integer.MAX_VALUE;i++) {
			int ans = sIterative(2, 17, i);
			if(/*sRecursive*/ans == 13) {
				System.out.println(i);
				break;
			}	
		}
	}
	
	public static int solver(boolean [] S, int kill, int n, int p) {
		int count = S.length-1;
		while( count > 1 ) {
			if(S[kill]) {
				S[kill] = false;
				count--;
				kill += p-1;
				kill %= count;
			}
			
			else {
				kill++;
			}
		}
		return 0;
	}
	
	public static void runList() {
		System.out.println(sRecursive(1, 17, 5));
		int n = 17, p = 5;
		boolean [] S = new boolean [n+1];
		S[0] = false;
		for(int i=1; i<n+1; i++)
			S[i] = true;
		
		solver(S, 1, n, p);
		
	}
	
	public static void run() {
		System.out.println(sRecursive(2, 9, 3));
		System.out.println(sIterative(2, 9, 3));
		//fx();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//run();
		runList();
	}

}
