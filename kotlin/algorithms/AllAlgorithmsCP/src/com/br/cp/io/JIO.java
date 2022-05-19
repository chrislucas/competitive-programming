package src.com.br.cp.io;

import src.com.br.sites.usaco.book.chp13.problems.cses.CountingDivisors;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JIO {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private interface Converter<T> {
        T convert(String data);
    }


    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String[] data = reader.readLine().split(del);
        List<T> values = new ArrayList<>();
        for (String value : data) {
            values.add(converter.convert(value));
        }
        return values;
    }

    private static <T> T readValue(Converter<T> converter) throws IOException {
        return converter.convert(reader.readLine());
    }

    private static int readInt() throws IOException {
        return readValue(Integer::parseInt);
    }

    private static List<Integer> readInts(String del) throws IOException {
        return readValues(del, Integer::parseInt);
    }


    private static List<Long> readLongs(String del) throws IOException {
        return readValues(del, new ToLong());
    }

    static class ToLong implements Converter<Long> {
        @Override
        public Long convert(String data) {
            return Long.parseLong(data);
        }
    }

    static class ToInt implements Converter<Integer> {
        @Override
        public Integer convert(String data) {
            return Integer.parseInt(data);
        }
    }

    static class ToDouble implements Converter<Double> {
        @Override
        public Double convert(String data) {
            return Double.parseDouble(data);
        }
    }

    interface TestCase {
        void run();
    }

    private static void testCases(int cases, TestCase testCase) throws IOException {
        while (cases > 0) {
            testCase.run();
            cases -= 1;
        }
    }


    private static <T> void runWhileIsNotNull(Converter<T> converter) throws IOException {
        String enter;
        while ((enter = reader.readLine()) != null) {
            converter.convert(enter);
        }
    }
}
