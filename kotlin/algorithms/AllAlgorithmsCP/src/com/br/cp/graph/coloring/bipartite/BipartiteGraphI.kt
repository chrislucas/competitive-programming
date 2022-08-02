package src.com.br.cp.graph.coloring.bipartite

import java.util.ArrayList

/*
    https://en.wikipedia.org/wiki/Bipartite_graph
    -----------------------------------------------------------------
        Defincao

        No campo de teoria dos grafos, um bipartite graph ou bigraph é um grafo
        cujos vertices podem ser dividos em 2 (conjuntos disjuntos) conjutos independentes
        U e V, de tal forma que sao arestas dos vertices em U para se conectar aos vertices em V.

        O conjunto de vertices de U e V sao chamados de partes do grafo. Equivalentemente, um bigraph
        é um grafo que nao contem nenhum ciclo com comprimento impar

        ciclos: https://en.wikipedia.org/wiki/Cycle_(graph_theory)


        Os 2 conjutos U e V podem ser pensados como uma coloracao do grafo com 2 cores.

            - Se colorimos os vertices do conjunto U de azul e os de V de verde, cada aresta tera
             um vertice de fim de cores diferentes, como é requerido num problema de coloracao de grafo

             - Torna-se impossivel colorir no caso de um grafo nao bipartido tal como num grafo triangular

                - No caso do grafo triangular, após colorir um vertice de azul e outro de verde, nao tem como
                colorir o terceiro nó por ele estar conectado aos 2 outros vertices
                - link para os nomes de grafos https://en.wikipedia.org/wiki/Gallery_of_named_graphs

       Um grafo bipartido é descrito da seguinte forma

       G = (U, V, E). As particoes sao U e V, com E denotando as arestas do grafo
            - Se o bigrafo nao eh conectado ele pode ter mais de uma biparticao

            - Nesse caso a notacao (U, V, E) eh util em especificar uma particular biparticao que
            pode ser de importancia numa aplicacao

            |U| = |V| significa que os 2 subconjutos tem cardinalidade igual, entao G é cahamado
            de balanced bipartite graph

            Se todos os vertices do mesmo lado da biparticao tem o mesmo grau, (numero de arestas que saem dum
            vertice ou analogamente numero de vertices adjancentes a um vertice) dizemos que G é biregular


            - Biregular graph: https://en.wikipedia.org/wiki/Biregular_graph

            - Grau:
                - https://pt.wikipedia.org/wiki/Grau_(teoria_dos_grafos)

       Propriedades
        - Quando modelamos relacoes entre duas diferentes classes de objetos, bipartite graph aparece frequentemente
        com naturalidade

            - Um grafo de jogadores de futebol e clubes

    -----------------------------------------------------------------
    https://www.geeksforgeeks.org/bipartite-graph/
 */


typealias Graph = ArrayList<ArrayList<Int>>


private fun graph(vertices: Int): Graph {
    // assim posso trabaljar com vertcies a partir do 0 ou 1
    val size = vertices + 1
    return with(ArrayList<ArrayList<Int>>(size)) {
        for (i in 0 until size) {
            this += arrayListOf<Int>()
        }
        this
    }
}

operator fun Graph.plusAssign(pair: Pair<Int, Int>) {
    val (p, q) = pair
    this[p] += q
}

/*
    https://www.geeksforgeeks.org/bipartite-graph/
    Um grafo bipartido é possivel se o for possivel aplicar a coloracao dos vertices
    do grafo apenas com 2 cores tal que os vertices num mesmo conjuto sao coloridos
    com a mesma cor

    - Note que é possivel colorir um grafo ciclico com ciclo par (numero par de vertices) usando 2 cores. Isso
    pode ser visto gráficamente no link acima

    - Note também que nao é possivel colorir um grafo ciclico com ciclos impares (numero impar de vertices)
     usando 2 cores . Veja a igura no ling acima

 */

fun Graph.isBipartite(): Boolean {
    return false
}


/*
    Abordagem usando backtracking
    https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
 */

fun Graph.isBigraph() {

}


fun main() {

}