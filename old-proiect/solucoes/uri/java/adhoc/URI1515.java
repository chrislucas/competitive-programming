/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.uri.adhoc;

/**
 *
 * @author C.Lucas
 */

//https://www.urionlinejudge.com.br/judge/pt/problems/view/1515


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


//accepted

public class URI1515 {
    
    static class Message implements Comparable<Message>{
        String dest;
        int age, q;
        Message(String dest, int age, int q) {
            this.dest = dest;
            this.age = age;
            this.q = q;
        }

        @Override
        public int compareTo(Message message) {
            return this.age < message.age ? -1 : 1;
        }
    }
    
    public static void reader() {
        InputStreamReader  is = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(is);
        String s;
        try {
            int max = 0;
            String name = "";
            while( ! (s = buffer.readLine()).equals("0") ) {
                int n = Integer.parseInt(s);
                for(int i=0; i<n; i++ ) {
                    String in[];
                    in = buffer.readLine().split(" ");
                    int diff = Integer.parseInt(in[1]) - Integer.parseInt(in[2]);
                    if(i == 0) {
                        max = diff;
                        name = in[0];
                    } else {
                        if(max > diff) {
                            max = diff;
                            name = in[0];
                        }
                    }
                }
                System.out.println(name);
            } 
        } catch(IOException e) {}
    }    
}
