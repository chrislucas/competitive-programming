package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class URI1743 {

	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out, true);
		StringTokenizer token;
		try {
			//buffer.readLine().replace(" ", "");
			token = new StringTokenizer(buffer.readLine(), " ");
			StringBuilder first = new StringBuilder();
			while(token.hasMoreTokens()) {
				first.append(token.nextToken());
			}
			token = new StringTokenizer(buffer.readLine(), " ");
			StringBuilder second = new StringBuilder();
			while(token.hasMoreTokens()) {
				second.append(token.nextToken());
			}
			boolean flag = true;
			for(int i=0; i<second.length(); i++) {
				if(first.charAt(i) == second.charAt(i)) {
					flag = false;
					break;
				}
			}
			out.printf("%s\n", flag ? "Y" : "N");
		} catch(IOException ioex){}
	}
}
