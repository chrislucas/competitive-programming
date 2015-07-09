/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.uri.iniciante;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Done
 * @author C.Lucas
 */
public class URI1435 {
    static final int limite = 110;
    static int[][] matrix = new int[limite][limite];
    
    // complexidade (limite / 2 + 1) * limite
    public static void init(int l) {
        int l1 = l / 2 + 1, l2 = l;
        int i, j;
        for(i=0; i<l1; i++) {
            for(j=i; j<l2; j++) {
                matrix[i][j] = matrix[j][i] = matrix[l2 - 1][j] = matrix[j][l2 - 1] = i+1;
            }
            l2 = l2 - 2 + 1;
        }
    }
    
    public static void solutionV1(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0)
                    //System.out.printf("%3d", matrix[i][j]);
                    sb.append(String.format("%3d", matrix[i][j]));
                else
                    //System.out.printf(" %3d", matrix[i][j]);
                    sb.append(" ").append(String.format("%3d", matrix[i][j]));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    
    public static HashMap initMap() {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        StringBuilder sb = new StringBuilder();
        int x;
        for(x = 1; x<101; x++) {
            int l1 = x / 2 + 1, l2 = x;
            int i, j;
            for(i=0; i<l1; i++) {
                for(j=i; j<l2; j++) {
                    matrix[i][j] = matrix[j][i] = matrix[l2 - 1][j] = matrix[j][l2 - 1] = i+1;
                }
                l2 = l2 - 2 + 1;
            }
            
            for(i=0; i<x; i++) {
                for(j=0; j<x; j++) {
                    if(j == 0)
                        sb.append(String.format("%3d", matrix[i][j]));
                    else
                        sb.append(" ").append(String.format("%3d", matrix[i][j]));
                }
                sb.append("\n");
            }
            map.put(x, sb.toString());
            sb.setLength(0);
        }
        return map;
    }
    
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String in;
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map = URI1435.initMap();
        try {
            while( ! (in = buffer.readLine()).equals("0") ) {
                int l = Integer.parseInt(in);
                System.out.println(map.get(l));
                //URI1435.init(l);
                //URI1435.solutionV1(l);
            }
        } catch(IOException e){}
    }
}
