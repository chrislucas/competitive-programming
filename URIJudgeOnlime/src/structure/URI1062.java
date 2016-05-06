package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * DONE
 * 
 * */

public class URI1062 {

	
	public static void sol2() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		String quantity;
		ArrayList<Integer> out;
		Stack<Integer> stack;
		try {
			while( ! (quantity = buffer.readLine()).equals("0")  ) {
				int n = Integer.parseInt(quantity);
				String setNumbers;
				StringTokenizer tokenizer;
				while( ! (setNumbers = buffer.readLine()).equals("0") ) {
					out = new ArrayList<>();
					stack = new Stack<>();
					tokenizer = new StringTokenizer(setNumbers, " ");
					while(tokenizer.hasMoreTokens()) {
						out.add(Integer.parseInt(tokenizer.nextToken()));
					}
					int count = n;
					ListIterator<Integer> it = out.listIterator(out.size());
					//Iterator<Integer> it = out.iterator();
					while(it.hasPrevious()) {
						int i = it.previous();
						if(i == count) {
							count--;
						} else {
							stack.push(i);
						}
						while(!stack.empty()) {
							if(stack.peek() == count) {
								stack.pop();
								count--;
							} else {
								break;
							}
						}
					}
					while(!stack.empty()) {
						if(stack.peek() == count) {
							stack.pop();
							count--;
						} else {
							break;
						}
					}
					writer.printf("%s\n", stack.empty() ? "Yes" : "No");
				}
				writer.printf("\n");
			}
		} catch(IOException ioex){}
	}
	
	public static void main(String[] args) {
		sol1();
	}
	
	public static void sol1() {
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
				while( ! (setNumbers = buffer.readLine()).equals("0") ) {
					tokenizer = new StringTokenizer(setNumbers, " ");
					out = new ArrayList<>();
					while(tokenizer.hasMoreTokens()) {
						out.add(Integer.parseInt(tokenizer.nextToken()));
					}
					int acc = n;
					for(int i=out.size()-1; i>=0; i--) {
						int x = out.get(i);
						if(acc == x) {
							acc--;
						}
						else {
							stack.add(x);
						}
						//if( ! stack.empty() ) {
							while( ! stack.empty()  && stack.peek() == acc) {
								acc--;
								stack.pop();
							}
						//}
					}
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
