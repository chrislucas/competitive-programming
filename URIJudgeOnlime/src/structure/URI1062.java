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
		String quantity;
		ArrayList<Integer> out;
		Stack<Integer> stack = new Stack<>();
		try {
			while( ! (quantity = buffer.readLine()).equals("0")  ) {
				int n = Integer.parseInt(quantity);
				String setNumbers;
				StringTokenizer tokenizer;
				out = new ArrayList<>();
				while( ! (setNumbers = buffer.readLine()).equals("0") ) {
					tokenizer = new StringTokenizer(setNumbers, " ");
					while(tokenizer.hasMoreTokens()) {
						out.add(Integer.parseInt(tokenizer.nextToken()));
					}
					int acc = 0;
					for(int i=1; i<=n; i++) {
						if(i == out.get(acc)) {
							acc++;
						}
						else {
							stack.add(i);
						}
						if( ! stack.empty() ) {
							while(! stack.empty()  && stack.peek() == out.get(acc)) {
								acc++;
								stack.pop();
							}
						}
					}
					/*
					while(! stack.empty() ) {
						// se o topo da pilha
						if(stack.peek() == out.get(acc)) {
							acc++;
							stack.pop();
						} else {
							break;
						}
					}*/
					writer.printf("%s\n", stack.empty() ? "Yes" : "No");
					while(!stack.empty())
						stack.pop();
					out.clear();
				}
				writer.printf("\n");
			}
		} catch(IOException ioex){}
	}
}
