package tests;

/**
 * http://marathoncode.blogspot.com.br/2012/05/algoritmos-de-tentativa-e-erro.html
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 * http://www.cmi.ac.in/~vipul/olymp_resources/olympiadarticles/touringproblems.pdf
 * https://pt.wikipedia.org/wiki/Problema_do_cavalo
 * http://rachacuca.com.br/jogos/passeio-do-cavalo/
 *
 * http://interactivepython.org/runestone/static/pythonds/Graphs/KnightsTourAnalysis.html
 * http://stackoverflow.com/questions/19214109/how-to-optimize-knights-tour-algorithm
 *
 * */

public class KnightTour {


    public static int convert(int i, int j, int size) {
        return i * size + j;
    }

    public static boolean isOnBorder(int i, int j, int size) {
        if( (i > -1 && i < size) && (j > -1 && j < size))
            return true;
        return false;
    }

    public static int tour(int count, int pos, int[][] table, int [] mi, int [] mj) {
        int size = table[0].length;
        int i = pos / size, j = pos - i * size;
        if(count > 63)
            return 1;
        for(int k=0; k<size; k++) {
            // cavala de movendo para casa (u,v)
            int u = i + mi[k], v = j + mj[k];
            if(isOnBorder(u,v,size)) {
                // se essa casa nao foi visitada
                if(table[u][v] == 0) {
                    table[u][v] = ++count;
                    pos = convert(u, v, size);
                    //System.out.printf("%d ", pos);
                    int q = tour(count, pos, table, mi, mj);
                    // se
                    if(q == 0)
                        table[u][v] = 0;
                    else
                        return 1;
                }
            }
        }
        return 0;
    }

    public static void init(int pos, int size) {
        int i = pos / size, j = pos - i * size;
        // par de movimentos permitidos de um cavalo no xadrez
        int [] mi = {2,1,-1,-2,-2,-1,1,2}
              ,mj = {1,2,2,1,-1,-2,-2,-1};
        // inicio do tour do cavalo
        int count = 1;
        int[][] table = new int [size][size];
        for(int k=0; k<size; k++)
            for(int l=0; l<size; l++)
                table[k][l] = 0;
        table[i][j] = 1;
        tour(1, pos, table, mi, mj);

        System.out.println("\n");
        for(int k=0; k<size; k++) {
            for (int l = 0; l < size; l++)
                System.out.printf("%d ", table[k][l] );
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        init(0, 8);
    }
}
