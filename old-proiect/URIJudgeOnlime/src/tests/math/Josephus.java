package tests.math;

public class Josephus {

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1032
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1660
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1030
 * http://www.spoj.com/problems/ANARC08H/
 * */
	
	public static int sRecursive(int n, int p) {
		if(n == 1) {
			return n;
		}
		else {
			int s = sRecursive(n-1, p);
			int r = (s+p-1)%n+1;
			return r;
		}
	}
	// (sRecursive(i, n-1, p) + p-1) % n + 1;
	public static int sRecursive(int i, int n, int p) {
		if(n == i) {
			return n;
		}
		else {
			int s = sRecursive(i, n-1, p);
			int r = (s+p-1)%n+1;
			return r;
		}
	}
	
	public static int sIterative(int n, int p) {
		int idx = 1, i = 2;
		while(i<=n) {
			idx = (idx+p-1)%i+1;
			i++;
		}
		return idx;
	}
	
	public static int sIterative(int i, int n, int p) {
		int idx = i;
		i++;
		while(i<=n) {
			idx = (idx+p-1)%i+1;
			i++;
		}
		return idx;
	}
	
	public static int solver(boolean [] S, int kill, int n,  int p) {
		int count = n;
		int idx = kill, counter = 0;
		while(count > 1) {			
			if(S[idx]) {
				counter++;
			}
			if(counter == p) {
				S[idx] = false;
				counter = 0;
				count--;
			}
			if(count==1)
				break;
			idx = idx%n+1;
		}
		return idx;
	}
	
	public static void runTestSolver() {
		int n = 17, p [] = {5, 7}, ans = 0;
		int g = p[0];
		for ( ;g <= n; g++) {
			boolean[] S = new boolean[n+1];
			for(int i=0; i<n+1; i++)
				S[i] = true;
			S[0] = S[1] = false;
			ans = solver(S, 2, n, g);
			if(ans == 13)
				break;
		}
		System.out.println(g);
	}
	
	public static void run() {
		System.out.println(sIterative(17, 3));
		System.out.println(sRecursive(17, 3));
		System.out.println(sRecursive(5, 9, 3));
		System.out.println(sIterative(5, 9, 3));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//run();
		runTestSolver();
	}

}
