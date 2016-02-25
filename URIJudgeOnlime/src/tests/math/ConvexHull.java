package tests.math;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class ConvexHull {
	
	public static class Point2D {
		private double x, y;
		public static final Comparator<Point2D> By_Y_ASC  = new OrderByYAxis();
		public static final Comparator<Point2D> By_YX_ASC = new OrderByYXAxes();
		
		
		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public static double distance(Point2D a, Point2D b) {
			double x1 = a.x, x2 = b.x, y1 = a.y, y2 =b.y;
			return Math.hypot(x2 - x1, y2 - y1);
			//return Math.sqrt( (x2-x1) * (x2-x1) + (y2-y1) * (y2-y1) );
		}
		
		// square euclidian distance
		public static double sqrEuclidianDistance(Point2D a, Point2D b) {
			double x = b.x - a.x, y = b.y - a.y;
			return x*x + y*y;
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
			return (int) (a-b);
		}
		
		private static class OrderByYAxis implements Comparator<Point2D> {
			@Override
			public int compare(Point2D p, Point2D q) {
				return compareValues(p.y, q.y);
			}
		}
		
		private static class OrderByYXAxes implements Comparator<Point2D> {
			@Override
			public int compare(Point2D p, Point2D q) {
				// se y1 e y2 sao iguals
				int comp = compareValues(p.y, q.y);
				if(comp == 0) {
					// ordenrar pelo menor x
					return compareValues(p.x, q.x);
				}
				return comp;
			}
		}
		
	}
	
	public static class Segment {
		Point2D p, b;
		public Segment(Point2D p, Point2D b) {
			this.p = p;
			this.b = b;
		}
	}
	
	public static class OrderByPolarAngle implements Comparator<Point2D> {
		private Point2D pivot; 
		public OrderByPolarAngle(Point2D pivot) {
			this.pivot = pivot;
		}
		@Override
		public int compare(Point2D p, Point2D q) {
			return comparePoints(p, q);
		}
		// essa maneira de comparar pelo angulo polar do ponto p e q
		// foi retirada do livro competitive programming
		private int comparePoints(Point2D p, Point2D q) {
			return 0;
		}
	}
	
	/**
	 * http://www.geeksforgeeks.org/check-if-two-given-line-segments-intersect/
	 * Orientation of a ordered tree points in a plane cam be: 
	 * counterclockwise
	 * clockwise
	 * colinear
	 * 
	 * Two segments A(p1,q1); B(p2,q2) (p and q are points of this segments)
	 * intersect if and only if one of the following two conditions is verified
	 * 
	 * Orientation Of tree points
	 * http://www.geeksforgeeks.org/orientation-3-ordered-points/
	 * 1) General Case
	 * (p1, q1, p2) and (p1, q1, q2) have different orientation and
	 * (p2, q2, p1) and (p2, q2, q2) have different orientation
	 * 
	 * 2) special case
	 * (p1, q1, p2), (p1, q1, q2), (p2, q2, p1) and (p2, q2, q2) are colinear
	 * */
	
	// verifica se o Ponto 'B(x,y)' esta entre o segmento AC
	public static boolean isOnSegment(Point2D a, Point2D b, Point2D c) {
		if( b.x <= Math.max(a.x, c.x) && b.x >= Math.min(a.x, c.x) &&
			b.y <= Math.max(a.y, c.y) && b.y >= Math.min(a.y, c.y))
			return true;
		return false;
	}
	
	public static Point2D next(Stack<Point2D> S) {
		Point2D fst = S.peek();
		S.pop();
		Point2D snd = S.peek();
		S.pop();
		S.push(fst);
		return snd;
	}
	
	// segment line S'(a,b) S''(c,d)
	public static boolean doIntersect(Point2D a, Point2D b, Point2D c, Point2D d) {
		int o1 = orientation(a, b, c);
		int o2 = orientation(a, b, d);
		int o3 = orientation(c, d, a);
		int o4 = orientation(c, d, b);
		
		// general case
		if(o1 != o2 && o3 != o4)
			return true;
		
		// special cases
		if(o1 == 0 && isOnSegment(a, c, b))	// a b c are collinear and c is on same segment ab
			return true;
		if(o2 == 0 && isOnSegment(a, d, b)) // a b d are collinear and d is on same segment ab
			return true;
		if(o3 == 0 && isOnSegment(c, a, d)) // a c d are collinear and a is on same segment cd
			return true;
		if(o4 == 0 && isOnSegment(c, b, d)) // b c d are collinear and b is on same segment cd
			return true;
		return false;
	}
	
	/*
	 * 0 - a,b,c are colinear
	 * > 0 - clockwise
	 * < 0 - counterclockwise 
	 * if (a,b,c) is collinear, then orientation of (c,b,a) is collinear too
	 * if (a,b,c) os clockwise. then orientation of (c,b,a) is counterclockwise and vice versa
	 * */
	static int orientation(Point2D a, Point2D b, Point2D c) {
		//int slopeA = ((b.y - a.y) /(b.x - a.x));
		//int slopeB = ((c.y - b.y) /(c.x - b.x));
		// (b.x - a.x) * (c.y - b.y)
		int value = (int)((b.y - a.y) * (c.x - b.x) ) - (int)((c.y - b.y) * (b.x - a.x));
		return value;
	}



	public static void main(String[] args) {
		Point2D [] points = {
			/*
			 new Point2D(0,3)
			,new Point2D(1,1)
			,new Point2D(2,2)
			,new Point2D(4,4)
			,new Point2D(0,0)
			,new Point2D(1,2)
			,new Point2D(3,1)
			,new Point2D(3,3)
			 */
				
			 new Point2D(0, -1)
			,new Point2D(10, -2)
			,new Point2D(5,-2)
			,new Point2D(3,-2)
		};

		Stack<Point2D> convex = convexHull(points);
		while( ! convex.isEmpty()) {
			Point2D p = convex.pop();
			System.out.println(p.toString());
		}
	}
	
	
	public static Stack<Point2D> convexHull(Point2D [] points) {
		
		// encontrar o ponto com menor y, se o houver mais de 1 ponto cujo
		// menor valor de y for igual, comparar pegar o pnnto cujo valor x eh o menor
		Point2D p0 = points[0];
		for(int i=1; i<points.length; i++) {
			Point2D aux = points[i];
			int cmp = Point2D.compareValues(aux.y, p0.y);
			if(cmp == 0) {
				cmp = Point2D.compareValues(aux.x, p0.x);
				if(cmp < 0) {
					p0 = aux;
				}
			} else if(cmp < 0){
				p0 = aux;
			}
		}
		
		Comparator<Point2D> BY_POLAR_ANG = new OrderByPolarAngle(p0);
		
		// O algoritmo eh divido em duas partes
		// 1 - ordenar os pontos em ordem crescente em rela��o a Y e X
		//Arrays.sort(points, Point2D.By_YX_ASC);
		Arrays.sort(points, 1, points.length, BY_POLAR_ANG);
		
		// uma vez ordenados vem a parte 2
		// 2 - escolher os pontos que ser�o inclusos no feixo convexo
		// Os 2 primeirps pontos do vetor ordenado ja estao inclusos no feixo convexo
		// Usando da tecnica de orientacao, pegamos os 2 primeiros pontos (p, q) e o
		// proximo no vetor (ponto n) se a orientacao de (p q n ou [0,1,2]) nao 
		// for antihorario, descartamos n(2) e partimos para os proximos 3 pontos
		// [1,2,3], e assim por diante
		
		
		int qPoints = 1, n = points.length;
		for(int i=1; i<n; i++) {
			while( i<n-1 && orientation(p0, points[i], points[i+1]) == 0)
				i++;
			points[qPoints] = points[i];
			qPoints++;
		}
		// se apos a busca por pontos, menos de 3 foram incluidos
		// no feixo convexo, entao nao eh possivel formar um feixo convexo
		if(qPoints < 3 )
			return null;
		
		Stack<Point2D> S = new Stack<>();
		S.push(points[0]);
		S.push(points[1]);
		S.push(points[2]);
		Point2D current;
		for(int i=3; i<qPoints; i++) {
			current = points[i];
			while(orientation(next(S), S.peek(), current) <= 0) {
				S.pop();
			}
			S.push(current);
		}
		return S;
	}
/*	
	private static void testIsIntersetct() {
		Point2D p1, p2, q1, q2;
		p1 = new Point2D(1, 1);
		q1 = new Point2D(10, 1);
		p2 = new Point2D(1, 2);
		q2 = new Point2D(10, 2);
		System.out.println(doIntersect(p1, q1, p2, q2) ? "S" : "N");
		p1 = new Point2D(10,0);
		q1 = new Point2D(0,10);
		p2 = new Point2D(0,0);
		q2 = new Point2D(10, 10);
		System.out.println(doIntersect(p1, q1, p2, q2) ? "S" : "N");
		p1 = new Point2D(-5,-5);
		q1 = new Point2D(0,0);
		p2 = new Point2D(1,1);
		q2 = new Point2D(10, 10);
		System.out.println(doIntersect(p1, q1, p2, q2) ? "S" : "N");
		p1 = new Point2D(-5,-5);
		q1 = new Point2D(3,3);
		p2 = new Point2D(2,2);
		q2 = new Point2D(10, 10);
		System.out.println(doIntersect(p1, q1, p2, q2) ? "S" : "N");
		p1 = new Point2D(-5,-5);
		q1 = new Point2D(0,0);
		p2 = new Point2D(-2,-2);
		q2 = new Point2D(10, 0);
		System.out.println(doIntersect(p1, q1, p2, q2) ? "S" : "N");
	}
	

	private static void testMethodOrientation() {
		Point2D [] points = {
			 new Point2D(0, 0)
			,new Point2D(2, 4)
			,new Point2D(4, 4)
			,new Point2D(1, 2)
		};
		int o = orientation(points[0], points[2], points[3]);
		System.out.println( o > 0 ? (o == 0 ? "colinear" : "horario") : "antihorario");
	}
*/
}
