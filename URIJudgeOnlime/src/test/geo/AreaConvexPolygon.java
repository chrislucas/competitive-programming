package test.geo;

import java.util.Comparator;


public class AreaConvexPolygon {
	
	/*
	 * = 0 - a,b,c pontos sao colineares
	 * > 0 - sentido horario
	 * < 0 - sentido anti-horario  ccw
	 * ver em http://www.geeksforgeeks.org/orientation-3-ordered-points/ sobre slope (inclinacao horizontal)
	 * */
	
	public static int orientation(Point2D a, Point2D b, Point2D c) {
		int value = (int)((b.y - a.y) * (c.x - b.x) ) - (int)((c.y - b.y) * (b.x - a.x));
		return value;
	}
	
	public static class Point2D {
		private double x, y;
		public static final Comparator<Point2D> By_Y_ASC  		= new OrderByYAxis();		
		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public Point2D(){}		
		/**
		 * funcoes para coordenadas polares https://pt.wikipedia.org/wiki/Coordenadas_polares
		 * 
		 * Sistema de coord. polar é um sistema de coord. bidimensional
		 * cada ponto no plano e determinado pela sua distância a partir do ponto fixo ( de origem )
		 * e o ângulo em relação a uma direção fixa (uma reta podendo ser o eixo das ordenadas ou abscissas)
		 * 
		 * Ponto fixo semelhante a origem de um sistema cartesiano eh denominado pólo
		 * O raio a partir do pólo numa determinada direção e denominado eixo polar
		 * A distância entre o pólo e o ponto determinado e denominado coordenada radial ou raio
		 * O ângulo denominado coordenada angular ou angulo Polar
		 * 
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
	}	// fim class Point2D
	
	
	public static double shoelace(Point2D [] points) {
		int s = points.length;
		double sum = 0.0;
		// somaorio: XiY(i+1) + XnY0
		for(int i=0; i<s-1; i++) {
			sum += points[i].x * points[i+1].y;
		}
		sum += points[s-1].x * points[0].y;
		return 0;
	}
	
}
