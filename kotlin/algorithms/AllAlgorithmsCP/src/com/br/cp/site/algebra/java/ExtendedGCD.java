package src.com.br.cp.site.algebra.java;

/**
 * Link interessante com o passo a passo do algoritmo e as equacoes que sao geradas
 * no gcd extendido
 * https://pt.planetcalc.com/3298/
 */
public class ExtendedGCD {

    static class Coefficient {
        long a, b, x, y, g;

        private Coefficient() throws Exception {
            throw new Exception("");
        }

        public Coefficient(long a, long b, long x, long y, long g) {
            this.a = a;
            this.b = b;
            this.x = x;
            this.y = y;
            this.g = g;
        }

        @Override
        public String toString() {
            return String.format("Coefficient (ax + by) = gcd(a, b)\n (%d*%d + %d*%d) = gcd(%d, %d) == %d"
                    , a, x, b, y, a, b, g);
        }
    }

    static Coefficient extended(long a, long b) {
        if (b == 0) {
            return new Coefficient(a, b, 0, 0, Long.MIN_VALUE);
        } else if (a % b == 0) {
            return new Coefficient(a, b, 0, 1, b);
        }
        Coefficient coefficient = extended(b, a % b);
        long ax = coefficient.x;
        long by = coefficient.y;
        long cy = ax - (a / b) * by;
        return new Coefficient(a, b, by, cy, coefficient.g);
    }

    static Coefficient it(long a, long b) {
        long ca = a;
        long cb = b;
        long ax = 1;
        long ay = 0;
        long tx = 0;
        long ty = 1;
        while (cb != 0) {
            long quo = ca / cb;
            long rem = ca % cb;
            long cx = ax - quo * tx;
            ax = tx;
            tx = cx;
            long cy = ay - quo * ty;
            ay = ty;
            ty = cy;
            ca = cb;
            cb = rem;
        }
        return new Coefficient(a, b, ax, ay, ca);
    }


    public static void main(String[] args) {
        System.out.println(extended(10, 4));
        System.out.println(it(10, 4));
        System.out.println("*************************************************");
        System.out.println(extended(120, 23));
        System.out.println(it(120, 23));
        System.out.println("*************************************************");
        // System.out.println(extended(0, 0));
        // System.out.println(it(0, 0));
        // System.out.println("*************************************************");
    }
}
