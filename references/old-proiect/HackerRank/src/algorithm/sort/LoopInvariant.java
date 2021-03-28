package algorithm.sort;

/*
 * https://www.hackerrank.com/challenges/correctness-invariant?h_r=next-challenge&h_v=legacy
 * DONE
 * http://www.cs.uofs.edu/~mccloske/courses/cmps144/invariants_lec.html
 * 
 * https://www.hackerrank.com/challenges/runningtime?h_r=next-challenge&h_v=legacy
 * 
 * */

public class LoopInvariant {

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T extends Comparable> void isort(T [] A) {
		for(int i=1;i<A.length; i++) {
			T e = A[i];
			int j = i-1;
			while(j>=0 && A[j].compareTo(e) > 0) {
				A[j+1] = A[j--];
			}
			if(j != i-1) {
				A[j+1] = e;
			}
		}
		printArray(A);
		return;
	}
	
	public static <T> void printArray(T [] array) {
		for(T t : array) {
			System.out.printf("%s ", t);
		}
	}
	
	public static void test() {
		Integer [][] ints = {
			{1,4,3,5,6,2}
			,{4,1,3,5,6,2}
		};
		isort(ints[1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}

}
