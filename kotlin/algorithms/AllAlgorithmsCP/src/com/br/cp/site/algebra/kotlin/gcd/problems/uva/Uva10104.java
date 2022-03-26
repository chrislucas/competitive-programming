package src.com.br.cp.site.algebra.kotlin.gcd.problems.uva;

import java.io.*;

/**
 * // https://onlinejudge.org/external/101/10104.pdf
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=0&problem=1045&mosmsg=Submission+received+with+ID+27349388
 * DONE
 */
public class Uva10104 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private static String extendedGCD(long a, long b) {
        long ax = 1;
        long by = 0;
        long tx = 0;
        long ty = 1;
        while (b != 0) {
            long q = a / b;
            long r = a % b;
            long cx = ax - q * tx;
            ax = tx;
            tx = cx;
            long cy = by - q * ty;
            by = ty;
            ty = cy;
            a = b;
            b = r;

        }
        return String.format("%d %d %d", ax, by, a);
    }

    private static void solver() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String [] s = line.split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            writer.println(extendedGCD(a, b));
        }
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
