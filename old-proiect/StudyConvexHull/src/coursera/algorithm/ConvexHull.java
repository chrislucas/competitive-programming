package coursera.algorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


public class ConvexHull {
	
	public static class Point2D {
		private double x, y;
		public static final Comparator<Point2D> By_Y_ASC  		= new OrderByYAxis();
		public static final Comparator<Point2D> BY_YX 			= new OrderByYX();
		
		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Point2D(){}
		
		public static class OrderByPolarAngle implements Comparator<Point2D> {
			
			private Point2D origin;
			
			public OrderByPolarAngle(Point2D p0) {
				this.origin = p0;
			}
			
			@Override
			public int compare(Point2D p, Point2D q) {
				return orderPolarAngle2(p, q);
			}
			
			private int orderPolarAngle2(Point2D p, Point2D q) {
				int orientation = orientation(origin, p, q);
				if(orientation == 0) {
					double x1 = (origin.x - p.x), y1 = (origin.y - p.y);
					double x2 = (origin.x - q.x), y2 = (origin.y - q.y);
					return ((int)(x1*x1 + y1*y1)) - ((int)(x2*x2 + y2*y2));		// quadrado da distancia euclidiana
				}
				return orientation;
			}
			
			@SuppressWarnings("unused")
			private int orderPolarAngle3(Point2D p, Point2D q) {
				double dpx = p.x - origin.x;
				double dpy = p.y - origin.y;
				double dqx = q.x - origin.x;
				double dqy = q.y - origin.y;
				
				if(compareValues(dpy, dqy) < 0) {
					return -1;
				} else if(compareValues(dqy, dpy) < 0) {
					return 1;
				} else if(compareValues(dpy, dqy) == 0){
					if(compareValues(dpx, dqx) < 0)
						return -1;
					else if(compareValues(dqx, dpx) < 0)
						return 1;
					return 0;
				}
				return -orientation(origin, p, q);
			}
		}	
		// funcoes para coordenadas polares
		// https://pt.wikipedia.org/wiki/Coordenadas_polares
		
		/**
		 * Sistema de coord. polar é um sistema de coord. bidimensional
		 * cada ponto no plano e determinado pela sua distância a partir do ponto fixo ( de origem )
		 * e o ângulo em relação a uma direção fixa (uma reta podendo ser o eixo das ordenadas ou abscissas)
		 * 
		 * Ponto fixo semelhante a origem de um sistema cartesiano eh denominado pólo
		 * O raio a partir do pólo numa determinada direção e denominado eixo polar
		 * A distância entre o pólo e o ponto determinado e denominado coordenada radial ou raio
		 * O ângulo denominado coordenada angular ou angulo Polar
		 * */
		/**
		 * Sobrepondo o plano polar com o plano cartesiano podemos identificar que
		 * x = r * cos(theta)
		 * y = r * cos(theta)
		 * onde 'r' e a distancia do polo a um ponto
		 * e theta e o angulo formado a partir de 2 segmentos de reta
		 * 1: polo e outro ponto
		 * 2: um segmento de reta qualquer
		 * */
		public double radialCoordenate() {
			double r = Math.sqrt(x*x + y*y); 
			return r;
		}
		
		// http://www.guj.com.br/t/calcular-angulo-entre-dois-pnotos/283029/17
		// θ: o ângulo formado entre o segmento de reta que une esse ponto à origem e o eixo x, também chamado ângulo
		public double theta() {
			return Math.atan2(y, x);
		}
		
		// fim funcoes de coordenadas polares
		
		public double angle(Point2D that) {
			double dx = that.x - this.x;
			double dy = that.y - this.y;
			return Math.atan2(dy, dx);
		}
		
		public double sqrtEuclidiantDistance(Point2D that) {
			double x = this.x - that.x, y = this.y - that.y;
			return x*x + y*y;	
		}
		
		public double euclidianDistance(Point2D that) {
			double x1 = this.x, x2 = that.x, y1 = this.y, y2 = that.y;
			return Math.hypot(x2 - x1, y2 - y1);	
		}
		
		public static double distance(Point2D a, Point2D b) {
			double x1 = a.x, x2 = b.x, y1 = a.y, y2 =b.y;
			return Math.hypot(x2 - x1, y2 - y1);
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
				
		private static class OrderByYX implements Comparator<Point2D> {
			@Override
			public int compare(Point2D p, Point2D q) {
				int cy = compareValues(p.y, q.y);
				if(cy == 0) {
					return compareValues(p.x, q.x);
				}
				return cy;
			}
		}
		
	}
	
