package ai.digitalimageprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://en.wikipedia.org/wiki/Connected-component_labeling
 * https://en.wikipedia.org/wiki/Image_segmentation
 * http://homepages.inf.ed.ac.uk/rbf/HIPR2/connect.htm
 * https://www.codeproject.com/Articles/336915/Connected-Component-Labeling-Algorithm
 * http://www.eng.tau.ac.il/~danar/Miscellaneous/rotem-project.pdf
 * */
public class ImgSegm1 {
	
	public class Point2D {
		int x, y;
		public Point2D(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int grid [][] = {
		 {0,0,0,1,1,0,0,0,1,0,1,0}
		,{1,1,1,0,1,1,1,1,0,0,0,1}
		,{1,1,1,0,1,0,0,1,0,0,1,0}
		,{1,0,0,0,0,0,0,0,0,1,0,0}
	};
	
	public static byte grid2 [][] = {
		 {1,0,0,0,1}
		,{1,1,0,1,1}
		,{0,1,0,0,1}
		,{1,1,1,1,0}
		,{0,0,0,1,0}
	};
	
	public static int limX = grid.length;
	public static int limY = grid[0].length;
	public static int visited[][] = new int[limX][limY];
	
	public static int X [] = {1,-1,0,0};
	public static int Y [] = {0,0,1,-1};
	
	public static boolean validate(int x, int y) {
		if(x >= limX || y >= limY || x < 0 || y < 0)
			return false;
		else if(grid[x][y] == 0 || visited[x][y] > 0)	// background ou ja visitado
			return false;
		return true;
	}
	
	public static ArrayList<Point2D> neighbours(int x, int y) {
		ArrayList<Point2D> points = new ArrayList<>();
		for(int i=0; i<X.length; i++) {
			if( validate(x+X[i], y+Y[i]) )
				points.add(new ImgSegm1().new Point2D(x+X[i], y+Y[i]));
		}
		return points;
	}
	
	public static void dfsGrid(int i, int j, int component) {
		visited[i][j] = component;
		ArrayList<Point2D> points = neighbours(i, j);
		for(Point2D point : points) {
			int x = point.x
			,y = point.y;
			dfsGrid(x, y, component);
		}
	}
	public static void init() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			grid = new int[4][12];
			limX = grid.length;
			limY = grid[0].length;
			for(int i=0; i<4; i++) {
				String in = buffer.readLine();
				for(int j=0; j<in.length(); j++){
					grid[i][j] = (in.charAt(j) == '1' ? 1 : 0);
				}
			}
		} catch (IOException e) {}
	}
	
	public static void run() {
		init();
		int component = 0;
		for(int i=0; i<limX; i++) {
			for(int j=0; j<limY; j++){
				if(grid[i][j] == 1 && visited[i][j] == 0) {
					component++;
					dfsGrid(i, j, component);
				}
				//System.out.printf("%d ", visited[i][j]);
			}
			//System.out.println("");
		}
		System.out.printf("%d", component);
	}
	
	public static void run2() {
		Queue<Point2D> queue = new LinkedList<>();
		int component = 0;
		for(int i=0; i<limX; i++) {
			for(int j=0; j<limY; j++){
				if(grid[i][j] == 1 && visited[i][j] == 0) {
					Point2D p = new ImgSegm1().new Point2D(i, j);
					queue.add(p);
					while(!queue.isEmpty()) {
						p = queue.poll();
						visited[p.x][p.y] = ++component;
						ArrayList<Point2D> N = neighbours(p.x, p.y);
						queue.addAll(N);
					}
				}
			}
		}
		for(int i=0; i<limX; i++) {
			for(int j=0; j<limY; j++)
				System.out.printf("%d ", visited[i][j]);
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
}
