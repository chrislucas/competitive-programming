package finall.sulamericana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * http://br.spoj.com/problems/CCODIGO/
 * https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=27&page=show_problem&problem=2475
 * http://maratona.ime.usp.br/hist/2009/problemas09.html
 **/

public class CCODIGO {
	
	// ideia furada
	public static int test(char [] seq) {
		char l_char = ' ';
		int count = 0;
		for(char a : seq) {
			char c_char = a;
			if(c_char != 'a') {
				if(c_char != l_char) {
					l_char = c_char;
					count++;
				}
			}
		}
		return count;
	}
	
	public static int test(String seq) {
		int lenS = seq.length();
		int [] distances = new int [lenS];
		for(int i=1; i<lenS; i++) {
			char c_char = (char) (seq.charAt(i) - '\0');
			char b_char = (char) (seq.charAt(i-1) - '\0');
			distances[i] = b_char - c_char;
			if(distances[i] < 0)
				distances[i] += 26;
		}
		
		Arrays.sort(distances);
		int ans = 0, i = 0, j = lenS; 
		while(i < j) {
			while(i < j && distances[i] == 0) i++;
			while(i < j && distances[j] == 0) j--;
			int k = distances[i];
			if( 26 - distances[j] < k)
				k = 26 -  distances[j];
			distances[i] -= k;
			distances[j] = (distances[j] + k) % 26;
			ans+= k;
		}
		if(j == i)
			ans += distances[i];
		return ans;
	}
	
	public static void runTest() {
		String [] seq = {
			"abcde"
			,"abcz"
			,"abdz"
			,"abcxyz"
			,"abcdefghijklmnopqrstuvwxyz"
			,"aaaaaaaaa"
			,"zzzzzzzzz"
			,"zzzzbzzzz"
		};
		for(String s : seq) {
			test(s);
		}
	}
	
	static class CompIO {
		static BufferedReader reader;
		static PrintWriter writer;
		
		public static void construct() {
			reader = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read() {
			String enter = null;
			try {
				enter = reader.readLine();
			} catch (IOException e) {}
			return enter;
		}
		
		public static void printf(String fmt, Object ... data) {
			writer.printf(fmt, data);
		}
		
		public static void printf(String fmt, Object data) {
			writer.printf(fmt, data);
		}
	}

	public static void main(String[] args) {
		CompIO.construct();
		runTest();
		//CompIO.printf("%d", 'z' - '\0');
		String in = "";
		while( ! (in = CompIO.read()).equals("*") ) {
	/*		
			int len = in.length();
			char [] seq = new char[len];
			for(int i=0; i<len; i++) {
				seq[i] = in.charAt(i); //(char) (in.charAt(i) - '\0');
			}
	*/		
			CompIO.printf("%d\n", test(in.toCharArray()));
			
			//CompIO.printf("%d\n", test(in));
		}
	}
	
	public static void bmToCharArray() {
		String in = "";
		int len = in.length();
		
		long s = System.currentTimeMillis();
		char [] new_s = new char[len];
		System.arraycopy(in, 0, new_s, 0, len);
		System.out.printf("%f", (s - System.currentTimeMillis()) / 1000);
		
		s = System.currentTimeMillis();
		new_s = new char[len];
		for(int i=0; i<len; i++) {
			new_s[i] = in.charAt(i); //(char) (in.charAt(i) - '\0');
		}
		System.out.printf("%f", (s - System.currentTimeMillis()) / 1000);
	}
}
