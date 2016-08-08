package math.fundamentals;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://www.hackerrank.com/challenges/find-point
 * 
 * Assunto
 * 
 * O termo que parece certo na geometria eh Point reflection
 * https://en.wikipedia.org/wiki/Point_reflection
 * 
 * interessante
 * http://www.ditutor.com/vec/symmetric_point.html
 * 
 * http://math.stackexchange.com/questions/639605/finding-the-symmetry-of-points
 * http://www.mathsisfun.com/geometry/symmetry-point.html
 * 
 * Problem
 * https://www.hackerrank.com/challenges/find-point
 * DONE
 * */

public class FindPoint {

	/*
	 * java static method nested class only static class
	 * http://stackoverflow.com/questions/975134/why-cant-we-have-static-method-in-a-non-static-inner-class
	 * */
	class Point2D {
		int x, y;
		
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return String.format("%d %d", this.x, this.y);
		}
		
		public Point2D symmetricPoint(Point2D b) {
			Point2D p = null;
			Point2D a = this;
			// p sera o ponto simetrico relacionado aos pontos a e b
			// se p eh o ponto simetrico, b eh o ponto medio no segmento
			// a b p
			int x = b.x - a.x + b.x;
			int y = b.y - a.y + b.y;
			p = new Point2D(x,y);
			return p;
		}
		
		public Point2D symmetric(Point2D b) {
			// Tem a formula marota, 2b - a
			Point2D p = null;
			Point2D a = this;
			p = minus(a, multiply(2, b));
			return p;
		}
		
		public Point2D multiply(int c, Point2D a) {
			return new Point2D(c * a.x, c * a.y);
		}
		
		public Point2D minus(Point2D a, Point2D b) {
			return new Point2D(b.x - a.x, b.y - a.y);
		}
	}
	
	public static void runTest() {
		FindPoint ref = new FindPoint();
		Point2D a,b;
		a = ref.new Point2D(7, 4);
		b = ref.new Point2D(3, -11);
		System.out.println(a.symmetricPoint(b));
		System.out.println(a.symmetric(b));
		a = ref.new Point2D(4, -2);
		b = ref.new Point2D(2, 6);
		System.out.println(a.symmetricPoint(b));
		System.out.println(a.symmetric(b));
	}
	

	public static void solver() {
		InputStream in = new BufferedInputStream(System.in, 2048);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		FindPoint ref = new FindPoint();
		PrintWriter out = new PrintWriter(System.out, true);
		try {
			String enter = buffer.readLine();
			int n = Integer.parseInt(enter);
			while(n>0) {
				enter = buffer.readLine();
				StringTokenizer token = new StringTokenizer(enter, " ");
				int x1 = Integer.parseInt(token.nextToken());
				int y1 = Integer.parseInt(token.nextToken());
				int x2 = Integer.parseInt(token.nextToken());
				int y2 = Integer.parseInt(token.nextToken());
				Point2D a = ref.new Point2D(x1, y1);
				Point2D b = ref.new Point2D(x2,y2);
				out.printf("%s\n", a.symmetric(b));
				n--;
			}
		} catch(IOException ioex) {
			
		}	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runTest();
		//solver();
	}

}
