package adhoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/*
 * https://www.urionlinejudge.com.br/builder/
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1031
 * https://www.udebug.com/URI/1031
 * 
 * http://cs.stackexchange.com/questions/7048/a-recursive-formula-for-generalized-josephus-problem
 * http://blue.butler.edu/~phenders/InRoads/MathCounts8.pdf
 * Resolver
 * http://www.spoj.com/problems/ANARC08H/
 * DONE
 * */
public class URI1031 {
	public static int solver(boolean [] S, int kill, int n,  int p) {
		int count = n;
		int idx = kill, counter = 0;
		while(count > 1) {			
			if(S[idx]) {
				counter++;
			}
			if(counter == p) {
				S[idx] = false;
				counter = 0;
				count--;
			}
			if(count==1)
				break;
			idx = idx%n+1;
		}
		return idx;
	}
	
	public static void run() {
		try {
			boolean oj 	= true; //System.getProperty("ONLINE_JUDGE") == null;
			BufferedReader reader;
			String path = "C:\\Users\\C.Lucas\\Desktop\\IME-seletiva\\casos-testes\\uri\\1031\\";
			reader 	= oj ? new BufferedReader(new InputStreamReader(System.in))
					: new BufferedReader(new FileReader(path.concat("in.txt")));
			PrintWriter writer;
			writer 	= oj ? new PrintWriter(new OutputStreamWriter(System.out), true)
					: new PrintWriter(new FileWriter(path.concat("out.txt")));
			
			String in;
			while( ! (in = reader.readLine()).equals("0") ) {
				int n = Integer.parseInt(in);
				int g=1, ans;
				for (;g <Integer.MAX_VALUE; g++) {
					boolean[] S = new boolean[n+1];
					for(int i=0; i<n+1; i++)
						S[i] = true;
					S[0] = S[1] = false;
					ans = solver(S, 2, n, g);
					if(ans == 13)
						break;
				}
				writer.printf("%d\n", g);
			}
			writer.close();
		} catch(IOException ex) {
			//System.out.println(ex.getMessage());
		}
	}
	
	public static void gen() {
		for (int i = 13; i < 101; i++) {
			System.out.println(i);
		}
	}
	
	public static void test() {
		int g=1, ans, n = 14;
		for (;g <Integer.MAX_VALUE; g++) {
			boolean[] S = new boolean[n+1];
			for(int i=0; i<n+1; i++)
				S[i] = true;
			S[0] = S[1] = false;
			ans = solver(S, 2, n, g);
			if(ans == 13)
				break;
		}
		System.out.println(g);
	}
	
	public static void main(String[] args) {
		run();
		//test();
	}
}
