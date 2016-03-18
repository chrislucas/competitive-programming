package com.br.wiselabs.exercises;


import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.*;

public class GenericDeque<Item> implements Iterable<Item>  {
	public Node<Item> first, last; 
	public int size;
	public GenericDeque() {
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return this.first == null || this.last == null;
	}
	
	public void addFirst(Item item) {
		if(item == null) {
			throw new NullPointerException();
		}
		// se a lista estiver vazia, instacia o primeiro noh
		// o no com nome 'last' sabe onde  lista acaba
		if(/*first == null*/ isEmpty()) {
			first 			= new Node<Item>(item);
			last 			= first;
		}
		// se a lista nao estiver vazia, o primeiro no dara lugar
		// ao novo item adicionado, tornando-se no filho
		else {
			Node<Item> head = first;		// a referencia sempre mais a esquerda da lista
			// a referencia mais a direita da lista
			//first == last ? first : last;
			//Node<Item> tail = last; 
			first 		 = new Node<Item>(item);			// cria o novo primeiro (mais a esquerda)
			//size == 1 ? first : head;
			//tail.parent  = head;							// o elemento anterior ao elemento mais a direita
			head.parent  = first;
			first.next 	 = head;							// o proximo elemento apos o i-th
			//last 		 = tail;
		}
		this.size++;
	}
	
	public void addLast(Item item) {
		if(item == null) {
			throw new NullPointerException();
		}
		// se a lista estiver vazia, instacie o no 'first'
		// o no 'last' ira apontar para ele de qualqer forma
		if(/*first == null*/ isEmpty()) {
			first 			= new Node<Item>(item);
			last 			= first;
		} else {
			Node<Item> tail = last;
			last = new Node<Item>(item);
			tail.next = last;
			last.parent = tail;
		}
		this.size++;
	}
	
	
	public Item removeFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item 		= first.item;
		Node<Item> next = first.next;
		//first = null;
		next.parent = null;
		first = next;
		this.size--;
		return item;
	}
	
	public Item removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Item item = last.item;
		Node<Item> parent = last.parent;		// o penultimo se tornara o ultimo
		// o ultimo nao tem proximo, pois eh o ULTIMO
		parent.next = null;
		// o penultimo se tornou o ulitmo
		last = parent;
		this.size--;		// diminui o tamanho da lista
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>();
	}
	
	@SuppressWarnings("hiding")
	private class ListIterator<Item> implements Iterator<Item> {
		@SuppressWarnings("unchecked")
		private Node<Item> current = ((Node<Item>) first);
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if( ! hasNext()) {
				throw new NoSuchElementException();
			}
			Item item 		= current.item;
			Node<Item> next = current.next;
			current 		= next;
			return item;
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}		
	}
	
	private class Node<Item> {
		@SuppressWarnings("unused")
		public Item item;
		@SuppressWarnings("unused")
		public Node<Item> next, parent;		// referencia para o proximo e para o anterior
		
		Node(Item item) {
			this.item = item;
		}
	}
	
	public static void main(String[] args) {
		GenericDeque<Integer> deque = new GenericDeque<Integer>();
		
		deque.addFirst(15);
		deque.addLast(5);
		deque.addFirst(2);
		deque.addFirst(3);
		deque.addLast(6);
		deque.addLast(8);
		deque.addFirst(4);
		deque.addLast(10);
		deque.addFirst(10);
		deque.addFirst(12);
		deque.addFirst(17);
		deque.addFirst(18);
		deque.addLast(100);
		
		Iterator<Integer> iterator = deque.iterator();
		while(iterator.hasNext()) {
			Integer i = iterator.next();
			StdOut.printf("%d ", i);
		}
		
		StdOut.println();
		
		deque.removeLast();
		deque.removeFirst();
		deque.removeFirst();
		deque.removeLast();
		deque.removeFirst();
		
		iterator = deque.iterator();
		while(iterator.hasNext()) {
			Integer i = iterator.next();
			StdOut.printf("%d ", i);
		}
		
	}

}
