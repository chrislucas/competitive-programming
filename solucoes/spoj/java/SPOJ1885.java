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
 * @author C.Lucas
 */
public class SPOJ1885 {

    public static void s1() throws IOException{
        BufferedReader bff = new BufferedReader(new InputStreamReader(System.in));
        String in[], str;
        StringBuilder sb = new StringBuilder();
       int[][] matrix;
        while( ! (str = bff.readLine()).equals("0 0 0")) {
            long a, b;
            int w, h, n;
            in = str.split(" ");
            w = Integer.parseInt(in[0]);
            h = Integer.parseInt(in[1]);
            n = Integer.parseInt(in[2]);
            matrix = new int[w][h];
            int xa,ya,xb,yb;
            int counter = h * w;
            for(int i=0; i<n; i++) {
                in = bff.readLine().split(" ");
                xa = Integer.parseInt(in[0]);
                ya = Integer.parseInt(in[1]);
                xb = Integer.parseInt(in[2]);
                yb = Integer.parseInt(in[2]);
            }

            //sb.append( (h + (m2 - m1)) ).append("\n");
            //System.out.println((h + (m2 - m1)));
        }
        //System.out.print(sb.toString());
     }
/*     
    public static void main(String[] args) {
         try {
             SPOJ1885.s1();
         } catch (IOException ex) {}
    }
*/
}
