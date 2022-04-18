package src.com.br.sites.usaco.book.chp13

fun sum(a: Int, b: Int, m: Int) =  (a % m  + b % m ) % m

fun minus(a: Int, b: Int, m: Int) =  (a % m  - b % m ) % m

fun multi(a: Int, b: Int, m: Int) =  (a % m  * b % m ) % m

// exp = a ^ b mod m = (a mod m) ^ b mod m