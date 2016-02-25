/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.math;

import java.io.PrintWriter;

/**
 *
 * @author C.Lucas
 */
public class Palindrome {

    /**
     * http://www.paulomarques.com.br/arq14-1.htm
     *  Mudança de bases em logaritmos
     *  log b na base a = c 
     *  Se queremos resolver algo do tipo
     *  log 100 base 2, porem nao sabemos resolve-lo podemos trocar as bases
     *  usando a seguinte formula
     *  log b na base a  = (log b na base c / log a na base c(
     *  ou seja trocamos as bases e a base do logaritmo anterior sera o novo
     *  logaritmoando
     *  vejamos?
     *  log 100 base 2 = (log 100 base 10 / log 2 base 10) = 2 / 0.3010 = 6,6445
     *  
     */
    
    
    /**
     * @param b
     * @param e
     * @return 
     */
    
    public static double power(int b, int e) {
        return 0.0;
    }
    
    
    public static boolean palindrome(int a) {
        int b = a, c = 0;
        int digitos, base;
        // descobrindo quantos digitos um numero possui, utilizando logaritmo
        // http://www.paulomarques.com.br/arq14-9.htm
        digitos = howManyDigits(a);
        base = (int)Math.pow(10, digitos - 1);
        while(digitos > 0) {
            c += (b % 10) * base;
            base /= 10;
            b /= 10;
            digitos--;
        }
        return a == c;
    }
    // quantos digitos a ^ e possui
    // floor( log a ) + 1
    public static int howManyDigits(int a) {
        return (int) Math.floor(Math.log10(a)) + 1;
    }
    
    // quantos digitos a ^ e possui ?
    // e * log a + 1; 
    public static int howManyDigits(int a, int e) {
        return  (int) (e * Math.log10(a) + 1);
    }
    
    public static boolean palindrome(char [] a) {
        return false;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        new PrintWriter(System.out, true).printf("%s\n%d\n", 
                palindrome(2642462) ? "true" : "false",
                howManyDigits(10, 102));
    }
    
}
