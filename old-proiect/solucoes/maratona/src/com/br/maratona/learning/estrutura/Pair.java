/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.br.maratona.learning.estrutura;

// restricoes em generics
// http://docs.oracle.com/javase/tutorial/java/generics/restrictions.html


/**
 *
 * @author C.Lucas
 * @param <K>
 * @param <V>
 */


public class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K,V>> {
    private  K k; 
    private  V v;
    private  Pair<K,V> p;
    
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        return 0;
    }
    
    public Pair makePair(K k, V v) {
        return null;
    }
}
