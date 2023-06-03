package src.com.br.cp.basics.print


/**
 * https://www.baeldung.com/java-hexformat
 * https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/HexFormat.html
 * http://www.java2s.com/example/java-utility-method/hex-format-index-0.html
 * https://mkyong.com/java/how-to-convert-hex-to-ascii-in-java/
 *
 * https://www.tutorialspoint.com/how-to-convert-a-string-to-hexadecimal-and-vice-versa-format-in-java
 */

fun main() {
    println(String.format("%02x", 256))
    println(String.format("%03x", 256))
    println(String.format("%04x", 256))
    println(String.format("%08x, %d", 1024, 16 * 16 * 4))
    println(String.format("%08x", 1 shl  15))
    println(String.format("%08x, %d", 2048, 16 * 16 * 8))
    println(String.format("%08x", 1 shl 16))
}