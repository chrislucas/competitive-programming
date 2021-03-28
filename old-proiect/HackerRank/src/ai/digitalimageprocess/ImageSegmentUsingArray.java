package ai.digitalimageprocess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/*
 * https://www.hackerrank.com/challenges/dip-image-segmentation-1
 * */
public class ImageSegmentUsingArray {

	public static int grid [][];
	public static int limX, limY;
	public static int visited[][];
	public static int X [] = {1,-1,0,0};
	public static int Y [] = {0,0,1,-1};
	
	public static boolean validate(int x, int y) {
		if(x >= limX || y >= limY || x < 0 || y < 0)
			return false;
		else if(grid[x][y] == 0 || visited[x][y] > 0)	// background ou ja visitado
			return false;
		return true;
	}
	
	public static ArrayList<int []> neighbours(int x, int y) {
		ArrayList<int []> points = new ArrayList<>();
		for(int i=0; i<X.length; i++) {
			if( validate(x+X[i], y+Y[i]) )
				points.add(new int[] {x+X[i], y+Y[i]});
		}
		return points;
	}
	
	public static void init() {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		try {
			grid = new int[4][12];
			visited = new int[4][12];
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
	
	public static void dfsGrid(int i, int j, int component) {
		visited[i][j] = component;
		ArrayList<int []> points = neighbours(i, j);
		for(int [] point : points) {
			int x = point[0], y = point[1];
			dfsGrid(x, y, component);
		}
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
	
	public static void main(String[] args) {
		run();
	}
}
