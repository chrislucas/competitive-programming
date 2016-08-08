package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class TimeConversion {

	// https://www.hackerrank.com/challenges/time-conversion
	// DONE
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			String[] hour = reader.readLine().split(":");
			int h = Integer.parseInt(hour[0]);
			int m = Integer.parseInt(hour[1]);
			int s = Integer.parseInt(hour[2].substring(0, 2));
			
			String period = hour[2].substring(2);
			if( (h < 12 && period.equals("PM"))|| (h > 11 && period.equals("AM")) ) {
				h = (h + 12) % 24;
			}
			writer.printf("%02d:%02d:%02d", h, m, s);
		} catch(IOException ioex) {}
	}

}
