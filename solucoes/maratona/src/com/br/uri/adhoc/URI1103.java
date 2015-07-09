/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author C.Lucas
 */
public class URI1103 {

    public static void s1() throws IOException{
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
        String in[], str;
        StringBuilder sb = new StringBuilder();
        
        while( ! (str = bff.readLine()).equals("0 0 0 0")) {
            long a, b;
            int h1 = 0, m1 = 0, h2 = 0, m2 = 0, rs;
            in = str.split(" ");
            h1 = Integer.parseInt(in[0]);
            m1 = Integer.parseInt(in[1]);
            h2 = Integer.parseInt(in[2]);
            m2 = Integer.parseInt(in[3]);
            
            int h, m;
            // mesmo dia
            if( (h1 < h2) || ((h1 == h2) && (m1 < m2)) ) {
                h = (h2 - h1) * 60;
                //m = m2 - m1;
            } 
            // outro dia
            else {
                h = (1440 - (h1 - h2) * 60);
                //m = m2 - m1;
            }
            //sb.append( (h + (m2 - m1)) ).append("\n");
            System.out.println((h + (m2 - m1)));
        }
        //System.out.print(sb.toString());
     }
    /*
    public static void main(String[] args) {
         try {
             URI1103.s1();
         } catch (IOException ex) {}
    }
    */
}
