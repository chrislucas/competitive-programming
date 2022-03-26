package src.com.br.cp.io;

import java.io.*;

public class PairIO<P, Q> {

    final P p;
    final Q q;

    PairIO(P p, Q q) {
        this.p = p;
        this.q = q;
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    public PairIO<Integer, Integer> readInt(String del) throws IOException {
       String [] line  = reader.readLine().split(del);
       return new PairIO<Integer, Integer>(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
    }

    public PairIO<Long, Long> readLong(String del) throws IOException {
        String [] line  = reader.readLine().split(del);
        return new PairIO<Long, Long>(Long.parseLong(line[0]), Long.parseLong(line[1]));
    }
}
