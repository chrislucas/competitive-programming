package study.data_strucuture.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * http://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
 * */

public class StudyMap {

	public static char [] alpha = new char[52];
	
	public static void setAlpha() {
		for(int i=97; i<97+26; i++)
			alpha[i-97] = (char) i;
		for(int i=65; i<65+26; i++)
			alpha[i-39] = (char) i;
		return;
	}
	
	public static int randomRange(int lowerbound, int upperbound) {
		Random random = new Random();
		return random.nextInt(upperbound - lowerbound) + lowerbound;
	}
	
	public static String randomWords(int size) {
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<size; i++) {
			int c = randomRange(0, alpha.length - 1);
			ans.append(alpha[c]);
		}
		return ans.toString();
	}
	
	public static Map<Integer, List<String>> fill(int sizeMap) {
		Map<Integer,List<String>> map = new HashMap<>();
		List<String> words;
		for(int i=0; i<sizeMap; i++) {
			int qWords = randomRange(1, 25);
			words = new ArrayList<>();
			for(int j=0; j<qWords; j++) {
				words.add(randomWords(15));
			}
			map.put(new Integer(i), words);
		}
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	public static <K, V> void loop(Map<K, V> map) {
		Iterator<?> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<K, V> pair = ((Map.Entry<K, V>) iterator.next());
			//Object key = pair.getKey();
			Object val = pair.getValue();
			if(isCollection(val)) {
				try {
					List<?> list = (List<?>)val;
					System.out.printf("%d\n",list.size());
					for(Object o : list) {
						System.out.println(o.toString());
					}
				} catch(ClassCastException ccex) {
					System.out.println(ccex.getMessage());
				}
			}
		}
		return;
	}
	
	public static <T> boolean isCollection(T clazz) {
		// o eh uma instancia de List
		//return Collection.class.isInstance(o);
		// a sentenca abaixo eh eqivalente a de cima
		//return o instanceof Collection;
		
		// o metodo isAssignableFrom testa se o argumento passado
		// para ele uma instacel de <T>.class
		return Collection.class.isAssignableFrom(clazz.getClass());
	}
	
	public static <T> Class getTypeClass(T object) {
		return null;
	}
	
	public static void main(String[] args) {
		setAlpha();
		loop(fill(100));
		//System.out.println(isCollection(new ArrayList<>()));
	}

}
