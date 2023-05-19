package src.com.br.kotlin.chuncked;

import java.util.ArrayList;
import java.util.List;

public class ChuckData {

  private static <T> ArrayList<ArrayList<T>> chunck(List<T> data, int size) {
    ArrayList<ArrayList<T>> values = new ArrayList<>();
    ArrayList<T> partial = new ArrayList<>();
    for (int i = 1; i <= data.size(); i++) {
      partial.add(data.get(i - 1));
      if (i % size == 0) {
        values.add(partial);
        partial = new ArrayList<>();
      }
    }
    if (partial.size() > 0) {
      values.add(partial);
    }
    return values;
  }

  private static <T> String join(List<T> values) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < values.size(); i++) {
      if (i > 0) {
        sb.append(String.format(", %s", values.get(i)));
      } else {
        sb.append(String.format("%s", values.get(i)));
      }
    }
    sb.append("]");
    return sb.toString();
  }

  private static void testChunck() {
    List<Integer> sample = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    for (int i = 1; i <= sample.size(); i++) {
      ArrayList<ArrayList<Integer>> data = chunck(sample, i);
      System.out.printf("Size = %d\n", i);
      for (List<Integer> values : data) {
        System.out.println(join(values));
      }
      System.out.println("****************");
    }
  }

  public static void main(String[] args) {
    testChunck();
  }
}
