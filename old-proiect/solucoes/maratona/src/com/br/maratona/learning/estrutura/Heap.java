/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.br.maratona.learning.estrutura;

import java.util.Random;

/**
 *
 * @author C.Lucas
 */


//http://professor.unisinos.br/pjaques/material/est2/8-heap.pdf

public class Heap {
    
    public static void buildMaxHeap(int heap[], int n) {
        int index, length, sh = heap.length - 2;
        // montando o heap
        if(n == 0) {
            for(index = (sh / 2); index >= 0; index--) {
                recMaxHeapify(heap, index, sh);
            } 
        } else {
            for(index = (sh / 2); index >= 0; index--) {
                itMaxHeapify(heap, index, sh);
            } 
        }
    }
    // o algoritmo de heapsort, utiliza o algoritmo de heapify
    public static void heapsort(int heap[], int n) {
        int index, sh = n - 1;
        
        for(index = (sh / 2); index >= 0; index--) {
            itMaxHeapify(heap, index, sh);
        }
        // imprimindo o heap
        printHeap(heap, n);
        // depois de montar o tree heap, começar do ultimo elemento
        // o primeiro elemento do heap eh sempre o maior elemento do vetor
        // entao basta coloca-lo na ultimo posicao, diminuir o tamanho do vetor
        // e redefinir o heap com a funcao heapify que vai trocar, se necessario
        // novamente o no raiz por um dos filhos transformando o vetor num heap
        // quando o primeiro indice do vetor nao for maior nao sera necessario 
        // ajustar o heap
        while(sh > 0) {
            int temp = heap[sh];
            heap[sh] = heap[0];
            heap[0] = temp;
            --sh;
            itMaxHeapify(heap, 0, sh);
        }
    }
    
    // metodo para corrigir um heap
    // um heap possui a propriedade em que um elemento no nó raiz deve 
    // ser maior que seus no so filhos
    // esse método visa corrigir o vetor para manter tal propriedade 
    
    /**
     * recursivo
     * @param heap
     * @param index
     * @param sh        tamanho do heap menos 1
    */
    public static void recMaxHeapify(int heap[], int index, int sh) {
        int l,              // indice do no da esquerda 
            r,              // indice do no da direita
            max;            // maior valor
        
        l = left(index); 
        r = right(index);
        max = index;
        // corrige descendo na arvore heap
        // verificar se o no a esquerda da arvore pe menor que o no pai
        if(l <= sh && heap[l] > heap[index]) {
            max = l;
        }
        // ou o no da direira
        if(r <= sh && heap[r] > heap[max]) {
            max = r;
        }
        // se ha um no filho com valor menor que seu pai,
        // faca a troca e suba esse valor para o noh pai
        if(max != index) {
            int swap = heap[index];
            heap[index] = heap[max];
            heap[max] = swap;
            recMaxHeapify(heap, max, sh);
        }
    }
    
    public static void itMaxHeapify(int heap[], int index, int sh) {
        int l,              // indice do no da esquerda 
            r,              // indice do no da direita
            max;            // maior valor
        max = index;
        // enaqunto houver trocas entre no esquerdo ou direito com seus respectivos nos pais
        // manter um loop
        while(true) {
            l = left(index); 
            r = right(index);
            // corrige descendo na arvore heap
            // verificar se o no a esquerda da arvore pe menor que o no pai
            if(l <= sh && heap[l] > heap[index]) {
                max = l;
            }
            // ou o no da direira
            if(r <= sh && heap[r] > heap[max]) {
                max = r;
            }
            // se ha um no filho com valor menor que seu pai,
            // faca a troca e suba esse valor para o noh pai
            if(max != index) {
                int swap = heap[index];
                heap[index] = heap[max];
                heap[max] = swap;
                index = max;
            } else {
                break;
            }
        }
    }
    //retorna on indice do nó raiz do heap (i/2)
    public static int root(int i) {
        return ((i + 1)/2);     // correcoes para adequar com valores de indices na linguagem de programacao
    }
    // retorna o indice do nó folha a esquerda da raiz 2*i
    public static int left(int i) {
        return (2*i) + 1;       // correcoes para adequar com valores de indices na linguagem de programacao
    }
    // retorna o indice do nó folha a direita da raiz (2*i)+1
    public static int right(int i) {
        return (2*i) + 2;       // correcoes para adequar com valores de indices na linguagem de programacao
    }
    //print heap
    public static void printHeap(int heap[], int sh) {
        for(int i=0; i<sh; i++) {
            System.out.print(heap[i]+",");
        }
        System.out.println("");
    }
    
    public static void insert(int n) {
        
    }
    
    public static void delete(int n) {
        
    }
    /*
    public static void main(String[] args) {
        
        int limit = 20;
        int n[] = new int[limit];
        int m[] = new int[limit];
        Random r = new Random();
        for(int i=0; i<limit; i++) {
            int t =  r.nextInt(limit);
            m[i] = t;
            n[i] = t;
        }
        
        /*
        int n[] = {13,8,10,17,6,10,1,18,19,18,2,13,15,12,7,0,12,9,1,19};
        int m[] = {13,8,10,17,6,10,1,18,19,18,2,13,15,12,7,0,12,9,1,19};
        */
        /*
            {4, 1, 3, 2, 16, 9, 10, 14, 8, 7}
            {20,17,22,15,19,21,23,15,34,12,60}
            {5,4,9,7,19,8,17,2,6,5,21}
        */
        long s, e;
/*       
        //printHeap(n, n.length - 1);
        s = System.currentTimeMillis();
        buildMaxHeap(n, 0);
        e = System.currentTimeMillis();
        //printHeap(n, n.length - 1);
        System.out.println( (e - s) / 1000);
 */      
     /*  
        //criando outro vetor igual ao 'n' para testar o algoritmo heapify iterativo
        printHeap(m, limit);
        //s = System.currentTimeMillis();
        //buildMaxHeap(m, 0);
        //e = System.currentTimeMillis();
        //System.out.println( (e - s) / 1000);
        
        // testando oalgoritmo heapsort
        heapsort(m, limit);
        printHeap(m, limit);
    }
    */
}
