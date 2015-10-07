package exercise;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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
		,n = 6
		,q = 0;
		System.out.println(nSum(array,n,q));
	}
	
	// http://stackoverflow.com/questions/5054132/how-to-change-the-decimal-separator-of-decimalformat-from-comma-to-dot-point
	public static void testFormatNumber() {
		NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
		DecimalFormat df = (DecimalFormat) nf;
	}

}
