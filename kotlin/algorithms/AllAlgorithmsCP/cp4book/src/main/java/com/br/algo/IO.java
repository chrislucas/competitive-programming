package com.br.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {

    private static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private static int readInt() throws IOException {
        return Integer.parseInt(buffer.readLine());
    }

    private static int [] readIntValues() throws IOException {
        return readIntValues(" ");
    }

    private static int [] readIntValues(String delimiter) throws IOException {
        String[] memory = buffer.readLine().split(delimiter);
        int [] values = new int[memory.length];
        for (int i = 0; i < memory.length; i++)
            values[i] = Integer.parseInt(memory[i]);
        return values;
    }

    private static <T> void println(String format, T data) {
        writer.println(String.format(format, data));
    }


    private static List<String> readWords(String del) throws IOException {
        return Arrays.asList(buffer.readLine().split(del));
    }

    interface Converter<T> {
        T map(String data);
    }

    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String[] data = buffer.readLine().split(del);
        List<T> values = new ArrayList<>();
        for (String value : data) {
            values.add(converter.map(value));
        }
        return values;
    }

    private static List<Integer> readInts(String del) throws IOException {
        return readValues(del, Integer::parseInt);
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
        while ((enter = buffer.readLine()) != null) {
            converter.map(enter);
        }
    }


    public static void main(String[] args) {
        System.out.println(0xff);
    }
}
