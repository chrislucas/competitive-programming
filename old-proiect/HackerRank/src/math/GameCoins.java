package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GameCoins {

	public static void main(String[] args) throws IOException {
		String enter;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		enter = reader.readLine();
		int T = Integer.parseInt(enter);
		StringTokenizer token;
		while(T>0) {
			enter = reader.readLine();
			token = new StringTokenizer(enter, " ");
			int A = Integer.parseInt(token.nextToken());
			int B = Integer.parseInt(token.nextToken());
			String ans = "";
			int games = (A-1)+(B-1);
			// e games for impar o ultimo a jogar sem perder eh o "First"
			ans = ( A == 0 || B == 0 || (games%2==1) ) ? "First\n" : "Second\n";
			writer.printf("%s", ans);
			T--;
		}
	}
}
