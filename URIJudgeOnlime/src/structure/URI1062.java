package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class URI1062 {

	
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		String numbers;
		ArrayList<Integer> out, list;
		Stack<Integer> stack = new Stack<>();
		try {
			while( ! (numbers = buffer.readLine()).equals("0")  ) {
				String setNumbers;
				StringTokenizer tokenizer;
				out = new ArrayList<>();

				while( ! (setNumbers = buffer.readLine()).equals("0") ) {
					tokenizer = new StringTokenizer(setNumbers, " ");
					while(tokenizer.hasMoreTokens()) {
						out.add(Integer.parseInt(tokenizer.nextToken()));
					}
					
					int n = Integer.parseInt(numbers);
					int acc = 1, acc2 = 0;
					stack.push(acc);
					while(! stack.empty() || acc > n) {
						// se o topo da pilha
						if(stack.peek() == out.get(acc2)) {
							acc2++;
							stack.pop();
						}
						stack.add(++acc);
					}
					writer.printf("%s\n", stack.empty() ? "Yes" : "No");
					while(!stack.empty())
						stack.pop();
				}
			}
		} catch(IOException ioex){}

	}

}
