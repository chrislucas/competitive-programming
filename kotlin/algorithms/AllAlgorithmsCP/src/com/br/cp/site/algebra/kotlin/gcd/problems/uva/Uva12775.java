package src.com.br.cp.site.algebra.kotlin.gcd.problems.uva;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4628
 */
public class Uva12775 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private interface Converter<T> {
        T converter(String data);
    }

    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String s = null;
        List<T> number = new ArrayList<>();
        while ((s = reader.readLine()) != null) {
            number.add(converter.converter(s));
        }
        return number;
    }

    private static <T> T readValue(String del, Converter<T> converter) throws IOException {
        return converter.converter(reader.readLine());
    }

    public static void main(String[] args) {

    }
}
