package test.structure;

import java.util.*;

/**
 * Created by C.Lucas on 26/11/2015.
 */
public class Huffman {

    private static final int Q = 256;
    private static Node root;

    public class Node implements Comparable<Node> {
        private char character;
        private int frequency;
        private Node left, right;
        public Node(char character) {
            this.character  = character;
        }

        public Node(Node left, Node right) {
            this.left       = left;
            this.right      = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node o) {
            return  this.getFrequency() - o.getFrequency();
        }

        public void add() {
            this.frequency++;
        }

        public int getFrequency() {
            if(isLeaf())
                return frequency;
            return left.getFrequency() + right.getFrequency();
        }
        /**
         *
         * Usando uma busca em profundidade pela arvore de huffman
         * afim de criar uma tabela(Map) cuja chave eh um dos caracteres
         * que formam o txto e o valor e o codigo que referencia o caracter
         * para assim codificarmos o texto
         * */
        public void DFS(Map<Character, String> codeTable, String code) {
            // se o no percorrido for uma folha
            if(isLeaf()) {
                // adicionar o caracter e o codigo referente a ele
                codeTable.put(character, code);
                return;
            }
            // se descermos pela esquerda, adicione '0' ao codigo
            left.DFS(codeTable, code + '0');
            right.DFS(codeTable, code + '1');
        }
    }

    public static PriorityQueue<Node> frequencyChars(String word) {
        Map<Character, Node> f = new HashMap<Character, Node>();
        //int [] f = new int[Q];
        for(int i=0; i<word.length(); i++) {
            //f[word.charAt(i)]++; // char c = word.charAt(i);
            char ch = word.charAt(i);
            if( ! f.containsKey(ch))
                f.put(ch, new Huffman().new Node(ch));
            f.get(ch).add();
        }
        return new PriorityQueue<Node>(f.values());
    }

    public Node buildTree(PriorityQueue<Node> pq) {
        while(pq.size() > 1) {
            Node L = pq.poll();
            Node R = pq.poll();
            Node P = new Node(L,R);
            pq.add(P);
        }
        return  pq.peek();
    }

    public String encode(String text) {
        root = buildTree(frequencyChars(text));
        Map<Character, String> codeTable = new TreeMap<Character, String>();
        // no root ou raiz tem como codigo o caracter vazio ""
        root.DFS(codeTable, "");
        StringBuilder data = new StringBuilder();
        for(int i=0; i<text.length(); i++) {
            char ch = text.charAt(i);
            data.append(codeTable.get(ch));
        }
        return data.toString();
    }

    public static String decode(String text) {
        Node current = root;
        StringBuilder data = new StringBuilder();
        // faca uma busca na arvore, utilizando o texto codificado
        // para passar pelo no da esquerda caso '0' ou pelo no da direita
        // quando chegar na folha da arvore, volte ate a raiz
        for(int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            if(c == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            // eh a folha ?
            if(current.isLeaf()) {
                // pega o codigo
                data.append(current.character);
                // volta para raiz
                current = root;
            }
        }
        return data.toString();
    }

    public static void main(String[] args) {
        String text[] =  {
            "banana"
            ,"Ana ama sua nana, sua mana e banana"
            ,"https://www.youtube.com/watch?v=xQQt5myz00o"
        };;
        Huffman tree = new Huffman();
        String encoded = tree.encode(text[2]);
        System.out.println(encoded);
        String decoded = tree.decode(encoded);
        System.out.println(decoded);
    }
}
