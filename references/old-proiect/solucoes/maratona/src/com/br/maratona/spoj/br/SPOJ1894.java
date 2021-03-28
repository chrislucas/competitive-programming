/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.maratona.spoj.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class SPOJ1894 {
    public static void s1() throws IOException{
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
        String in[], str;
        StringBuilder sb = new StringBuilder();

        while( ! (str = bff.readLine()).equals("0")) {
            long a, b;
            int q, c, v, rs = 0, counter = 0, qv = 0;
            q = Integer.parseInt(str);
            for(int i=0; i<q; i++) {
                in = bff.readLine().split(" ");
                c = Integer.parseInt(in[0]);
                v = Integer.parseInt(in[1]);
                rs +=  v / 2;
 /*               
                if(v == 3) {
                    qv+=2;
                }
                else {
                    qv += v;
                }
                
                if(qv > 3) {
                    rs += qv / 4;
                    if(v > 3)
                        qv = v % 4;
                    else
                        qv = 0;
                } 
 */                                  
            }
            //sb.append( rs).append("\n");
            //System.out.println(rs);
            System.out.println(rs / 2);
        }
        //System.out.print(sb.toString());
     }
     
     public static void main(String[] args) {
         try {
             SPOJ1894.s1();
         } catch (IOException ex) {}
    }  
}
