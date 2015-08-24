package obi.adhoc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

//DONE

public class SPOJ818 {
	public static final InputStream in = new BufferedInputStream(System.in);
	public static final BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
	public static final PrintWriter out = new PrintWriter(System.out, true);	
	public static void main(String[] args) throws IOException {
		String enter;
		StringTokenizer token;
		int count = 1;
		while( !(enter = buffer.readLine()).equals("0 0") ) {
			 token = new StringTokenizer(enter, " ");
			 int port = Integer.parseInt(token.nextToken());
			 int fly = Integer.parseInt(token.nextToken());
			 int airport[] = new int[port];
			 int max = 0;
			 while(fly>0) {
				 enter = buffer.readLine();
				 token = new StringTokenizer(enter, " ");
				 int in = Integer.parseInt(token.nextToken());
				 int out = Integer.parseInt(token.nextToken());
				 airport[in-1]++;
				 airport[out-1]++;
				 /*
				 if(airport[in-1] > max)
					 max = airport[in-1];
				 if(airport[out-1] > max)
					 max = airport[out-1];
				 */
				 int m = airport[in-1] > airport[out-1] ?airport[in-1] : airport[out-1];
				 max = max > m ? max : m;
				 fly--;
			 }
			 out.printf("Teste %d\n", count++);
			 for(int i=0; i<port; i++) {
				 if(airport[i] == max) {
					 String format = i == 0 ? "%d" : " %d";
					 out.printf(format, i+1);
				 }
			 }
			 out.printf("\n");
		}	
	}
}
