package com.br.maratona.spoj.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Done
 * @author C.Lucas
 * http://br.spoj.com/problems/OLIMPJ09/
 * http://www.caelum.com.br/apostila-java-orientacao-objetos/um-pouco-de-arrays/#5-8-testando-o-conhecimento
 * 
 * http://www.dm.ufscar.br/~waldeck/curso/java/part23.html
 * http://www.guj.com.br/java/114831-duvida-basica-na-declaracao-do-metodo-main
 */
public class SPOJ11675 {
    static class Pais implements Comparable<Pais> {
        int medalhas;
        int indice;
        Pais(int medalhas, int indice) {
            this.medalhas = medalhas;
            this.indice = indice;
        }
        public void adicionaMedalha(int n) {
            this.medalhas +=  n;
        }
        @Override
        public int compareTo(Pais o) {
            if(this.medalhas > o.medalhas) {
                return -1;
            }
            else if(this.medalhas == o.medalhas) {
                if(this.indice < o.indice) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }
        
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String in[];
        try{
            in = buffer.readLine().split(" ");
            int paises, modalidades;
            paises = Integer.parseInt(in[0]);
            modalidades = Integer.parseInt(in[1]);
            
            int p, s, t;
            Pais[] lista = new Pais[paises];

            for(int i=0; i<paises; i++) {
                lista[i] = new Pais(0, i);
            }
            
            String m[];
            
            for(int i=0; i<modalidades; i++) {
              
                m = buffer.readLine().split(" ");
                p = Integer.parseInt(m[0]);
                s = Integer.parseInt(m[1]);
                t = Integer.parseInt(m[2]);
                lista[p - 1].adicionaMedalha(1);
                lista[s - 1].adicionaMedalha(1);
                lista[t - 1].adicionaMedalha(1);
            }
            
            Arrays.sort(lista);
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<paises; i++) {
                String str = (i == 0) ? "" : " ";
                sb.append(str).append(lista[i].indice + 1);
            }
            System.out.println(sb.toString());
        } catch(IOException e) {}
    }
}
