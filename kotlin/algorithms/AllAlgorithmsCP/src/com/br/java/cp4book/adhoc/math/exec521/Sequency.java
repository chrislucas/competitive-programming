package src.com.br.java.cp4book.adhoc.math.exec521;


public class Sequency {

    /*
        a1=0
        a2=0
        a3=0
        a4=0
        a5=1
        an=an−1+an−2+an−3+an−4+an−5
        The first few terms of pentanacci sequence are as follows

        0,0,0,0,1,1,2,4,8,16,31,61,120,236,464/
     */

    private long binomial(long n, long p) {
        long acc = 1L;
        // C(n, p) = C(n, n - p) lembrando do triangulo de pascal
        if (p > n - p) {
            p = n - p;
        }
        for (long i = 0; i < p; i++) {
            acc *= (n - i);
            acc /= (i + 1);
        }

        return acc;
    }
    /*
        1,2,4,8,16,31
        https://mathworld.wolfram.com/CircleDivisionbyChords.html
        circle divide by chords
        1, 2, 4, 8, 16, 31, 57, 99, 163, 256
        https://oeis.org/A000127
        		Maximal number of regions obtained by joining n points around a circle by
        		straight lines. Also number of regions in 4-space formed by n-1 hyperplanes.

        		Essa eh uma sequencia geometrica relacionado ao problema de dividir
        		um circulo desenhando pontos e unindos por uma reta e posteriormente
        		formando poligonos regulares.

        		Tambem comnhecido por Moser's cicle problem

     */
    private static void seq2() {

    }

    /*
        1,2,3,5,7,11,13,19 ....
        ----------------------------
        (3-2) = 1
        (5-3) = 2
        (7-5) = 2
        (11-7) = 4
        (13-11) = 2
        (19-13) = 6

        sequencia comeca com 1, 2
        a soma a diferenca de 2 numeros consecutivos

     */

    private static void seq4(int size) {
        int [] sequency = new int [size];
        sequency[0] = 1;
        sequency[1] = 2;
        sequency[2] = 3;
        sequency[3] = 5;
        sequency[4] = 7;
        StringBuilder expression = new StringBuilder();
        for (int i =5; i < size; i++) {
            int diff = sequency[i - 2] - sequency[i - 3];
            if ((i & 1) == 1) {
                diff =  (sequency[i - 1] - sequency[i - 2]) + diff;
            }
            sequency[i] = sequency[i - 1] + diff;
        }

        for (int i = 3; i < size; i++) {

            String partial =
                    String.format("%dth | (%d - %d)", i+1,
                            sequency[i - 2],
                            sequency[i - 3]
                    );

            if((i & 1) == 1) {
                partial = String.format("%s + (%d - %d)", partial,
                        sequency[i - 1],
                        sequency[i - 2]
                );
            }

            partial = String.format("%s = %d\n", partial, sequency[i]);
            expression.append(partial);
        }

        System.out.println(expression);
    }

    public static void main(String[] args) {
        //seq4(20);
        seq4(200);
    }
}
