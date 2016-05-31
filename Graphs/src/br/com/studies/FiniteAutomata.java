package br.com.studies;

/**
 * http://www.geeksforgeeks.org/searching-for-patterns-set-5-finite-automata/
 * */

public class FiniteAutomata {

	public static void xor() {
		boolean ans = false;
		for(int i=0; i<5; i++) {
			boolean F = (i%2) == 0 ? false : true;
			boolean S = !F;
			ans ^= F ^ S;
		}
		System.out.println(ans);
		System.out.println(0^1^0^1^0);
		System.out.println(0^1^0^1^0^1^0);
	}
	
	public static void main(String[] args) {

		xor();
		

	}

}
