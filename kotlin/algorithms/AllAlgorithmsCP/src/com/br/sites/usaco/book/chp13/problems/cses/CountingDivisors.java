package src.com.br.sites.usaco.book.chp13.problems.cses;


import java.io.*;

public class CountingDivisors {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private interface Converter<T> {
        T converter(String data);
    }

    private static <T> T readValue(String del, Converter<T> converter) throws IOException {
        return converter.converter(reader.readLine());
    }

    static class ToInt implements Converter<Integer> {
        @Override
        public Integer converter(String data) {
            return Integer.parseInt(data);
        }
    }

    private static int counterPrimerFactors(int number) {
        int acc = 1;
        int div = 2;
        while (div * div <= number) {
            if (number % div == 0)
                acc += 1;
            while (number % div == 0) {
                number /= div;
            }
            div += 1;
        }
        return acc;
    }

    private static int countDivisors(int number) {
        int acc = 1;
        return acc;
    }

    private static void solver() throws IOException {
        ToInt converter = new ToInt();
        int cases = readValue(" ", converter);
        while (cases > 0) {
            writer.println(countDivisors(readValue(" ", converter)));
            cases -= 1;
        }
    }


    public static void main(String[] args) throws IOException {
        solver();
    }
}
