/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.maratona.learning.estrutura;


/**
 * tutorial oracle = http://docs.oracle.com/javase/tutorial/java/generics/types.html
 * @author C.Lucas
 * @param <T> O tipo de valor que será inserido na classe Box
 * Os nomes mais comuns utilizados para tipos de parâmetros são
    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types
 *  
 * 
 */
public class Box<T> implements Comparable<Box<T>> {
   private T t;

   public void setT (T t) {
       this.t = t;
   }
   
   public T getT() {
       return this.t;
   }

    @Override
    public int compareTo(Box<T> b) {
        return 0;
    }
}
