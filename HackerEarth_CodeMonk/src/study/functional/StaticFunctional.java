package study.functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaticFunctional {

	/**
	 * Teste de iteracao sobre elementos de um List
	 * estudando o forEach
	 * */
	
	static List<Integer> iterateListFunctional() {
		Random random = new Random();
		int li = 1, ls = 80, limit = 100;
		Integer array [] = new Integer [limit];
		for(int i=0; i<limit; i++) {
			array[i] = random.nextInt(ls - li) + li;
		}
		List<Integer> list = Arrays.asList(array);
		/*
		list.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer i) {}
		});
		*/
		// list.forEach((Integer i) -> {System.out.println(i);});
		// list.forEach(i->System.out.println(i));
		// list.forEach(System.out::println);
		list.forEach(i -> System.out.printf("%d %s\n", i, isPrime(i) ? "primo" : "nao primo"));
		return list;
	}
	
	static <T> void printStreamInterface(Stream<T> list) {
		list.forEach(System.out::println);
		return;
	}
	
	/**
	 * Teste da interface Stream e do que ela pode proporcionar
	 * */
	static void learnStreams(List<Integer> list) {
		Stream<Integer> primes = list
				.stream()
				.filter( i -> isPrime(i));
		
		// Set<Integer> set = primes.collect(Collectors.toSet());
		
		printStreamInterface(primes);
		return;
	}
	
	static Boolean isPrime(Integer n) {
		int limit = (int)Math.sqrt(n);
		if( (n > 2 && n % 2 ==0) || (n > 3 && n % 3==0) || (n > 5 && n % 5 ==0))
			return false;
		for(int i=7; i<=limit; i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		learnStreams(iterateListFunctional());
		//System.out.printf("%d %s\n", 49, isPrime(49) ? "primo" : "nao primo");
	}

}
