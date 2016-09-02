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
	
	public static int solver(boolean [] S, int kill, int n, int p) {
		int count = S.length-1;
		while( count > 1 ) {
			kill = (kill + p - 1) % n;
			if(S[kill]) {
				S[kill] = false;
				count--;
			}
			kill = kill % n + 1;
		}
		return kill;
	}
	
	public static void runTechModular() {
		int n = 17, p = 5;
		boolean [] S = new boolean [n+1];
		for(int i=2; i<n+1; i++)
			S[i] = true;
		solver(S, 2, n, p);
	}
	
	public static void run() {
		System.out.println(sRecursive(5, 9, 3));
		System.out.println(sIterative(5, 9, 3));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//run();
		runTechModular();
	}

}
