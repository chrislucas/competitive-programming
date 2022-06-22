package src.com.br.cp.ds.trees.bst.rec


class CompBST<T : Comparable<T>>(val value:T, var le: CompBST<T>, var ri: CompBST<T>){
}