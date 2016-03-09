package algs.jar;
import  edu.princeton.cs.algs4.Stopwatch;

/*
 * http://introcs.cs.princeton.edu/java/41analysis/
 * 	http://introcs.cs.princeton.edu/java/41analysis/ThreeSum.java
 * 
 * 	http://www.cs.princeton.edu/introcs/41analysis/8ints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/1Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/2Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/4Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/8Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/16Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/32Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/64Kints.txt
 *  http://www.cs.princeton.edu/introcs/41analysis/128Kints.txt
 * */


public class NSum {
	

	// metodo que verifica quantas combinacoes de N numeros somados
	// resultam no valor Q
	public static int nSum(int array[], int n, int q) {
		int counter = 0,
			limit = array.length,
			acc;
		for(int i=0; i<limit-n+1; i++) {
			for(int j=i+1; j<limit-n+1; j++) {
				for(int k=j+1; k<limit; k++)
					if(array[i] + array[j] + array[k] == 0)
						counter++;
			}
		}
		return counter;
	}
	
	public static void main(String[] args) {
		int array[] = {30,-40,-20,-10,40,0,10,5}
		,n = 3
		,q = 0;
		
		//array = In.readInts();
		Stopwatch watch = new Stopwatch();
		System.out.println(nSum(array,n,q));
		System.out.println(watch.elapsedTime());
	}

}
