package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 * https://en.wikipedia.org/wiki/Pick%27s_theorem
 * https://www.hackerrank.com/contests/infinitum13/challenges/integral-points
 * https://pt.wikipedia.org/wiki/Teorema_de_Pick
 * http://jwilson.coe.uga.edu/EMAT6680Fa05/Schultz/6690/Pick/Pick.htm
 * */

public class PickTheorem {

	static class Point {
		long x,y;
		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
				
		static long boundaryPoints(Point a, Point b) {
			long x = (a.x-b.x) > 0 ? (a.x-b.x) : -(a.x-b.x);
			long y = (a.y-b.y) > 0 ? (a.y-b.y) : -(a.y-b.y);
			long n = x > y ? gdc(x,y)  : gdc(y,x); 
			return n+1;
		}
		
		static long pickTheorem(Point a, Point b, Point c) {
			long area = area(a, b, c);
			// pontos nas extremidades
			long bp = -3;
			bp += boundaryPoints(a,b) + boundaryPoints(b,c) + boundaryPoints(a,c);		
			// formula : area = i + (b/2) - 1
			long i = (area  - bp + 2)/2;
			return i;
		}
		
		// heron
		static long areaTriangle(Point a, Point b, Point c) {
			long x = a.x-b.x, y = a.y-b.y;
			long ab = (long)Math.sqrt(x*x+y*y);
			x = b.x-c.x; y = b.y-c.y;
			long bc = (long)Math.sqrt(x*x+y*y);
			x = a.x-c.x; y = a.y-c.y;
			long ac = (int)Math.sqrt(x*x+y*y);
			// semiperimetro
			long sp = (ab+bc+ac)/2;
			long area = (long)Math.sqrt( (sp*(sp-ab)*(sp-bc)*(sp-ac)) );
			return area;
		}
		static long area(Point a, Point b, Point c) {
			long ans = Math.abs(a.x *(b.y-c.y) + b.x * (c.y-a.y) + c.x*(a.y-b.y));
			return ans;
		}
		
		public static long gdc(long a, long b) {
			while(b > 0 && a%b!=0) {
				long mod = a % b;
				a = b;
				b = mod;
			}
			return a;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String enter;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		StringTokenizer token;
		int n;
		Point a, b, c;
		n = Integer.parseInt(reader.readLine());
		while(n>0) {
			enter = reader.readLine();
			token = new StringTokenizer(enter, " ");
			a = new Point(Long.parseLong(token.nextToken()), Long.parseLong(token.nextToken()));
			b = new Point(Long.parseLong(token.nextToken()), Long.parseLong(token.nextToken()));
			c = new Point(Long.parseLong(token.nextToken()), Long.parseLong(token.nextToken()));
			writer.printf("%d", Point.pickTheorem(a,b,c));
			n--;
		}
		//System.out.println(Point.pickTheorem(new Point(0,0), new Point(0,2), new Point(2,0)));
		//System.out.println(Point.pickTheorem(new Point(0,0), new Point(3,0), new Point(0,3)));
	}
}
