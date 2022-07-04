package src.com.br.cp.ds.trees.bst.rec


class CompetitiveTreeNodeSearch<T : Comparable<T>>(
    val value: T,
    var le: CompetitiveTreeNodeSearch<T>,
    var ri: CompetitiveTreeNodeSearch<T>
) {

}