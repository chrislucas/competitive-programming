/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.uri.matematica;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author C.Lucas
 */
public class URI1198 {
    
    public static void s1() throws IOException{
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
        String in[], str;
        StringBuilder sb = new StringBuilder();
        while( (str = bff.readLine()) != null) {
            long a, b;
            in = str.split(" ");
            a = Long.parseLong(in[0]);
            b = Long.parseLong(in[1]);
            sb.append( ((Long)Math.abs(a - b)) ).append("\n");
            //System.out.println(Math.abs(a - b));
        }
        System.out.printf("%s", sb.toString());
     }
     
     public static void main(String[] args) {
         try {
             URI1198.s1();
         } catch (IOException ex) {}
    }
}
