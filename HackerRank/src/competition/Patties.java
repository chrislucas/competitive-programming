package competition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;

// https://www.hackerearth.com/code-hack-1b/algorithm/patties/

public class Patties {

    public static void main(String[] args) {
	    // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);
        String[] enter = new String[2];
        try {
            int a = Integer.parseInt(reader.readLine());
            int b = Integer.parseInt(reader.readLine());
            int dA = ((int)Math.log10(a)) + 1, dB = ((int)Math.log10(a)) + 1;
            boolean flag = true;
            if(dA > dB) {
                flag = false;
            } else {
                int init = 10, count = 0;
                for(int i=0; i<dA; i++) {
                    if( (a % init) != (b % init)) {
                        count++;
                        if(count>1) {
                            flag = false;
                            break;
                        }
                    }
                    a /= init;
                    b /= init;
                }
            }
            writer.printf("%s\n", flag ? "wins" : "loses");
        } catch(IOException ioex) {}
    }
}
