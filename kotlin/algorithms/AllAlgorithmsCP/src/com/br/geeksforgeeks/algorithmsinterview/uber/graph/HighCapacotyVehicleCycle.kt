package src.com.br.geeksforgeeks.algorithmsinterview.uber.graph

import java.util.LinkedList
import java.util.Queue

/*
We have Uber HCV (High Capacity Vehicles) plying on the same routes in loops. Every route has a certain number of stops.
The routes are represented as 2D array eg [[1, 2, 7], [3, 6, 7]] where route[i] shows the route that the ith HCV takes.
For e.g 1st HCV route would be 1 -> 2 -> 7 -> 1 -> 2 -> 7... and so on, a directed graph
Find the minimum number of HCV ***_hops_*** needed given a source and a destination hop.
Return -1, if it's unable to reach the destination from the given source.

Example 1: Input: HCV routes: [[1, 2, 7], [3, 6, 7]] ...
Source: 1, Destination: 7 Output: 0 (get into the first HCV on stop 1 and get down at stop 7, no changes needed)
Source: 1, Destination: 6 Output: 1 (get into the first HCV on stop 1, transfer on stop 7 to the next HCV and then get down at stop 6 from the other HCV, hence it needed 1 change)

Example 2: HCV routes: [[1,2,3,4,5,6,7,8,9,10], [2,7]] ...
Source: 1, Destination: 7 Output: 0

Example 3: HCV routes: [[1, 2, 3], [3, 6, 9], [7, 8, 9]] ... hops for 1->3 = 0, 1->6 = 1, 1->7 = 2
'Keypad routes'

Example 4: HCV routes: [[1, 2, 3], [2, 5, 8], [3, 6, 9], [7, 8, 9]] ... hops for 1->9 = 1
*/

/*

1 -> [1, 2, 7]
2 -> [1, 2, 7]
7 -> [1, 2, 7]

3 -> [3, 6, 7]
6 -> [3, 6, 7]
7 -> [3, 6, 7] (combine with the above) 7 -> [1, 2, 3, 6]

Algorithm ...

Start at 1 end at 6 ...

1 can go to 2 or 7 => are any of these the end? no ...

Need to make 1 change on the stops on route that has 1

2 can go 1, 7 => are any of these the end? no ...
7 can go to 1, 2 ,3, 6 => are any of these the end? yes! so 1 -> 7 -> 6

*/


private fun solver(start: Int, end: Int, data: List<List<Int>>) {
    val graph = mutableMapOf<Int, ArrayList<Int>>()
    for (loop in data) {
        for (i in loop.indices) {
            if (graph[loop[i]] == null) {
                graph[loop[i]] = arrayListOf()
            }
            for (j in loop.indices) {
                if (loop[i] == loop[j])
                    continue
                graph[loop[i]]?.add(loop[j])
            }
        }
    }

    val visited = mutableMapOf<Int, Boolean>()
    val queue: Queue<Int> = LinkedList()

    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current == end) {
            break
        }
    }
    println(graph)
}


private fun checkSolver() {
    val cases = listOf(
        Pair(0, 7) to listOf(listOf(1, 2, 7), listOf(3, 6, 7))
    )

    cases.forEach { case ->
        val (pair, list) = case
        val (origin, destiny) = pair
        solver(origin, destiny, list)
    }
}

/*
    testar esse mesmo problema trocando a
 */


private fun solverWithRange(start: Int, end: Int, data: List<IntRange>) {

}

fun main() {
    checkSolver()
}