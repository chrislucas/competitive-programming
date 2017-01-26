package ai.digitalimageprocess;

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
	
	public static boolean is4connected(int x, int y) {
		if( ! validate(x, y) )
			return false;
		int X [] = {1,-1,0,0};
		int Y [] = {0,0,1,-1};
		int counter = 0;
		for(int i=0; i<X.length; i++) {
			if( ! validate(x+X[i], y+Y[i]) )
				return false;
		}
		return counter == 4;
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
				System.out.printf("%d %d %s", i, j, is4connected(i, j));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 127;
		System.out.println(b);
	}

}
