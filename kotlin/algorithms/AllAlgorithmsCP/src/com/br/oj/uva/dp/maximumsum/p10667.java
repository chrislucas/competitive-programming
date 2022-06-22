package src.com.br.oj.uva.dp.maximumsum;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&category=227&page=show_problem&problem=1608
 */
public class p10667 {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    interface TestCase {
        void run() throws IOException;
    }

    private static void testCases(int cases, TestCase testCase) throws IOException {
        while (cases > 0) {
            testCase.run();
            cases -= 1;
        }
    }

    private interface Converter<T> {
        T convert(String data);
    }

    private static <T> T readValue(Converter<T> converter) throws IOException {
        return converter.convert(reader.readLine());
    }

    private static <T> List<T> readValues(String del, Converter<T> converter) throws IOException {
        String[] data = reader.readLine().split(del);
        List<T> values = new ArrayList<>();
        for (String value : data) {
            values.add(converter.convert(value));
        }
        return values;
    }


    public static void main(String[] args) {

    }
}
