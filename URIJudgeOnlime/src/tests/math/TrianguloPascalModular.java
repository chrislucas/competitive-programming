/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.math;

import java.io.PrintWriter;

/**
 *
 * @author C.Lucas
 */
public class TrianguloPascalModular {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int m[][] = new int[2][2015], i, j;
        m[0][0] = 1;
        int limit = 4;
            i = 0;
        while(i<=limit) {
            j = 0;
            while(j<=i) {
                if((j > 0 && j < i))
                    m[i%2][j] = m[(i-1)%2][j-1] + m[(i-1)%2][j-1];
                else
                    m[i%2][j] = 1;
                    
                // java eh burro
                //m[i][j] = (j > 0 && j < i) ? m[(i-1)%2][j-1] + m[(i-1)%2][j-1] : 1;
                new PrintWriter(System.out, true).printf("%d ", m[i][j]);
                j+=1;
            }
            new PrintWriter(System.out, true).print("\n");
            i+=1;
        }

    }
    
}
