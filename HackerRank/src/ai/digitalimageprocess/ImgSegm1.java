package ai.digitalimageprocess;

import java.util.ArrayList;

/*
 * https://en.wikipedia.org/wiki/Connected-component_labeling
 * http://homepages.inf.ed.ac.uk/rbf/HIPR2/connect.htm
 * https://www.codeproject.com/Articles/336915/Connected-Component-Labeling-Algorithm
 * http://www.eng.tau.ac.il/~danar/Miscellaneous/rotem-project.pdf
 * */
public class ImgSegm1 {
	
	public static class Point2D {
		int x, y;
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static byte grid [][] = {
		 {0,0,0,1,1,0,0,0,1,0,1,0}
		,{1,1,1,0,1,1,1,1,0,0,0,1}
		,{1,1,1,0,1,0,0,1,0,0,1,0}
		,{1,0,0,0,0,0,0,0,0,1,0,0}
	};
	
	public static int limX = grid.length;
	public static int limY = grid[0].length;
	public static boolean visited[][] = new boolean[limX][limY];
	public static int X [] = {1,-1,0,0};
	public static int Y [] = {0,0,1,-1};
	
	public static boolean validate(int x, int y) {
		if(x >= limX || y >= limY || x < 0 || y < 0)
			return false;
		return true;
	}
	
	public static ArrayList<Point2D> neighbours(int x, int y) {
		ArrayList<Point2D> points = new ArrayList<>();
		for(int i=0; i<X.length; i++) {
			if( ! validate(x+X[i], y+Y[i]) )
				points.add(new Point2D(x+X[i], y+Y[i]));
		}
		return points;
	}
	
	public static void dfsGrid(int i, int j) {
		ArrayList<Point2D> points = neighbours(i, j);
		for(Point2D point : points) {
			int x = point.x, y = point.y;
		}
	}
	
	public static void run() {
		for(int i=0; i<limX; i++) {
			for(int j=0; j<limY; j++){
				if(grid[i][j] == 1 && !visited[i][j]) {

				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 127;
		System.out.println(b);
	}

}
