package com.br.wiselabs.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.RandomSeq;
/**
 * http://algs4.cs.princeton.edu/code/
 * */
public class Deque<Item> implements Iterable<Item> {

	public Node<Item> first, last; 
	public int size;
	
	public Deque() {
		size = 0;
	}
	// is the deque empty?
   public boolean isEmpty() {
	   return this.first == null || this.last == null;
   }
   // return the number of items on the deque
   public int size() {
	   return this.size;
   }
   // add the item to the front
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
			Node<Item> tail = first == last ? first : last;	//first.next == null ? first : first.next;;
			first 		 = new Node<Item>(item);			// cria o novo primeiro (mais a esquerda)
			tail.parent  = size == 1 ? first : head;		// o elemento anterior ao elemento mais a direita
			head.parent  = first;
			first.next 	 = head;							// o proximo elemento apos o i-th
			last 		 = tail;
		}
		this.size++;
   }
   // add the item to the end
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
   // remove and return the item from the front
   public Item removeFirst() {
	 if(isEmpty()) {
		 throw new NoSuchElementException();
	 }
	 return null;
   }
// remove and return the item from the end
   public Item removeLast() {
	  if(isEmpty()) {
		  throw new NoSuchElementException();
	  }
	  return null;
   }
   
	@Override
	public Iterator<Item> iterator() {
		RandomSeq rq;
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
	
	@SuppressWarnings("hiding")
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
		// TODO Auto-generated method stu
	}

}
