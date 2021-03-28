/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */

//https://www.urionlinejudge.com.br/judge/pt/problems/view/1246

public class URI1246 {
    
    private static Car[] list;

    static int preco;
    static int estacionamento;
    
    static class Car {
        private final String placa;
        private final int tamanho;
        private final boolean estacionado;
        private final int local;
        Car(String p, int t, boolean e, int l) {
            placa = p;
            tamanho = t;
            estacionado = e;
            local = l;
        }
    }
    
    public static void init(int n) {
        list = new Car[n];
        for(int i=0; i<n; i++)
            list[i] = new Car("", 0, false, -1);
        estacionamento = n;
        preco = 0;
    }
    

    public static int[] analise(int tamanho) {
        int r[] = new int[3], i = 0;
        boolean f = true;
        r[0] = 0;
        while(i<estacionamento && r[0] < tamanho) {
            if( ! list[i].estacionado ) {
                if(f) {
                    r[0] = 1;
                    r[1] = i;
                    r[2] = i;
                    f = false;
                } else {  
                    r[2] = i;
                    r[0] = (r[2] - r[1]) + 1;
                }
            } else {
                r[0] = 0;
                r[1] = 0;
                r[2] = 0;
                f = true;
            }
            i++;
        }
        return r;
    }
    
    public static void solution(String carro[]) {
        String placa = carro[1];
        char evento = carro[0].charAt(0);

        if(evento == 'C') {
            int tam = Integer.parseInt(carro[2]);
            int rs[] = analise(tam);
            int espaco = rs[0];
            int inicio = rs[1];
            int fim = rs[2];
            
            if( espaco == tam ) {
                preencherVaga(inicio, fim, new Car(placa, tam, true, inicio));
                preco += 10;
            } 
        }
        
        else if(evento == 'S') {
            removerCarro(placa);
        }
    }
    
    static void preencherVaga(int inicio, int fim, Car car) {
        // antes inicio < fim depois inicio <= fim
        while(inicio <= fim) {
            list[inicio++] = car;
        }
    }
    /*
    static void removerCarro(String placa) {
        boolean f = true;
        for(Car c : list) {
            if(c.placa.equals(placa) && c.estacionado) {
                for(int i = c.local; i<(c.local + c.tamanho); i++) {
                    list[i] = new Car(c.placa, c.tamanho, false, -1);
                }
                break;
            }
        }
    }
    */
        static void removerCarro(String placa) {
        boolean f = true; 
        for(int i=0 ; i<list.length; i++ ) {
            Car c = list[i];
            if(c.placa.equals(placa) && c.estacionado) {
                list[i] = new Car(c.placa, c.tamanho, false, -1);
                f = false;
            }
            else if( !f )
                break;
        }
    }
    public static void reader() {
        InputStream is = System.in;
        InputStreamReader  isp = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(isp);
        String str;
        String in[];
        StringBuilder sb = new StringBuilder();
        try {
            /*
            while( ! (s = buffer.readLine()).equals("0") ) {
            
            } 
            */
            
            /*
                str = buffer.readLine();
                int n = Integer.parseInt(sstr);
            */
            
            while( (str = buffer.readLine()) != null ) {
                int n, m, i;
                in = str.split(" ");
                n = Integer.parseInt(in[0]);
                
                if(n == 0)
                    break;
                
                m = Integer.parseInt(in[1]);

                init(n);
                preco = 0;
                for(i=0; i<m; i++) {
                    in = buffer.readLine().split(" ");
                    solution(in);
                }
                //System.out.println(preco);
                sb.append(preco).append("\n");
            }
            
            System.out.println(sb.toString());
            /*
                while( (in = buffer.readLine().split(" ")) != null ) {}
            */
            
            /*
                while( (s = buffer.readLine()) != null ) {}
            */
        } catch(IOException e) {}
    } 
}

/* casos de teste 

30 9
C 1000 10
C 1001 10
C 1002 10
S 1000
S 1002
C 1003 10
S 1001
C 1004 15
C 1005 5
0 0
0


*/