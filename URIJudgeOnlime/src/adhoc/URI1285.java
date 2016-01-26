package adhoc;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// https://www.urionlinejudge.com.br/judge/pt/problems/view/1285
// DONE
public class URI1285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out), true);
		String in;
		try {
			while ( (in = reader.readLine()) != null)  {
				StringTokenizer token = new StringTokenizer(in, " ");
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				int counter = 0;
				int[] array;
				boolean flag;
				for(int i=a; i<=b; i++) {
					flag = true;
					array = new int[10];
					for(int j=i; j>0; j /= 10) {
						array[j%10]++;
						if(array[j%10] > 1) {
							flag = false;
							break;
						}
					}
					if(flag)
						counter++;
				}
				writer.printf("%d\n", counter);
			}
		} catch (IOException e) {}
	}
}
