/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.br.certificacao.cap7;


import java.util.Random;
/**
 *
 * @author C.Lucas
 */
public class Arrays {
    public static void init() {
        float []a, b[][];
        // isso só funcina porque o colchete está antes da variável 'a'
        // assim o compilador entenderá que a e b tratan-se de vetores
        b = new float[10][][];
    }
    
    public static void aleatorio() {
        Random r = new Random();
        int f[] = new int[7];
        for(int i = 1; i<15000; i++) {
            f[r.nextInt(6) + 1]++;
            //int s = r.nextInt(6) + 1;
            //System.out.printf("0x%x %5d\n", f[s]++, s);
        }
        /*
        int a[] = new int[10];
        for(int i=0; i<a.length; i++)
            System.out.printf("%3d\n", ++a[i]);
        */
        
        for(int i=1; i<f.length - 1; i++) {
          
            System.out.printf("%3d %10d 0x%08x %x\n", i, f[i], f[i], f[i+1] - f[i]);
        }
        
        System.out.printf("%3d %10d 0x%08x %x\n", 6, f[6], f[6], f[6] - f[5]);
        System.out.printf("0x%08x\n", 0x000009d8 - 0x000009c4);
    }
    
    public static void main(String[] args) {
        Arrays.aleatorio();
    }
}
