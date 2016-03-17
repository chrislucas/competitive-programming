package com.br.wiselabs.exercises;

import java.util.Iterator;

public class StudyIteration {

	/**
	 * What is an iterable ?
	 * it is a class that has a method that returns an iterator
	 * 
	 * What is an iterator ?
	 * is a class that has methods called  next() that return a
	 * next element into a list of elements and hasNext()
	 * */
	
	public static class Element<Item> implements Iterable<Item> {
		Item [] values;
		int size;

		public Element(Item [] e) {
			this.values = e;
			this.size = e.length;
		}
		
		@Override
		public Iterator<Item> iterator() {
			return new ArrayIterator();
		}
		
		public class ArrayIterator implements Iterator<Item> {
			private int count;
			private boolean iteratorReverve;
			
			public ArrayIterator() {
				this.count = 0;
				this.iteratorReverve = false;
			}
			

			public ArrayIterator(boolean iteratorReverve) {
				this.iteratorReverve = iteratorReverve;
			}
			
			@Override
			public boolean hasNext() {
				return iteratorReverve == false ? 
						(count < size ? true : false) : (count > 0 ? true : false);
			}

			@Override
			public Item next() {
				return iteratorReverve == false ? values[count++] : values[count--];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
	}
	
	public static class Node {
	
	}
	
	public static class Deque<Item> implements Iterable<Item> {
		
		@Override
		public Iterator<Item> iterator() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public class ListIterator implements Iterator<Item> {
			private Item current;
			private int count;
			
			public ListIterator() {}
			
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current != null;
			}

			@Override
			public Item next() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
	}
	

	public static void main(String[] args) {
		Element<Integer> elements = new Element<Integer>(new Integer[] {1,2,3});
		Iterator<Integer> it = elements.iterator();
		while(it.hasNext()) {
			System.out.printf("%d ", it.next());
		}
	}

}
