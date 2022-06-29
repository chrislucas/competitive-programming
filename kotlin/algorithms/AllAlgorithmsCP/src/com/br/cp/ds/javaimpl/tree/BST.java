package src.com.br.cp.ds.javaimpl.tree;

public class BST {


    static <T> Treenode<T> toBst(T[] values) {
        for(T value : values) {

        }
        return null;
    }

    private static void checkInsert() {
        Treenode<Integer> node = new Treenode<>(30);
    }

    public static void main(String[] args) {

    }

    static class Treenode<T> {
        T value;
        Treenode<T> le, ri;

        Treenode(T value) {
            this.value = value;
        }

        void insert(T value) {

        }

        private void insert(Treenode<T> node, T value) {

        }

        String transversal(String order) {
            StringBuilder sb = new StringBuilder();
            transversal(this, sb);
            return sb.toString();
        }

        private void transversal(Treenode<T> node, StringBuilder sb) {
            return;
        }

        T delete() {
            return null;
        }
    }
}
