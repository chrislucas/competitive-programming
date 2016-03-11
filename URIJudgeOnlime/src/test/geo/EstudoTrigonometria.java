package test.geo;

import java.util.Arrays;
import java.util.Comparator;

public class EstudoTrigonometria {

	
	static class Point2D {
		double x, y;
		public Point2D() {}
		
		public Point2D(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getAngle(Point2D origin) {
			double dx = this.x - origin.x;
			double dy = this.y - origin.y;
			// distancia euclidinana
			//double r = Math.sqrt(dx * dx + dy * dy);
			double angle = Math.atan2(dy, dx);
			return angle < 0 ? angle + 2 * Math.PI : angle;
		}
		
		public static double getAngle(Point2D a, Point2D b) {
			double dx = a.x - b.x;
			double dy = a.y - b.y;
			// distancia euclidinana
			//double r = Math.sqrt(dx * dx + dy * dy);
			double angle = Math.atan2(dy, dx);
			return angle < 0 ? angle + 2 * Math.PI : angle;
		}
		
		public static double cross(Point2D a, Point2D b) {
			return a.x * b.y - a.y * b.x;
		}
		
		public static double dist(Point2D a, Point2D b) {
			return a.x*b.x+a.y*b.y;
		}
		
		public static double getAngle2(Point2D a, Point2D b) {
			double angle = Math.atan2(Point2D.cross(a,b), Point2D.dist(a, b));
			return angle < 0 ? angle + 2 * Math.PI : angle;
		}
		
		public static double ca(Point2D a, Point2D b) {
			return (b.y - a.y) / (b.x - a.x);
		}
		
		public static double getAngle3(Point2D a, Point2D b) {
			double m = ca(a,b);
			double angle = Math.atan2(m, 1); // or Math.atan2(b.y - a.y, b.x - a.x)
			return angle < 0 ? (angle + 2 * Math.PI) : angle;
		}
		
		// https://en.wikipedia.org/wiki/Cross_product
		// https://www.mathsisfun.com/algebra/vectors-cross-product.html
		//http://stackoverflow.com/questions/21483999/using-atan2-to-find-angle-between-two-vectors
		public double magnitude(Point2D a) {
			return a.x*a.x+a.y*a.y;
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
	
	public static void testeFuncoesInversas() {
		System.out.println("Seno e ArcoSeno de 30");
		double sin30 = Math.sin(30 * Math.PI / 180);
		System.out.println(sin30);
		double asin30 = Math.asin(sin30);
		System.out.println(asin30 * 180 / Math.PI);
		System.out.println("");
		
		System.out.println("Cosseno e Arcocosseno de 60");
		double cos60 = Math.cos(60 * Math.PI / 180);
		System.out.println(cos60);
		double acos60 = Math.acos(cos60);
		System.out.println(acos60 * 180 / Math.PI);
		System.out.println("");
		
		System.out.println("Tangente e Arcotangente sw 45");
		double tan45 = Math.tan(45 * Math.PI / 180);
		System.out.println(tan45);
		double atan45 = Math.atan(tan45);
		System.out.println(atan45 * 180 / Math.PI);
	}
	
	public static void testValueAngle() {
		Point2D o = new Point2D(0,0);
		Point2D p = new Point2D(0,-1);
		System.out.println(p.getAngle(o)*180/Math.PI);
		System.out.println(Point2D.getAngle(p, o)*180/Math.PI);
		
		// http://stackoverflow.com/questions/21483999/using-atan2-to-find-angle-between-two-vectors
		Point2D a = new Point2D(5.45, 1.12);
		Point2D b = new Point2D(-3.86, 4.32);
		a = new Point2D(0, 4);
		b = new Point2D(4, 0);
		//System.out.println(Math.atan2(Point2D.cross(a,b), Point2D.dist(a, b)) * 180/Math.PI);
		double angle = Point2D.getAngle2(b, a) * 180 / Math.PI;
		angle = angle > 180 ? 360 - angle : angle;
		System.out.println(angle);
		angle = Point2D.getAngle3(a, b) * 180 / Math.PI;
		angle = angle > 180 ? 360 - angle : angle;
		System.out.println(angle);
		/*
		a = new Point2D(0, 0);
		b = new Point2D(0, -1);
		angle = Point2D.getAngle3(a, b) * 180 / Math.PI;
		System.out.println(angle);
		*/
	}
	
	public static void sortByPolarAngle(Point2D [] points) {
		SortByPolarAngle spa = new SortByPolarAngle(new Point2D(0,0));
		Arrays.sort(points, 0, points.length, spa);
		for(Point2D p : points) {
			System.out.printf("%f %f\n", p.x, p.y);
		}
	}
	
	public static void testSortByPolarAngle() {
		Point2D [] points = {
				 new Point2D(1,0)
				,new Point2D(0,-1)
				,new Point2D(-1,0)
				,new Point2D(0,1)
			};
			sortByPolarAngle(points);
	}
	
	//https://www.hackerrank.com/challenges/polar-angles
	public static void main(String[] args) {
		//testValueAngle();
		//testeFuncoesInversas();
		//testSortByPolarAngle();
		ftg("cos");
	}
	
	public static int gdc(int a, int b) {
		while(a%b!=0) {
			int mod = a % b;
			a = b;
			b = mod;
		}
		return b;
	}
	
	public static double cotg(double med) {
		// aqui temos o problema da med
		// ser igual a 90, onde cos(90) = 0
		// ou med = 0 || med = 360, onde sin(0) e sin(360 o que acarreta numa divisao por 0
		// entao basta essa verificacao abaixo
		if(med %  180 == 0)
			return 0;
		double cos = Math.cos(med*Math.PI/180);
		double sin = Math.sin(med*Math.PI/180);
		return cos/sin ;
	}
	
	public static double cotg2(double med) {
		// tangete de 90 e 270 nao existe, ja que esss esses angulos
		// no circulo trigonometrico estão em pontos paralelos a reta
		// da tangente
		// tangente de  180 e 360 sao igaus a 0 ja que os
		// pontos desses angulos se encontram na abscissa (eixo x)
		// onde x = 0
		if(med % 180 == 90 || med % 90 == 0)
			return 0;
		double tg = Math.tan(med *  Math.PI / 180);
		return 1 / tg;
	}
	
	public static double cossec(double med) {
		// seno de 0 e 180 e 360 = 0
		// assim teriamos uma divisao por zero
		if(med %  180 == 0)
			return 0;
		return 1 / Math.sin(med*Math.PI/180);
	}
	
	public static double sec(double med) {
		// cos de 90 e 270 = 0
		// assim teriamos uma divisao por zero
		if(med == 90 || med == 270)
			return 0;
		return 1 / Math.cos(med*Math.PI/180);
	}
	
	public static void ftg(String f) {
		int acc = f.equals("tan") || f.equals("cos") ? 1 : 45;
		//System.out.println(gdc(315, 180));
		//System.out.println(45 * Math.PI / 180);
		//System.out.println(45 / 180.0 * Math.PI);
		//System.out.printf("%f %f\n", cotg(270), cotg2(360));
		
		for(int i=0; i<=360; i += acc) {
			double ans = 0.0;
			if(f.equals("sin"))
				ans = Math.sin(i % 360 * Math.PI / 180);
			else if(f.equals("cos"))
				ans = Math.cos(i % 360 * Math.PI / 180);
			else if(f.equals("tan")) {
				if(i  == 90 || i == 270)
					continue;
				ans = Math.tan(i % 360 * Math.PI / 180);
			}
			System.out.printf("%d %f\n", i, ans);
		}
		
	}


}
