package com.br.wiselabs.exercises;

public class ThreeSum {
	
	
	public static int binarySeach(int[] array, int n) {
		int le = 0, ri = array.length - 1, mi;
		while(le <= ri) {
			mi = (ri - le) / 2 + le;
			if(array[mi] > n)
				ri = mi - 1;
			else if(array[mi] < n)
				le = mi + 1; 
			else
				return mi;
		}
		return -1;
	}
	
	public static int[] findThreeSum(int[] array) {
		int index;
		for(int i=0; i<array.length-1; i++) {
			for(int j=i+1; j<array.length; j++) {
				index = binarySeach(array, -(array[i] + array[j]));
				if(index > j /*>-1 && index != i && index != j*/)
					System.out.printf("%d %d %d\n",i,j,index);
			}
		}
		return null;
	}
	
	// http://stackoverflow.com/questions/3305059/how-do-you-calculate-log-base-2-in-java-for-integers
	/**
	 * propriedades
	 * trocar de base
	 * log x na base b e log de y na base a
	 * ( log(x) na base b / log(a) na base b )
	 * exemplo log(64) na base 2
	 * pode ser feito = log(64) base 10 / log(2) 10
	 * */
	public static double log(double op, double base) {
		return Math.log10(op) / Math.log10(base);
	}

	public static void main(String[] args) {
		//int array[] = {-40,-20,-10,0,5,10,30,40};
		//System.out.println(binarySeach(array, 30));
		//findThreeSum(array);
		double test[] = {
				2.9184241032213470040176835678182
				,2.9199047624053274186512212171701
				,2.9176660021469099831314215611103
				,2.9219877223641170408208988663351
				,2.914968652037617554858934169279
				,2.9186176142697881828316610925307
				,2.9123376623376623376623376623377
				,2.9056603773584905660377358490566
				,2.9444444444444444444444444444444
				,3
				,3
				,5.2129218181634976774180546738813
				,2.892965740928441110885870666937};
		for(int i=0; i<test.length; i++)
			System.out.println(log(test[i],2));
	}

}
