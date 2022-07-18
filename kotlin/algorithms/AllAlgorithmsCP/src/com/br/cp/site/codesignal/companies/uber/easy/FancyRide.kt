package src.com.br.cp.site.codesignal.companies.uber

/*
    https://app.codesignal.com/company-challenges/uber/4c3qzzQg8Zg9AfLKH
    DONE
 */

fun solution(l: Int, fares: MutableList<Double>): String {
    val cars = arrayOf("UberX", "UberXL", "UberPlus", "UberBlack", "UberSUV")
    var idx = 0
    for (fare in fares) {
        if (fare * l <= 20.0)
            idx += 1
        else
            break
    }
    return cars[idx]
}