package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class URI1243 {
	
	static boolean isWord(String word) {
		int len = word.length();
		for(int i=0; i<len; i++) {
			char c = word.charAt(i);
			if( (c == '.' && i < (len-1))|| Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	static boolean hasDot(String word) {
		int len = word.length();
		for(int i=0; i<len; i++) {
			char c = word.charAt(i);
			if( (c == '.' && i ==(len-1)) )
				return true;
		}
		return false;
	}
	
	public static int mean(Map<Integer, Integer> map, int q) {
		int sum = 0;
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		for(;it.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			sum =  sum + key * val;
		}
		return sum / q;
	}
	
	public static void main(String[] args) {
		String text;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
		HashMap<Integer, Integer> map;
		try {
			while( (text = buffer.readLine()) != null ) {
				//int[] meanLetters = new int[51];
				map = new HashMap<>();
				StringTokenizer tokenizer = new StringTokenizer(text, " ");
				int quantityWords = 0;
				while(tokenizer.hasMoreTokens()) {
					String word = tokenizer.nextToken();
					if(isWord(word)) {
						// o ponto nao conta como letra, entao verificar
						// se a palavra tempo, se sim diminuir o tamanho da string
						int idx = hasDot(word) ? word.length() - 1 : word.length();
						if(map.containsKey(idx)) {
							int n = map.get(idx);
							map.put(idx, ++n);
						} else {
							map.put(idx, 1);
						}
						quantityWords++;
					}
				}
				int points, rs = quantityWords > 0 ? mean(map, quantityWords) : 0;
				if(rs <= 3) {
					points = 250;
				} else if(rs < 3 && rs > 6) {
					points = 500;
				} else {
					points = 1000;
				}
				writer.printf("%d\n", points);
				// map.clear();
			}
		} catch(IOException ioex) {}
	}
}
