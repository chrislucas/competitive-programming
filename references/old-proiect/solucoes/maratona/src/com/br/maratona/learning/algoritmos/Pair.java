/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.maratona.learning.algoritmos;

import java.util.Comparator;

/**
 *
 * @author C.Lucas
 * @param <K> Chave
 * @param <V> Valor
 */
//http://stackoverflow.com/questions/15189949/making-a-generic-comparator-class
//http://stackoverflow.com/questions/156275/what-is-the-equivalent-of-the-c-pairl-r-in-java
public class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<V>, Comparable<Pair<K,V>> {
    
    private final K key;
    private final V value;
    
    public Pair(K k, V v) {
        this.key = k;
        this.value = v;
    }
    
    @Override
    public int compare(V a, V b) {
        return a.compareTo(b);
    }
    
    public K getKey() {
        return this.key;
    }
    
    public Pair makePair(K k, V v) {
        return new Pair(k, v);
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        return 0;
    }
}
