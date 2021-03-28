package algorithm.dp;

/*
 * https://www.hackerrank.com/challenges/maxsubarray/topics/dynamic-programming-basics
 * https://www.hackerrank.com/challenges/string-reduction
 * */

public class HRBasicsDP {
	
	
	/*
	 * Two caracteristics suggests that a given problem can be solved using Dynamic Programming
	 * DP
	 * Overlapping subproblems
	 * Optimal substructure Property
	 * 
	 * DP has two methods that can be used according to the problem
	 * 
	 * Top Down and Bottom up Approaches
	 * 
	 * Top Down: Try to solve the bigger problem by recursively finding the solutuion
	 * to smaller problems while also storing local solutions in a table, This technique
	 * is called Memo-ization
	 * 
	 * */
	
	
	// exemplo da abordagem Top Down
	// Seja uma funcao recursiva F
	// F(N) = F(n-1)+f(n-3) se n >= 3
	// do contratio f(n) = 7
	
	public static int topDown(int n, int [] pd) {
		if(n<3) {
			return 7;
		}
		else {
			int ans = topDown(n-1, pd) + topDown(n-3, pd);
			return pd[n] = ans;
		}
	}
	
	public static int bottomUp(int n, int [] pd) {
		pd[0] = pd[1] = pd[2] = 7;
		for(int i=3; i<pd.length; i++) {
			pd[i] = pd[i-3] + pd[i-1];
		}
		return pd[pd.length-1];
	}
	
	public static void main(String[] args) {
		int [] array = new int[30];
		bottomUp(7, array);
		return;
	}

}
