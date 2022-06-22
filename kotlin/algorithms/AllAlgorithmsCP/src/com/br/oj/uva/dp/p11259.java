package src.com.br.oj.uva.dp;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Variacao do coinchange
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=2226
 * https://codeforces.com/blog/entry/85257
 */
public class p11259 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    interface TestCase {
        void run() throws IOException;
    }

    private static void testCases(int cases, TestCase testCase) throws IOException {
        while (cases > 0) {
            testCase.run();
            cases -= 1;
        }
    }

    private interface Converter<T> {
        T convert(String data);
    }

    private static <T> T readValue(Converter<T> converter) throws IOException {
        return converter.convert(reader.readLine());
    }

    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String[] data = reader.readLine().split(del);
        List<T> values = new ArrayList<>();
        for (String value : data) {
            values.add(converter.convert(value));
        }
        return values;
    }

    private static int solver(int[] coins, int[] quantities, int target) {
        int [][] state = new int[target+1][coins.length];
        for (int i = 0; i < coins.length; i++) {
            state[0][i] = 1;
        }

        for (int i = 1; i <= target ; i++) {
            int [] cpyQuantities = new int[quantities.length];
            System.arraycopy(quantities, 0, cpyQuantities, 0, quantities.length);
            for (int j = 0; j < coins.length ; j++) {
                if (cpyQuantities[j] < 1) {
                    continue;
                }
                int value = i - coins[j];
                int x = 0;
                if (value >= 0) {
                    x = state[i - value][j];
                    cpyQuantities[j] -= 1;
                }
                int y = j > 0 ? state[i][j-1] : 0;
                state[i][j] = x + y;
            }
        }

        return state[target][coins.length - 1];
    }

    private static void solver() throws IOException {
        testCases(readValue(Integer::parseInt), () -> {
            List<Integer> values = readValues(" ", Integer::parseInt);
            int q = values.get(values.size() - 1);
            System.out.println("Test Case");
            while (q > 0) {
                List<Integer> another = readValues(" ", Integer::parseInt);
                int value = another.get(another.size() - 1);

                int[] coins = new int[4];
                for (int i = 0; i < coins.length; i++) {
                    coins[i] = values.get(i);
                }

                int[] quantities = new int[4];
                for (int i = 0; i < coins.length; i++) {
                    quantities[i] = another.get(i);
                }

                ;
                System.out.println(solver(coins, quantities, value));
                q -= 1;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        solver();
    }
}
