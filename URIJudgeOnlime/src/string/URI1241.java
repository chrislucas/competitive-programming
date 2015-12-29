package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// DOne
public class URI1241 {

	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		String A, B, quantity;
		try {
			//while( (quantity = buffer.readLine()) != null ) {
				quantity = buffer.readLine();
				int n = Integer.parseInt(quantity);
				while(n>0) {
					String enter = buffer.readLine();
					StringTokenizer tokenizer = new StringTokenizer(enter, " ");
					A = tokenizer.nextToken();
					B = tokenizer.nextToken();
					if(A.length() >= B.length()) {
						int ini = A.length() - B.length();
						int end = A.length();
						String subs = A.substring(ini, end);
						writer.printf("%s\n", B.equals(subs) ? "encaixa" : "nao encaixa");
					} else {
						writer.printf("nao encaixa\n");
					}
					n--;
				}
			//}
		} catch(IOException ioex) {}
	}
}
