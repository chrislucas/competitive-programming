package adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class URI1147 {

	static class Element {
		int x, y;
		public Element(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static Element [][] grid = new Element[8][8];
	static Element [] walks = {
		new Element(2, 1)
	};
	static Map<Character, Integer> map;
	
	public static void createMap() {
		map = new HashMap<Character, Integer>();
		map.put('a', 1);
		map.put('b', 2);
		map.put('c', 3);
		map.put('d', 4);
		map.put('e', 5);
		map.put('f', 6);
		map.put('g', 7);
		map.put('h', 8);
	}
	
	public static int get(char c) {
		return map.containsKey(c) ? map.get(c) : -1;
	}
	
	public static void run() {
		Element horse;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<8; i++) {
			try {
				String in = buffer.readLine();
				StringTokenizer tk = new StringTokenizer(in, "");
				int x = Integer.parseInt(tk.nextToken());
				int y = get(tk.nextToken().charAt(0));
				if(i==0) {
					horse = new URI1147.Element(x, y);
				}
				else {
					grid[x][y] = new Element(x, y);
				}
			} catch (IOException e) {}
		}
		
		for(Element walk : walks) {
			
		}
	}
	
	public static boolean validPath(int x, int y) {
		return x < 8 || x >= 0 && y < 8 && y >= 0;
	}
	
	public static int securityPath(int x, int y) {
		if(validPath(x, y)) {
			// verificar se a peoes que podem atacar o cavalo
			// como nesse jogo simulamos como se eu estivesse com
			// pessas brancas, o peao desse da posicao 0 a 8
			// entao verificamos 2 casas acima do cavalo, a esquerda
			int x2 = x-1, y2 = y-1  // a esquerda
			,x3 = x-1, y3 = y+1;	// a direita
			if(grid[x2][y2] == null && grid[x3][y3] == null)
				return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