	public static int pointMinY(Point2D[] points) {
		Point2D aux = points[0];
		double minY = aux.y;
		int idx = 0;
		for(int i=1; i<points.length; i++) {
			if(minY > points[i].y) {
				minY = points[i].y;
				idx  = i;
			}
		}
		return idx;
	}
	
	/*
	 * = 0 - a,b,c pontos sao colineares
	 * > 0 - sentido horario
	 * < 0 - sentido anti-horario  ccw
	 * ver em http://www.geeksforgeeks.org/orientation-3-ordered-points/ sobre slope (inclinacao horizontal)
	 * */
	public static int orientation(Point2D a, Point2D b, Point2D c) {
		int value = (int)((b.y - a.y) * (c.x - b.x) ) - (int)((b.x - a.x) * (c.y - b.y));
		return value;
	}
	
	public double area2(Point2D a, Point2D b, Point2D c) {
		return 0.0;
	}
	
	public double areaDet(Point2D a, Point2D b, Point2D c) {
		// usando determinante a area de um triangulo
		// dado 3 pontos e calculada pela seguinte formular A = (1/2) * | Det |
		double area = ( a.x * b.y);
		return area;
	}
	
	public static void swap(Point2D [] array, int a, int b) {
		Point2D aux;
		aux = array[b];
		array[b] = array[a];
		array[a] = aux;
	}
	
	// graham Scan
	public static Stack<Point2D> convex(Point2D[] points) {
		int qPoints = points.length;
		swap(points, 0, pointMinY(points));
		Point2D p0 = points[0];
		//Arrays.sort(points, Point2D.BY_YX);
		Comparator<Point2D> BY_POLAR_ANG = new Point2D.OrderByPolarAngle(p0);
				//new Point2D().new OrderByPolarAngle(p0);
		Arrays.sort(points, 1, qPoints, BY_POLAR_ANG);
		// pilha de pontos que serao incluso no feixo convexo (convex hull)
		Stack<Point2D> stack = new Stack<>();
		stack.push(p0);
		
		int ka = 1;
		while (ka < qPoints) {
			if( p0.x != points[ka].x && p0.y != points[ka].y)
				break;
			ka++;
		}
		
		if(ka == qPoints-1)
			return stack;
		
		int kb = ka + 1;
		while(kb < qPoints) {
			if(orientation(p0, points[ka], points[kb]) != 0)
				break;
		}
		stack.push(points[kb-1]);
		
		for(int i=kb; i<qPoints; i++) {
			Point2D top  = stack.pop();		// topo da pilha
			Point2D sTop = stack.peek();	// primeiro elemento antes do topo a pilha
			while(orientation(sTop, top, points[i]) <= 0) {
				stack.pop();
			}
			stack.push(top);
			stack.push(points[i]);
		}
		return stack;
	}
		
	// http://algs4.cs.princeton.edu/99hull/GrahamScanNondegenerate.java.html
	public static Stack<Point2D> convexHull(Point2D[] points) {
		Stack<Point2D> S = new Stack<>();
		int qPoints = points.length;
		swap(points, 0, pointMinY(points));
		Point2D p0 = points[0];
		Comparator<Point2D> BY_POLAR_ANG = new Point2D.OrderByPolarAngle(p0);
		Arrays.sort(points, 1, qPoints, BY_POLAR_ANG);
		S.push(p0);
		S.push(points[1]);
		
		for(int i=2; i<qPoints; i++) {
			Point2D top = S.pop();
			while(!S.empty() && orientation(S.peek(), top, points[2]) < 1) {
				top = S.pop();
			}
			S.push(top);
			S.push(points[i]);
		}
		return S;
	}

	public static void main(String[] args) {
		Point2D [] points = {
			 new Point2D(0, 3)
			,new Point2D(1, 1)
			,new Point2D(2, 2)
			,new Point2D(4, 4)
            ,new Point2D(0, 0)
            ,new Point2D(1, 2)
            ,new Point2D(3, 1)
            ,new Point2D(3, 3)
        };
		Stack<Point2D> S = convexHull(points);
		while(!S.empty()) {
			Point2D p = S.pop();
			System.out.printf("%f %f\n", p.x, p.y);
		}

	}

}
