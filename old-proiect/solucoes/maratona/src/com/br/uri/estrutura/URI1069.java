/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.uri.estrutura;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author C.Lucas
 */
//feito
//https://www.urionlinejudge.com.br/judge/pt/problems/view/1069

public class URI1069 {
    private static final Deque<Character> stack = new ArrayDeque<Character>();
    public static void solution(String d) {
        
        int counter = 0;
        for(int i=0; i<d.length(); i++) {
            if(d.charAt(i) == '<') {
                stack.push(d.charAt(i));
            } else if( ! stack.isEmpty() && stack.peek() == '<' && d.charAt(i) == '>') { 
                stack.pop();
                counter++;
            }
        }
        System.out.println(counter);
        stack.clear();
    }
}
