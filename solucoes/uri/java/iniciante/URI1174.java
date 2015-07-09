package com.br.uri.iniciante;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
//import java.util.StringTokenizer;
/**
 * Done
 * @author christoffer
 * https://www.urionlinejudge.com.br/judge/pt/problems/view/1174
 */
public class URI1174 {
    
     public static void s1() throws IOException{
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
        double[] n = new double[100];  
        DecimalFormat d = new DecimalFormat("0");
        DecimalFormat f = new DecimalFormat("0.0");
        /*
        String s = bff.readLine();
        StringTokenizer tokens = new StringTokenizer(s);
        int i=0;
        while( tokens.hasMoreTokens()) {
           n[i++] = Double.parseDouble(tokens.nextElement().toString()); 
        }
        */
        int i;
        for(i=0; i<100; i++) {
           n[i] = Double.parseDouble(bff.readLine());
        }
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < n.length; i++) {
            if(n[i] <= 10.0) {
                //if houver parte decimal, imprimir com uma casa decimal, se nao 
                String str = (Math.abs((int)n[i] - n[i]) > 0.0 ) ? f.format(n[i]).replace(',', '.') : d.format(n[i]).replace(',', '.');
                sb.append("A[").append(i).append("] = ").append(str).append("\n"); 
            }
        }
        System.out.print(sb.toString());
     }
     
     public static void main(String[] args) {
         try {
             URI1174.s1();
         } catch (IOException ex) {}
    }
}
