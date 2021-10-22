package com.br.studies.ext.matrix

/*
    https://www.geeksforgeeks.org/sparse-matrix-representation/
    https://en.wikipedia.org/wiki/Sparse_matrix
 */

typealias SparseMatrix<K, V> = LinkedHashMap<K, ArrayList<V>>

operator fun SparseMatrix<Int, Int>.get(i: Int, j: Int) = this[i]?.get(j)

operator fun SparseMatrix<Int, Int>.set(i: Int, value: Int) {
    if (this[i] == null)
        this[i] = arrayListOf()
    this[i]?.add(value)
}