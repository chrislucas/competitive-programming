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
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
// feito
//https://www.urionlinejudge.com.br/judge/pt/problems/view/1068

public class URI1068 {
    public static boolean solution(String str) {
        Deque<Character> deque = new ArrayDeque<Character>();
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '(') {
                deque.push(c);
            } else  {
                if(c == ')' && deque.isEmpty()) {
                    return false;
                }
                else if(c == ')' && ! deque.isEmpty() && deque.peek() == '(') {
                    deque.pop();
                }
            }
        }
        return deque.isEmpty();
    }
}
