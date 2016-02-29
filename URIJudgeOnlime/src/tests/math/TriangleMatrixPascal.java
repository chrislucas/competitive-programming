package tests.math;

public class TriangleMatrixPascal {

    public static int[][] memo(int q) {
        int [][] matrix = new int [q][q];
        return matrix;
    }

    public static int[][] dp(int q) {
        return null;
    }

    public static long[][] naive(int q) {
        q++;
        long [][] matrix /*= new long [q][q]*/ = new long[q][];
        for(int i=0; i<q; i++) {
            matrix[i] = new long[i+1];
            matrix[i][0] = 1;
        }
        matrix[1][1] = 1;
        for(int i=2; i<q; i++) {
            for(int j=1; j<=i; j++) {
                matrix[i][j] = j < i ? matrix[i-1][j-1] + matrix[i-1][j] : 1;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
	    // write your code here
        naive(40);
    }
}
