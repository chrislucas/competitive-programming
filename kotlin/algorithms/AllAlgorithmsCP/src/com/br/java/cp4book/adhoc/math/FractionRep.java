package src.com.br.java.cp4book.adhoc.math;

import java.math.BigInteger;

public class FractionRep {

    static class Fraction {
        BigInteger p, q;

        private long gcd(long a, long b) {
            if (a % b == 0) {
                return b;
            } else {
                return gcd(b, a % b);
            }
        }

        Fraction(BigInteger p, BigInteger q) {
            BigInteger gcd = p.gcd(q);
            this.p = p.divide(gcd);
            this.q = q.divide(gcd);
        }

        Fraction(long p, long q) {
            long gcd = gcd(p, q);
            this.p = BigInteger.valueOf(p / gcd);
            this.q = BigInteger.valueOf(q / gcd);
        }

        public String fraction() {
            return String.format("%d/%d", p, q);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Fraction(new BigInteger("120"), new BigInteger("32")).fraction());

        System.out.println(new Fraction(120L, 32L).fraction());
    }
}
