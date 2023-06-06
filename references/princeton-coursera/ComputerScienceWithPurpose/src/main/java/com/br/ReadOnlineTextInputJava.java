package com.br;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;

/**
 * IDEIA vinda desse link <a
 * href="https://stackoverflow.com/questions/36301905/how-to-download-export-txt-file-in-java">...</a>
 * Codigo util para juizes online.
 */
public class ReadOnlineTextInputJava {

  /**
   * @param file
   * @return lista de string onde cada indice contem a linha lida do arquivo TODO implementar o
   *     download como no arquivo
   * @see ReadOnlineTextInputKt
   */
  private static List<String> read(String file) throws MalformedURLException {
    var url = new URL(file);
    return Collections.emptyList();
  }

  public static void main(String[] args) {
    try {
      System.out.println(read("https://algs4.cs.princeton.edu/11model/cardsUnicode.txt"));
    } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
    }
  }
}
