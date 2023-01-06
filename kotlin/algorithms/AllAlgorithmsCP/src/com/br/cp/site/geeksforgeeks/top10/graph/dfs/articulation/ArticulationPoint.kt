package src.com.br.cp.site.geeksforgeeks.top10.graph.dfs.articulation

import java.lang.Integer.min

/*
    TODO
    https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
    Dado um grafo, encontre o ponto de articulacao

    - um vertice num grafo nao direcionado é um ponto de articulacao o cut vertext se ao
    remove-lo o grafo fica desconexo

        - Pontos de articulacao representam vulnerabilidae numa rede de conexoes
        - pontos que podem dividir a rede em 2 ou mais componentes
    - Para um grafo desconexo nao direcionado, um ponto de articulacao e um vertice que se removido que
    aumenta o numero de componentes conexos

    CONDICOES PARA ENCONTRAR PONTOS DE ARTICULACAO
    Um vertice u e um ponto de articulacao se um dos 2 casos for verdadeiro

    1 - u e um vertice raiz de uma DFS tree e tem ao menos 2 vertices filhos
    2 - u nao e um vertice raiz de uma DFS tree e tem um vertice filho v que nenhum vertice de uma subarvore
    cujo vertice raiz e o proprio v tem uma ARESTA DE VOLTA para um vertice ancestral na arvore formada
    pela DFS a partir de u

 */
private typealias SimpleAdjList = ArrayList<ArrayList<Int>>

private class ArticulationPointGraph(private val size: Int) {

    val graph = SimpleAdjList()

    init {
        for (i in 0..size) {
            graph += arrayListOf<Int>()
        }
    }

    operator fun plusAssign(edge: Pair<Int, Int>) {
        val (u, v) = edge
        graph[u] += v
        graph[v] += u
    }

    operator fun plusAssign(edges: Array<Pair<Int, Int>>) {
        for (edge in edges) {
            plusAssign(edge)
        }
    }

    // tarjan
    fun articulationPoint(): Array<Boolean> {
        /*
            Usamos uma dfs para veriricar os pontos de articulacao no grafo. Numa
            dfs formamos uma Arvore de vertices chamada de
            DFS tree ao comecar a navegacao por um vertice u qualquer.
            Na DFS tree um vertice u e pai de um vertice v se v foi alcancado através de u

            Na DFS Tree um vertice u e um ponto de articulacao se uma das 2 seguintes condicoes
            for verdadeira

            1) u e um vertice raiz da DFS Tree e tem ao menos 2 filhos
            2) u nao e o no raiz da DFS tree e possui um vertice v filho tal que nenhum
            vertice na subarvore que v está tem uma aresta de volta (back edge) para
            um dos vertices ancestrais na DFS tree formada a partir do vertice u
         */

        val discoveryTime = Array(size) { 0 }
        val lowestParent = Array(size) { 0 }
        val visited = Array(size) { false }
        val isArticulationPoint = Array(size) { false }

        val noParent = -1

        for (u in 0 until size) {
            if (!visited[u]) {
                dfs(
                    u,
                    noParent,
                    visited,
                    discoveryTime,
                    lowestParent,
                    isArticulationPoint,
                    1
                )
            }
        }

        return isArticulationPoint
    }

    private fun dfs(
        u: Int,
        parent: Int,
        visited: Array<Boolean>,
        discoveryTime: Array<Int>,
        lowestParent: Array<Int>,
        isArticulationPoint: Array<Boolean>,
        time: Int
    ) {
        /*
            Passos
            - Fazer a dfs no grafo
                - na dfs guardar o vertice pai de um em parent[u]
                caso 1
                - para checar se u e um vertice raiz de uma dfs tree e se
                tem ao menos 2 filhos, para cada vertices contar a quantidade de villhos
                usando o vetor children
                    - Se o vertice atual u for raiz (parent[u] = -1) e tiver mas de 2 filhos
                    esse vertice u eh um ponto de articulacao

               caso 2
               - quando vertice u nao e raiz da dfs tree e ALCANCA um vertice v
               que de modo que nenhum vertice na subarvore formada da DFS com raiz
               em v (filho de v) tenha uma aresta de volta para um vertice raiz na arvore
               formada da DFS a partir de u.
                    - Para isso precisamos manter um array discovery onde discovery[u]
                    diz quando o vertice u foi alcançado
              - Para cada vertice u, descobrir qual o vertice alcançado em menor tempo
              que pode ser alcancado a na subarvore cuja raiz e u.
                - Para isso temos um array low
                    low[u] = min(disc[u]. disc[ancestor]) onde 'ancestor' e o vertice ancestral
                    de u e tem um areata de u de volta para w

         */
        visited[u] = true
        discoveryTime[u] = time
        lowestParent[u] = time
        var childrens = 0
        for (v in graph[u]) {
            /*
                Se v nao foi visitado entao seguimos com a busca em profundidade
                construindo a dfs tree onde v eh filho de u (u <- v)
             */
            if (!visited[v]) {
                childrens += 1
                dfs(
                    v,
                    u,
                    visited,
                    discoveryTime,
                    lowestParent,
                    isArticulationPoint,
                    time + 1
                )
                /*
                    Checa se a subarvore com a raiz em v tem conexao com algum vertice
                    antecessor a u
                 */
                lowestParent[u] = min(lowestParent[u], lowestParent[v])
                /*
                     Caso 2
                     Se u nao for raiz (parent != -1) e o menor vertice (identificador) ancestral low[v]
                     e maior que a quantidade de vertices que foi necessario alcançar para chever em u
                     entao u eh um ponto de articulacao
                 */
                if (parent != -1 && lowestParent[v] >= discoveryTime[u]) {
                    isArticulationPoint[u] = true
                }
            } else if (v != parent) {
                // atualizar o antecessor de u para o menor valor
                lowestParent[u] = min(lowestParent[u], discoveryTime[v])
            }
        }
        /*
            Caso 1
            Se u for vertice raiz da subarvore e tiver mais de 2 vertices filhos
            u eh um ponto de articulacao
         */
        if (parent == -1 && childrens > 1) {
            isArticulationPoint[u] = true
        }
    }

}


private fun check() {
    arrayOf(
        arrayOf(0 to 1, 1 to 2, 2 to 3) to 4,
        arrayOf(0 to 1, 0 to 2, 1 to 2, 1 to 3, 1 to 4, 1 to 6, 3 to 5, 4 to 5) to 7,
        arrayOf(0 to 1, 0 to 2, 1 to 2, 1 to 3, 1 to 4, 1 to 5) to 7,
        arrayOf(1 to 0, 0 to 2, 2 to 1, 0 to 3, 3 to 4) to 5
    ).forEach { (edges, size) ->
        val articulation = ArticulationPointGraph(size)
        articulation += edges
        val articulationPoint = articulation.articulationPoint()
        val group = mutableMapOf<Boolean, MutableList<Int>>()
        articulationPoint.forEachIndexed { idx, value ->
            group[value]?.plusAssign(idx)
        }
        println(group)
    }
}

fun main() {
    check()
}