package tutoriais.brillant.ntheory;

/*
 * http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers?utm_campaign=ctci-challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * */

public class FiboN {

	/*
	 * Essa recorrencia eh nova hein
	 * */
	
	public static int fn(int n, int [] array) {
		if(n < 3)
			return array[n];
		else {
			int k = (n & 1) == 1 ? (n+1)/2 : n/2;
			int ans;
			if( (n & 1) == 1 ) {
				int a = fn(k, array);
				int b = fn(k, array);
				int c = fn(k-1, array);
				int d = fn(k-1, array);
				ans = a * b + c * d;
			}
			else {
				int a = 2 * fn(k-1, array);
				int b = fn(k, array);
				int c = fn(k, array);
				ans = (a+b)*c;
			}
			array[n] = ans;
			return array[n];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array [] = new int[41];
		array[0] = 0;
		array[1] = 1;
		array[2] = 1;
		int ans = fn(35, array);
		System.out.println(ans);
	}
}
