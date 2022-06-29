package com.br.algo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IO {

  static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
  static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

  private static int readInt() throws IOException {
    return Integer.parseInt(buffer.readLine());
  }

  private static Long readLong() throws IOException {
    return Long.parseLong(buffer.readLine());
  }

  private static String readWord() throws IOException {
    return buffer.readLine();
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

  private static <T> T readValue(Converter<T> converter) throws IOException {
    return converter.map(buffer.readLine());
  }

  private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
    String[] data = buffer.readLine().split(del);
    List<T> values = new ArrayList<>();
    for (String value : data) {
      values.add(converter.map(value));
    }
    return values;
  }

  private static <T> List<T> readValues(Converter<T> converter) throws IOException {
    return readValues(" ", converter);
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

  private static <T> String joinToString(String del, List<T> values) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.size(); i++) {
      T value = values.get(i);
      if (i == 0) {
        sb.append(value);
      } else {
        sb.append(String.format("%s%s", del, value));
      }
    }
    return sb.toString();
  }
}
