package math;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class URI1220 {
	static BufferedInputStream is = new BufferedInputStream(System.in);
	static BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
	static PrintWriter out = new PrintWriter(System.out, true);
	static final DecimalFormat df = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
	
	public static void main(String[] args) throws IOException {
		String in;
		while( !(in = buffer.readLine()).equals("0") ) {
			 int n = Integer.parseInt(in);
			 long mean = 0, values[] = new long[n];
			 double value;
			 for(int i=0; i<n; i++) {
				 in = buffer.readLine();
				 value = Double.parseDouble(in);
				 values[i] = Math.round(value * 100.0);
				 mean += values[i];
			 }
			 long dec = mean % n;	// o resto da somatoria diz a partem em centavos
			 mean = mean/n; 		// media de gasto por qtd de alunos
			 long ans = 0;
			 for(int i=0; i<n; i++) {
				 if(values[i] > mean) {
					 if(dec > 0) {
						 // menos 1 centavo
						 ans += values[i] - mean - 1;
						 dec--;
					 } else {
						 ans += values[i] - mean;
					 }	
				 }
			 }
			 out.printf("$%d.%02d\n", ans/100, ans%100);
		}
	}
}
