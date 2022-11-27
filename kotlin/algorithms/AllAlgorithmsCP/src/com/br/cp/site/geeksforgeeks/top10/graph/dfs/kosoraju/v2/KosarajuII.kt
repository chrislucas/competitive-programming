package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.kosoraju.v2

/*
    TODO

    SCC - Strong connected components (componentes fortemente conectados)
    https://www.topcoder.com/thrive/articles/tarjans-algorithm-for-strongly-connected-components
    "Definido como um ciclo autocontido dentro de um grafo direcinado, onde cada vertice
    num dado ciclo pode alcançar outros vertices no mesmo ciclo"

    No link acima tem um desenho de um grafo que descreve bem o que é um conjunto de componentes
    fortemente acoplados num grafo.

    A imagem mosgtra um grafo que possui 4 componentes, cada um com seu proprio ciclo. Nao existe
    uma forma de encontrar um caminho que leva de um componente a outro e depois de volta ao primeiro.
    Essa propriedade garante que um SCC(componente) num grafo é unico


    https://www.topcoder.com/thrive/articles/kosarajus-algorithm-for-strongly-connected-components


 */


class Node(val adj: MutableList<Int>, val reverseAdj: MutableList<Int>)

private class Graph(val g: Array<Node>) {

    fun dfs(target: Int) {

    }

}

fun main() {

}