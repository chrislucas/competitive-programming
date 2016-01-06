package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class JimAndOtthers {

	static class Activity implements Comparable<Activity> {
		int order, time, duration;
		Activity(int o, int t, int d) {
			this.order = o;
			this.duration = d;
			this.time = t;
		}
		
		@Override
		public int compareTo(Activity activity) {
			return orderByDurationAndOrder(this, activity);
		}
		// ordenacao acendente por duracao do processo
		// se o tempo for igual, ordene pela ordem
		private static int orderByDurationAndOrder(Activity A, Activity B) {
			int dA = A.time + A.duration, dB = B.time + B.duration;
			int oA = A.order, oB = B.order;		
			if(dA < dB) {
				return -1;
			} else if(dA > dB) {
				return 1;
			} else {
				if(oA < oB) {
					return -1;
				} else if(oA > oB) {
					return 1;
				}
				return 0;
			}
		}
		
	}
	
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		try {
			int cases = Integer.parseInt(reader.readLine());
			ArrayList<Activity> activities = new ArrayList<>();
			for(int i=1; i<=cases; i++) {
				String[] enter = reader.readLine().split(" ");
				int t = Integer.parseInt(enter[0]);
				int d = Integer.parseInt(enter[1]);
				activities.add(new Activity(i, t, d));
			}
			Collections.sort(activities);
			for(Activity a : activities) {
				writer.printf("%d ", a.order);
			}
		} catch(IOException ioex) {}
	}
}