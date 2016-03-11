package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

// https://www.hackerrank.com/challenges/polar-angles/forum

public class PolarAngles {
	static class Point2D {
		double x, y;
		public Point2D() {}
		
		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public static double getAngle(Point2D a, Point2D b) {
			double dx = a.x - b.x;
			double dy = a.y - b.y;
			// distancia euclidinana
			//double r = Math.sqrt(dx * dx + dy * dy);
			double angle = Math.atan2(dy, dx);
			return angle < 0 ? angle + 2 * Math.PI : angle;
		}
		
		private static boolean almostEquals(double a, double b) {
			double eps = 10e-6;
			if(Math.abs(a-b) < eps)
				return true;
			return false;
		}
		
		public static int compareValues(double a, double b) {
			if(almostEquals(a, b))
				return 0;
			return ((int)a-(int)b);
		}
	}
	
	private static class SortByPolarAngle implements Comparator<Point2D> {
		private Point2D origin;
		public SortByPolarAngle(Point2D origin) {
			this.origin = origin;
		}

		@Override
		public int compare(Point2D a, Point2D b) {
			double angleA = Point2D.getAngle(a, origin)*180/Math.PI;
			double angleB = Point2D.getAngle(b, origin)*180/Math.PI;
			return Point2D.compareValues(angleA, angleB);
		}		
	}
	
	public static void sortByPolarAngle(Point2D [] points) {
		SortByPolarAngle spa = new SortByPolarAngle(new Point2D(0,0));
		Arrays.sort(points, 0, points.length, spa);
		PrintWriter print = new PrintWriter(new OutputStreamWriter(System.out), true);
		for(Point2D p : points) {
			print.printf("%.0f %.0f\n", p.x, p.y);
		}
		return;
	}
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String [] enter;
		try {
			int n = Integer.parseInt(buffer.readLine());
			Point2D [] points = new Point2D[n];
			for(int i=0; i<n; i++) {
				enter = buffer.readLine().split(" ");
				double a = Double.parseDouble(enter[0]);
				double b = Double.parseDouble(enter[1]);
				points[i] = new Point2D(a, b);
			}
			sortByPolarAngle(points);
		} catch(IOException ioex){}
	}
}
