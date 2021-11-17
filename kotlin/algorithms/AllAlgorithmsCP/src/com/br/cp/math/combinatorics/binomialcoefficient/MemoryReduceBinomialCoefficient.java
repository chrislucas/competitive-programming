package src.com.br.cp.math.combinatorics.binomialcoefficient;


import static java.lang.Math.min;

/*
    https://www.geeksforgeeks.org/binomial-coefficient-dp-9/

*/
public class MemoryReduceBinomialCoefficient {

    /*
            The following code only uses O(k)
     */
    static long bc(long n, int p) {
        long[] dp = new long[p + 1];
        dp [0] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = min(i, p); j > 0 ; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[p];
    }

    public static void main(String[] args) {
        System.out.println(bc(8, 2));
        System.out.println(bc(50, 6));
    }
}
