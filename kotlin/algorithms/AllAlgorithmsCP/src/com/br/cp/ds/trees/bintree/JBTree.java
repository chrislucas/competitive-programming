package src.com.br.cp.ds.trees.bintree;

/*
    https://www.geeksforgeeks.org/binary-tree-set-2-properties/
 */

public class JBTree {

    static class Node<T> {
        T value;
        Node<T> le, ri;
        Node(T value) {
            this.value = value;
            this.le = null;
            this.ri = null;
        }
    }


    public static void main(String[] args) {

    }
}
