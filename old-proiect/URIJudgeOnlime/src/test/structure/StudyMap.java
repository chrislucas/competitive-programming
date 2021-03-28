package test.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StudyMap {

	static Map<String, Integer> map;
	
	static {
		map = new HashMap<>();
		Random random = new Random();
		int li = 1, ls = 9;
		for(int i=0; i<40; i++) {
			int rd = random.nextInt(ls - li) + li;
			StringBuilder builder = new StringBuilder();
			for(int j=1; j<rd; j++) {
				char c = (char) (random.nextInt(97 - 65) + 65);
				builder.append(c);
			}
			addMap(builder.toString());
		}
	}
	
	static void addMap(String str, Integer value) {
		if(map.containsKey(str)) {
			map.put(str, map.get(str) + 1);
		} else {
			map.put(str, value);
		}
	}
	
	static void addMap(String str) {
		addMap(str, 0);
	}
	
	
	public static void main(String[] args) {
		

	}

}
