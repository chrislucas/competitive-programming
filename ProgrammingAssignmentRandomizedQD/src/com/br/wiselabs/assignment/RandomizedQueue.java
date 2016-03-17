package com.br.wiselabs.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

	
	public Node<Item> first, last; 
	public int size;
	
	/*
	 * 
	   public RandomizedQueue()              // construct an empty randomized queue
	   public boolean isEmpty()                 // is the queue empty?
	   public int size()                        // return the number of items on the queue
	   public void enqueue(Item item)           // add the item
	   public Item dequeue()                    // remove and return a random item
	   public Item sample()                     // return (but do not remove) a random item
	 * */
	
	public RandomizedQueue() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Iterator<Item> iterator() {
		return null;
	}
		
	@SuppressWarnings("hiding")
	private class Node<Item> {
		@SuppressWarnings("unused")
		public Item item;
		@SuppressWarnings("unused")
		public Node<Item> next, parent;		// referencia para o proximo e para o anterior
		@SuppressWarnings("unused")
		Node(Item item) {
			this.item = item;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
