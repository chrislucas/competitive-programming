package com.br.geo;

import java.util.Comparator;



public class AreaPolygon {
	public static class Point2D {
		private double x, y;
		public static final Comparator<Point2D> By_Y_ASC  = new OrderByYAxis();
		
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
	}
	
	/**
	 * A formula de shoelace, funcioa para poligonos convexos simples
	 * onde nenhuma aresta cruza com outra, e os angulos
	 * formados pelas arestas sao <= 180 graus
	 * 
	 * shoelace {shoestring, braid} {cadarço, cordao, cordao de sapatos}
	 * https://en.wikipedia.org/wiki/Shoelace_formula
	 * */
	public static double shoelaceFormula(Point2D [] points) {
		double ans = 0.0;
		int s = points.length;
			if(s < 3)
				return ans;
		/*
		for(int i=0; i<s-1; i++)
			ans += points[i].x * points[i+1].y;
		ans += points[s-1].x * points[0].y;
		
		for(int i=0; i<s-1; i++)
			ans -= points[i+1].x * points[i].y;
		ans -= points[0].x * points[s-1].y;
		*/
	
		for(int i=0; i<s-1; i++) {
			ans += points[i].x * points[i+1].y - points[i+1].x * points[i].y;
		}
		ans += points[s-1].x * points[0].y - points[0].x * points[s-1].y;	// Xn*Y0 - X0Yn
		return ans < 0 ? -ans * 0.5 : ans * 0.5 ;
	}
	
	/*
	 * 0 - a,b,c are colinear
	 * > 0 - clockwise
	 * < 0 - counterclockwise 
	 * if (a,b,c) is collinear, then orientation of (c,b,a) is collinear too
	 * if (a,b,c) os clockwise. then orientation of (c,b,a) is counterclockwise and vice versa
	 * */
	static int orientation(Point2D a, Point2D b, Point2D c) {
		int value = (int)((b.y - a.y) * (c.x - b.x) ) - (int)((b.x - a.x) * (c.y - b.y));
		return value;
	}
	
	public static void runShoelance() {
		Point2D [] points = {
			
			 new Point2D(3,4)
			,new Point2D(5,11)
			,new Point2D(12,8)
			,new Point2D(9,5)
			,new Point2D(5,6)
			/*
			 new Point2D(2,4)
			,new Point2D(3,-8)
			,new Point2D(1,2)
			,new Point2D(2,4)
			*/
		};
		System.out.println(shoelaceFormula(points));
	}
	
	public static void main(String[] args) {
		runShoelance();
	}

}
