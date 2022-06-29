package src.com.br.cp.ds.trees.bst.levelordertransversal.problems.uri;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
   https://www.beecrowd.com.br/judge/en/problems/view/1466
   DONE
*/
public class Problem1466 {

  static final BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
  static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

  interface Converter<T> {
    T map(String data);
  }

  private static <T> T readValue(Converter<T> converter) throws IOException {
    return converter.map(buffer.readLine());
  }

  private static <T> List<T> readValues(Converter<T> converter) throws IOException {
    return readValues(" ", converter);
  }

  private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
    String[] data = buffer.readLine().split(del);
    List<T> values = new ArrayList<>();
    for (String value : data) {
      values.add(converter.map(value));
    }
    return values;
  }

  interface TestCase {
    void run(int counter) throws IOException;
  }

  private static void testCases(int cases, TestCase testCase) throws IOException {
    int counter = 1;
    while (cases > 0) {
      testCase.run(counter);
      cases -= 1;
      counter += 1;
    }
  }
  // FIM IO

  static class BSTree<T extends Comparable<T>> {
    static class Node<T> {
      T value;
      Node<T> le, ri;

      public Node(T value) {
        this.value = value;
      }

      @Override
      public String toString() {
        return String.format("%s", value);
      }
    }

    BSTree(T value) {
      this.root = new Node<>(value);
    }

    Node<T> root;

    Node<T> insert(T value) {
      root = insert(root, value);
      return root;
    }

    Node<T> insert(Node<T> node, T value) {
      if (node != null) {
        if (node.value.compareTo(value) > 0) {
          node.le = insert(node.le, value);
        } else {
          node.ri = insert(node.ri, value);
        }
        return node;
      } else {
        return new Node<>(value);
      }
    }

    List<T> levelOrderTransversal() {
      List<T> rs = new ArrayList<>();
      Queue<Node<T>> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        Node<T> temp = queue.poll();
        if (temp != null) {
          rs.add(temp.value);
          if (temp.le != null) {
            queue.add(temp.le);
          }
          if (temp.ri != null) {
            queue.add(temp.ri);
          }
        }
      }
      return rs;
    }
  }

  static <T extends Comparable<T>> BSTree<T> toBst(List<T> values) {
    BSTree<T> tree = null;
    if (!values.isEmpty()) {
      tree = new BSTree<>(values.get(0));
      for (int i = 1; i < values.size(); i++) {
        tree.insert(values.get(i));
      }
    }
    return tree;
  }

  private static void solver() throws IOException {
    testCases(
        readValue(Integer::parseInt),
        counter -> {
          int s = readValue(Integer::parseInt);
          List<Integer> values = readValues(Integer::parseInt);
          BSTree<Integer> tree = toBst(values);
          List<Integer> data = tree.levelOrderTransversal();
          System.out.printf("Case %d:\n%s\n", counter, joinToString(" ", data));
        });
  }

  private static void anotherSolver() throws IOException {
    int cases = Integer.parseInt(buffer.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= cases; i++) {
      int s = Integer.parseInt(buffer.readLine());
      List<Integer> values = new ArrayList<>();
      for (String value : buffer.readLine().split(" ")) {
        values.add(Integer.parseInt(value));
      }
      BSTree<Integer> tree = toBst(values);
      List<Integer> data = tree.levelOrderTransversal();
      sb.append(
          String.format(
              i == 1 ? "Case %d:\n%s\n" : "\nCase %d:\n%s\n", i, joinToString(" ", data)));
    }
    writer.println(sb);
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

  public static void main(String[] args) throws IOException {
    anotherSolver();
  }
}
