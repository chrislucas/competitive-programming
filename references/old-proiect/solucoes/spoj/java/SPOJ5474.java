/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author christofer lucas
 */
//http://br.spoj.com/problems/ALADES/

public class SPOJ5474 {
    
    public static String solutionoV1(int h1, int m1, int h2, int m2) {
        int t1, t2;
        t1 = h1 * 60 + m1;
        t2 = h2 * 60 + m2;
        StringBuilder sb = new StringBuilder();
        /*
            caso de teste interessante
            antes: if(h1 >= h2 && (m1 >= m2)  )
            3 20 3 21
            1
            13 00 12 30
            30
            depois: if(h1 >= h2 && (m1 >= m2) || h1 > h2 && (m1 < m2) )
            3 20 3 21
            1
            13 00 12 30
            1410
        */
        
        if(h1 >= h2 && (m1 >= m2) || h1 > h2 && (m1 < m2) ) {
            //System.out.println((1440 - Math.abs(t1 - t2)));
            sb.append((1440 - Math.abs(t1 - t2))).append("\n");
        }
        else {
            //System.out.println(Math.abs( (1440 - t1) - (1440 - t2) ) );
            sb.append(Math.abs( (1440 - t1) - (1440 - t2) )).append("\n");
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String in;
        StringBuilder sb = new StringBuilder();
        try {
            while( ! (in = buffer.readLine()).equals("0 0 0 0") ) {
                 String str[] = in.split(" ");
                 int h1, m1, h2, m2;
                 h1 = Integer.parseInt(str[0]);
                 m1 = Integer.parseInt(str[1]);
                 h2 = Integer.parseInt(str[2]);
                 m2 = Integer.parseInt(str[3]);
                 sb.append(SPOJ5474.solutionoV1(h1, m1, h2, m2));
            }
            System.out.print(sb.toString());
        } catch (IOException ex) {}       
    }
}
