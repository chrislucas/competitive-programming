package src.com.br.cp.io;

import java.io.*;

public class IntPair {

    final Integer p;
    final Integer q;

    IntPair(Integer p, Integer q) {
        this.p = p;
        this.q = q;
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    public static IntPair readLine(String del) throws IOException {
       String [] line  = reader.readLine().split(del);
       return new IntPair(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }
}
