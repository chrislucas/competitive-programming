package contest.hack101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/contests/101hack36/challenges/reduced-string/
 * DONE
 * */
public class ReduceString {

	public static void process(String str) {
		Stack<Character> stack = new Stack<>();
		char [] S = str.toCharArray();
		
		for(char c : S) {
			if(stack.empty())
				stack.push(c);
			else {
				if(c == stack.peek())
					stack.pop();
				else
					stack.push(c);
			}
		}
		
		if(stack.empty()) {
			CompIO.print("Empty String");
		}
		Stack<Character>  otherStack = new Stack<>();
		while(!stack.isEmpty()) {
			otherStack.push(stack.pop());
		}
		while(!otherStack.empty()) {
			CompIO.pritf("%c", otherStack.pop());
		}
	}
	
	public static void main(String[] args) {
		CompIO.init();
		String enter = CompIO.read();
		process(enter);
	}
	
	public static class CompIO {
		private CompIO() {  throw new UnsupportedOperationException(); }
		private static BufferedReader buffer;
		private static PrintWriter writer;
		private static StringTokenizer tk;
		
		public static void init() {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		}
		
		public static String read(String delimiter) {
			while(tk == null || ! tk.hasMoreTokens()) {
				try {
					if(delimiter == null)
						tk = new StringTokenizer(buffer.readLine());
					else
						tk = new StringTokenizer(buffer.readLine(), delimiter);
				} catch(IOException ioex){}
			}
			return tk.nextToken();
		}
		
		public static String read() {
			return read(null);
		}
		
		public static int readInt(String delimiter) {
			return Integer.parseInt(read(delimiter));
		}
		
		public static double readDouble(String delimiter) {
			return Double.parseDouble(read(delimiter));
		}
		
		public static void pritf(String format, Object ... objects) {
			writer.printf(format, objects);
		}
		
		public static void print(String data) {
			writer.printf("%s\n", data);
		}
	}
}
