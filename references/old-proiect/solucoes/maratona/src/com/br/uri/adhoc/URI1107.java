/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 *
 * @author C.Lucas
 */

// accepted

public class URI1107 {

    public static String solution(int alt, int comp, int bloco[]) {
        int rs = 0;
        if(comp == 1)
            return alt - bloco[0] + "\n";
        
        for(int i=1; i<comp; i++) {
            if(bloco[i] > bloco[i - 1]) {
                rs += bloco[i] - bloco[i - 1];
            }
            if( i+1 == comp) {
                rs += alt - bloco[i];
            }
        }
        
        return rs + "\n";
    }
    public static void reader() {
        InputStream is = System.in;
        InputStreamReader  isp = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(isp);
        String str;
        String in[];
        StringBuilder sb = new StringBuilder();
        try {
       
            while( (str = buffer.readLine()) != null ) {

                int alt, comp, i;
                in = str.split(" ");
                alt = Integer.parseInt(in[0]);
                comp = Integer.parseInt(in[1]);
                
                if(alt==0 && comp==0)
                    break;
                
                in = buffer.readLine().split(" ");
                int corte[] = new int[in.length];
                for(i=0; i<in.length; i++) {
                    corte[i] = Integer.parseInt(in[i]);
                }
                sb.append(solution(alt, comp, corte));
            }
            
            System.out.print(sb.toString());
        } catch(IOException e) {}
    }
}