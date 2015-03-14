/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.uri.iniciante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Done
 * @author christoffer
 */
public class URI1478 {
    
    static int matrix[][] = new int[110][110];
    
    static void init() {
        int i, j, k = 1, c=0, n = 110;
        for(i=0; i<n; i++) {
            k = 1;
            for(j=i; j<n; j++) { 
               matrix[j][i] = matrix[i][j] = k++;         
            }
        }
    }
    
    static void rs(int n) {
        int i, j;
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
                if(j==0)
                    System.out.printf("%3d", matrix[i][j]);
                else
                    System.out.printf(" %3d", matrix[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }
    
    static final void rsv2(int n) {
        int i, j, k;
        int m[][] = new int[n][n];
        for(i=0; i<n; i++) {
            k = 1;
            for(j=i; j<n; j++) { 
               m[j][i] = m[i][j] = k++;         
            }
        }
        
        for(i=0; i<n; i++) {
            for(j=0; j<n; j++) {
               if(j==0)
                    System.out.printf("%3d", m[i][j]);
                else
                    System.out.printf(" %3d", m[i][j]);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        //URI1478.rsv2(5);
        //URI1478.rs(5);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String in;
        //DecimalFormat f = new DecimalFormat("0.000");
        //System.out.println(f.format(Math.PI));
        //URI1478.init();
        try {
            while( ! (in = buffer.readLine()).equals("0") ) {
                int n = Integer.parseInt(in);
                URI1478.rsv2(n);
                //URI1478.rs(n);
            }
        } catch (IOException ex) {}
    }

}
