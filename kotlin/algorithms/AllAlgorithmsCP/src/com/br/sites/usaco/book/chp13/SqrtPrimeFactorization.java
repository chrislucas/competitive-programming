package src.com.br.sites.usaco.book.chp13;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

/**
 * https://www.geeksforgeeks.org/prime-factor/?ref=lbp
 * https://www.calculatorsoup.com/calculators/math/prime-factors.php
 *
 * Calculadora
 * https://www.dcode.fr/prime-factors-decomposition
 */

public class SqrtPrimeFactorization {

    private static int countPrimeFactors(int number) {
        int acc = 1;
        int div = 2;
        while (div * div <= number) {
            if (number % div == 0)
                acc += 1;
            while (number % div == 0) {
                number /= div;
            }
            div += 1;
        }
        return acc;
    }

    private void checkCountFactors() {
        for (int i = 1; i < 20; i++) {
            System.out.printf("%d, %d\n", i, countPrimeFactors(i));
        }
    }

    private static Map<Integer, Integer> mapPrimeFactors(int number) {
        int divisor = 2;
        Map<Integer, Integer> map = new HashMap<>();
        while (divisor * divisor <= number) {
            while (number % divisor == 0) {
                number /= divisor;
                if (map.get(divisor) == null) {
                    map.put(divisor, 1);
                } else {
                    map.put(divisor, map.get(divisor) + 1);
                }
            }
            divisor += 1;
        }
        if (number > 1) {
            if (map.get(number) == null) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        return map;
    }

    private static void checkMapPrimeFactors() {
        for (int i = 190; i <= 200; i++) {
            System.out.printf("%d, %d\n", i, countPrimeFactors(i));
            System.out.println("Show Factors");
            show(mapPrimeFactors(i));
            System.out.println("************************************");
        }
    }

    private static void show(Map<Integer, Integer> map) {
        map.forEach((k, v) -> System.out.printf("%d, %d\n", k, v));
    }


    /**
     * https://www.geeksforgeeks.org/prime-factor/?ref=lbp
     */
    private static Map<Integer, Integer> mapPrimeFactorsSqrt(int number) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int divisor = 2; divisor <= sqrt(number); divisor++) {
            while (number % divisor == 0) {
                if (map.get(divisor) == null) {
                    map.put(divisor, 1);
                } else {
                    map.put(divisor, map.get(divisor) + 1);
                }
                number /= divisor;
            }
        }
        if (number > 1) {
            if (map.get(number) == null) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        return map;
    }

    private static void checkPrimeFactors() {
        for (int i = 1; i <= 1000; i++) {
            System.out.println(i);
            show(mapPrimeFactorsSqrt(i));
            System.out.println("****************");
        }
    }

    private static void checkResults() {
        int [] values = new int[] {1234567890, 315, 312};
        int value = values[2]; //new Random().nextInt(50000);
        System.out.printf("Número %d\n", value);
        System.out.printf("Quantidade de fatores primos: %d\n", countPrimeFactors(value));
        System.out.println("Fatores primos f1");
        show(mapPrimeFactors(value));
        System.out.println("Fatores primos f2");
        show(mapPrimeFactorsSqrt(value));
        System.out.println("FIM");
    }

    public static void main(String[] args) {
        //checkMapPrimeFactors();
        //checkPrimeFactors();
        checkResults();
    }
}
