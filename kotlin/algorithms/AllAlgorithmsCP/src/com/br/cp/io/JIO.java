package src.com.br.cp.io;

import src.com.br.sites.usaco.book.chp13.problems.cses.CountingDivisors;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JIO {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private interface Converter<T> {
        T converter(String data);
    }

    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String s = null;
        List<T> values = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            values.add(converter.converter(s));
        }
        return values;
    }

    private static <T> T readValue(String del, Converter<T> converter) throws IOException {
        return converter.converter(reader.readLine());
    }

    static class ToLong implements Converter<Long> {
        @Override
        public Long converter(String data) {
            return Long.parseLong(data);
        }
    }


    static class ToInt implements Converter<Integer> {
        @Override
        public Integer converter(String data) {
            return Integer.parseInt(data);
        }
    }

    static class ToDouble implements Converter<Double> {
        @Override
        public Double converter(String data) {
            return Double.parseDouble(data);
        }
    }
}
