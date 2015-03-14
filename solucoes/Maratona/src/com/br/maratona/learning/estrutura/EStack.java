/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.maratona.learning.estrutura;

import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;


/**
 *
 * @author C.Lucas
 */
public class EStack {
    
    private static final int LIMIT = 200000;
    
    private static String generateStr() {
       String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
       int limit = 30;
       char str[] = new char[limit];
       Random random = new Random();
       int i; 
       for(i=0; i<limit; i++) {
           str[i] = s.charAt(random.nextInt(s.length()));
       }
       return Arrays.toString(str);
    }
    
    public static void stackByStack() {
        int i;
        Stack<String> stack = new Stack<String>();
        for(i=0; i<LIMIT; i++) {
            String str = generateStr();
            stack.push(str);
        }
        
        while( ! stack.empty() ) {
            String e = stack.peek();
            //System.out.println(e);
            stack.pop();
        }
        
    }
    
    public static void  stackByLinkedlist() {
        // LienkedList implementa Deque
        Deque<String> ll = new LinkedList<String>();
        for(int i=0; i<LIMIT; i++) {
            ll.push(generateStr());
        }
        
        while( ! ll.isEmpty()) {
            //System.out.println(deque.peek());
            ll.pop();
        }
              
    }
    
    // uma implementacao de estrutura do tipo LIFO é a DEQUE no Java, segundo a propria documentacao
    public static void stackByDeque() {
        // public interface Deque extends Queue
        Deque<String> deque = new ArrayDeque<String>();
        
        for(int i=0; i<LIMIT; i++) {
            deque.push(generateStr());
        }
        
        while( ! deque.isEmpty()) {
            //System.out.println(deque.peek());
            deque.pop();
        }
    }
    
    public static void test() {
        Long s, e;
        
        s = System.currentTimeMillis();
        EStack.stackByStack();
        e = System.currentTimeMillis();
        
        
        System.out.format("%d %.5f %n", ((s - e) / 1000), Math.PI);
        
        s = System.currentTimeMillis();
        EStack.stackByDeque();
        e = System.currentTimeMillis();
        System.out.println(String.format("%d",(s - e) / 1000));
               
        s = System.currentTimeMillis();
        EStack.stackByLinkedlist();
        e = System.currentTimeMillis();
        // System.out.format("%f %d %d\n", (s - e) / 1000, s, e);
    }
 /*   
    public static void main(String[] args) {
        test();
    }
 */   
}
