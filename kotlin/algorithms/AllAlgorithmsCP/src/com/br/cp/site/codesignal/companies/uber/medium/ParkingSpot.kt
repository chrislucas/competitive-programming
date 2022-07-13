package src.com.br.cp.site.codesignal.companies.uber.medium

import kotlin.math.abs

/*
https://app.codesignal.com/company-challenges/uber/XHNFMPBYsqNyhx9PP
 */

fun solution(
    carDimensions: MutableList<Int>,
    parkingLot: MutableList<MutableList<Int>>,
    luckySpot: MutableList<Int>
): Boolean {


    val l = carDimensions[0]
    val w = carDimensions[1]

    val spotLenth = abs(luckySpot[1] - luckySpot[3])
    val spotWidth = abs(luckySpot[0] - luckySpot[2])

    if (l > spotLenth || w > spotWidth) {
        return false
    }

    var rl = 0
    var isPossible = true

    for (i in 0 .. luckySpot[2]) {
        for (j in luckySpot[1] .. luckySpot[3]) {

        }
    }

    /*
    for (i in luckySpot[0] .. luckySpot[2]) {
        var rw = 0


        for (j in 0 until parkingLot[i].size) {
            if (parkingLot[i][j] == 1) {
                rl = 0
                break
            }
            rw += 1

        }
        rl += 1
    }

     */



    return isPossible
}


fun main() {

}