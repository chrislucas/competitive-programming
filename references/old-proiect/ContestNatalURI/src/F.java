import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//done
public class F {

	static class Child implements Comparable<Child> {
		String name, nameEqualCase;
		Child(String name, String nameEqualCase) {
			this.name = name;
			this.nameEqualCase = nameEqualCase;
		}
		
		@Override
		public int compareTo(Child o) {
			return this.nameEqualCase.compareTo(o.nameEqualCase);
		}
		
	}
	
	static int convertStringToInt(String  s) {
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			sum += s.charAt(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
		String enter;
		
		try {
			List<Child> childreen= new ArrayList<Child>();
			while( (enter = buffer.readLine()) != null ) {
				childreen.add(new Child(enter, enter.toUpperCase()));
			}
			Collections.sort(childreen);
			out.printf("%s\n", childreen.get(childreen.size() - 1).name);
		} catch(IOException ioex) {}
	}
}
