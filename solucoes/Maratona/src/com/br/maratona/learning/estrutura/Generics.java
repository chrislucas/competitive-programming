    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.maratona.learning.estrutura;

/**
 *
 * @author C.Lucas
 * 
 * 
 */
public class Generics {
    Box<Integer> boxInt;
    Pair<Integer, Integer> p = new Pair<>(1,2);
    Pair<Integer, Box<Integer>> p2;
}
