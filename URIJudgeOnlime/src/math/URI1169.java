package math;
//DONE
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class URI1169 {
	public static final InputStream in = new BufferedInputStream(System.in, 1<<16);
	public static final BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
	public static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
	public static double summation (int limit) {
		double sum = 0.0;
		for(int i=0; i<limit; i++)
			sum += Math.pow(2, i);
		return sum;
	}
	
	/**
	 * PA: http://educacao.uol.com.br/disciplinas/matematica/progressao-artimetica-pa-formula-da-soma-e-do-termo-geral.htm
	 * PG: http://www.mundoeducacao.com/matematica/soma-dos-termos-uma-pg-finita.htm
	 * */
	public static double sumGeometricProgress(int limit) {
		double power = Math.pow(2, limit) - 1;
		double sum = (1 * power) / (2 - 1);
		return sum;
	}
	//DONE
	public static void main(String[] args) {
		try {
			String enter = buffer.readLine();
			int n = Integer.parseInt(enter);
			while(n>0) {
				enter = buffer.readLine();
				int x = Integer.parseInt(enter);
				out.printf("%.0f kg\n", Math.floor(summation(x)/12000));
				n--;
			}
		} catch(IOException e) {}
	}
}
