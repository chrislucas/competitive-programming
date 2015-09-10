package math;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FindPoint {

	
	public static int[] simmetricPoint(int xa, int ya, int xb, int yb) {
		int[] point = new int [2];
		// qual o ponto simetrico de um SEGMENTO AB ?
		// Um ponto C onde no SEGMENTO AC, o ponto B e o ponto do meio
		// entao B eh (x1+x2)/2 (y1+y2)/2
		// porem C(x2,y2), o que queremos descobrir, logo
		point[0] = 2 * xb - xa;
		point[1] = 2 * yb - ya;
		return point;
	}
	
	public static void main(String[] args) {
		int x1, y1, x2, y2, sx, sy;
		InputStream in = new BufferedInputStream(System.in, 2048);
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		PrintWriter out = new PrintWriter(System.out, true);
		try {
			String enter = buffer.readLine();
			int n = Integer.parseInt(enter);
			while(n>0) {
				enter = buffer.readLine();
				StringTokenizer token = new StringTokenizer(enter, " ");
				x1 = Integer.parseInt(token.nextToken());
				y1 = Integer.parseInt(token.nextToken());
				x2 = Integer.parseInt(token.nextToken());
				y2 = Integer.parseInt(token.nextToken());
				//sx = x2 + (x2 - x1);
				//sy = y2 + (y2 - y1);
				int [] point = simmetricPoint(x1, y1, x2, y2);
				out.printf("%d %d\n", point[0], point[1]);
				n--;
			}
		} catch(IOException ioex) {
			
		}	
	}
}
