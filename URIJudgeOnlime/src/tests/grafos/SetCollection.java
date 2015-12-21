package tests.grafos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Tutoriais
 * https://docs.oracle.com/javase/tutorial/collections/implementations/set.html
 * http://tutorials.jenkov.com/java-collections/sortedmap.html
 * https://docs.oracle.com/javase/7/docs/api/java/util/SortedSet.html
 * http://beginnersbook.com/2013/12/treeset-class-in-java-with-example/
 * http://www.devmedia.com.br/conjuntos-classificados-sortedset-em-java-gerando-jogos-para-mega-sena/26430
 * */

public class SetCollection {
	
	
	public static Set<ArrayList<Integer>> setA = new HashSet<>();
	public static Set<Integer[]> setB = new TreeSet<>();
	public static Set<ArrayList<Integer>> setC = new LinkedHashSet<>();
	public static Random random = new Random();
	
	public static SortedSet<ArrayList<Integer>> setD = new TreeSet<>();
	
	public static void addSet(ArrayList<Integer> setInteger) {
		setA.add(setInteger);
		Integer[] array = setInteger.toArray(new Integer[setInteger.size()]);
		//setB.add(array);
		//setB.add(arrayListToArray(setInteger, setInteger.getClass()));
		setC.add(setInteger);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] arrayListToArray(ArrayList<?> setInteger, Class<?> clazz) {
		T[] array = (T[])(new Object[setInteger.size()]/*Array.newInstance(clazz, setInteger.size())*/);
		for(int i=0; i<setInteger.size(); i++) {
			array[i] = (T) setInteger.get(i);
		}
		return array;
	}
	
	public static ArrayList<Integer> createSet() {
		ArrayList<Integer> set = new ArrayList<>();
		int li = 3, ls = 10;
		int q = random.nextInt(ls - li) + li;
		for(int j=0; j<q; j++) {
			set.add(random.nextInt(1500) + 150);
		}
		return set;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			addSet(createSet());
		}
	}

}
