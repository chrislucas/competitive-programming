/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.uri.estrutura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author C.Lucas
 */

// aceepted
public class URI1088 {
        public static String solution(int n, int s[]) {
        int rs = 0;
        boolean f = true;
        for(int i=0; i<n; i++) {
            //System.out.println(Arrays.toString(s));
            
            while(s[i] != i+1) {
                int swap = s[i];
                s[i] = s[swap - 1];
                s[swap - 1] = swap;
                rs++;
                f = ! f;
            }
            
            /*
            while(s[i] != i+1) {
                int a = s[i];
                int b = s[i] - 1;
                s[i] = s[b];
                s[b] = a;
                rs++;
                f = ! f;
            }
            */
        }
        return f ? "Carlos\n" : "Marcelo\n";
        //System.out.println(Arrays.toString(s));
    }

    public static void reader() {
        InputStream is = System.in;
        InputStreamReader  isp = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(isp);
        String str;
        String in[];
        StringBuilder sb = new StringBuilder();
        try {
            while(true) {
                str = buffer.readLine();
                in = str.split(" ");
                int n = Integer.parseInt(in[0]);
                if(n == 0)
                    break;
                int r[] = new int[n];
                for(int i=1; i<=n; i++) {
                   r[i-1] = Integer.parseInt(in[i]);
                }
                sb.append(solution(n, r)); 
            }
            System.out.print(sb.toString());
           
        } catch(IOException e) {}
    }
}
