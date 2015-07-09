/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.maratona.learning.estrutura;

/**
 *
 * @author C.Lucas
 */

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


/**
 *  Docs BitSet
 *  http://docs.oracle.com/javase/7/docs/api/java/util/BitSet.html
 *  tutorial sobre BitSet
 *  http://www.java2s.com/Tutorial/Java/0140__Collections/ManipulatingSetsofBits.htm
 *  http://www.tutorialspoint.com/java/java_bitset_class.htm
*/

public class EBitSet {
    static BitSet bit = new BitSet(10);
    static BitSet crive;
    static final long LIMIT = 30 + 1; /*3000000*/;
    static List<Long> list;
    
    public static void criveErastotenes() {
        list = new ArrayList<Long>();
        crive = new BitSet((int) LIMIT);
        crive.set(0, (int) LIMIT, true);
        crive.set(0, 2, false);
        for(long i=2; i<LIMIT; i++) {
            if(crive.get((int)i)) {
                list.add(i);
                for(long j = i << 1; j<LIMIT; j+=i) {
                    //crive.set((int) j, false);
                    if(crive.get((int)j)) {
                        crive.flip((int) (j));
                    }
                }    
            }
        }
    }
    
    
    public static void init() {
        for(int i=0; i<10; i++) {
          boolean f =  ((i % 2) == 0);
          bit.set(i, f);
        }
        // imprimi os bits com valor verdadeiro
        System.out.println(bit);
        // imprimi a quantidade de bits com valor verdadeiro
        System.out.println(bit.cardinality());
        // imprime true ou false conforme o bit recuperado pelo indice
        System.out.println(bit.get(0));
        // inverte valor do bit
        //bit.flip(0);
        //System.out.println(bit.get(0));
        // inverte valor em um intervalo de bits
        bit.flip(0, 10);
        System.out.println(bit);
    }
    
    
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        criveErastotenes();
        long e = System.currentTimeMillis();
        
        System.out.format("%.10f\n", (double) (e - s) / 1000 );
        System.out.println(crive);
        System.out.println(crive.length());
        System.out.println(crive.size());
        System.out.println(crive.get(crive.length()));
        System.out.println(crive.get(crive.size()));
        long size = list.size();
        System.out.println(size+" "+list.get((int) size - 1));
        // limpando o bitset
        crive.clear();
    }
}
