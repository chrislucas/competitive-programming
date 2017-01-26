package ai.digitalimageprocess;

import java.util.ArrayList;

/*
 * https://en.wikipedia.org/wiki/Connected-component_labeling
 * http://homepages.inf.ed.ac.uk/rbf/HIPR2/connect.htm
 * https://www.codeproject.com/Articles/336915/Connected-Component-Labeling-Algorithm
 * */
public class ImgSegm1 {
		
	public static byte grid [][] = {
		 {0,0,0,1,1,0,0,0,1,0,1,0}
		,{1,1,1,0,1,1,1,1,0,0,0,1}
		,{1,1,1,0,1,0,0,1,0,0,1,0}
		,{1,0,0,0,0,0,0,0,0,1,0,0}
	};
	
	public static int limX = grid.length;
	public static int limY = grid[0].length;
	
	public static boolean validate(int x, int y) {
		if(x >= limX || y >= limY || x < 0 || y < 0)
			return false;
		
		return true;
	}
	
	public static ArrayList<Point2D> is4connected(int x, int y) {
		ArrayList<Point2D> points = new ArrayList<>();
		if( ! validate(x, y) )
			return points;
		
		int X [] = {1,-1,0,0};
		int Y [] = {0,0,1,-1};

		for(int i=0; i<X.length; i++) {
			if( ! validate(x+X[i], y+Y[i]) )
				points.add(new Point2D(x+X[i], y+Y[i]));
		}
		return points;
	}
	
	public static class Point2D {
		int x, y;
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void runTest4connectivity() {
		for(int i=0; i<limX; i++) {
			for(int j=0; j<limY; j++){
				if(grid[i][j] == 0)
					continue;
				ArrayList<Point2D> points = is4connected(i, j);
				for(Point2D point : points) {
					
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
