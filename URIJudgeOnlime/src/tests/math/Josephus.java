package tests.math;

public class Josephus {

/*
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1032
 * http://www.spoj.com/problems/ANARC08H/
 * */	
	public static int sRecursive(int n, int p) {
		if(n == 1) {
			return 1;
		}
		else {
			int s = (sRecursive(n-1, p)+p-1) % n + 1;
			return s;
		}
	}
	
	public static int sIterative(int n, int p) {
		int idx = 1;
		for(int i=1; i<=n; i++) {
			idx = (idx+p-1)%i+1;
		}
		return idx;
	}
	
	public static void fx() {
		for(int i=1;i<Integer.MAX_VALUE;i++) {
			if(sRecursive(17, i) == 13) {
				System.out.println(i);
				break;
			}	
		}
	}
	
	public static void run() {
		System.out.printf("%d %d\n%d %d\n%d %d"
			,sRecursive(5, 2)
			,sIterative(5, 2)
			,sRecursive(14, 2)
			,sIterative(14, 2)
			,sRecursive(17, 7)
			,sIterative(17, 7)
		);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}

}
