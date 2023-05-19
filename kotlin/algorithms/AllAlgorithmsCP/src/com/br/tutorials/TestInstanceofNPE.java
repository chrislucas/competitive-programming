package src.com.br.tutorials;

import java.io.IOException;

public class TestInstanceofNPE {

  private static boolean isIOException(Exception exception) {
    return exception instanceof IOException;
  }

  private static boolean otherIsIOException(Exception e) {
    return IOException.class.isInstance(e);
  }

  public static void main(String[] args) {
    System.out.println(isIOException(null));
    System.out.println(isIOException(new RuntimeException("Teste")));
  }
}
