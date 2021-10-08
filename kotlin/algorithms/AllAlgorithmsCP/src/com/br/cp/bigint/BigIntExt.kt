package src.com.br.cp.bigint

import src.com.br.cp.math.couting.systems.mod
import java.math.BigInteger
import java.math.BigInteger.ZERO

typealias BigInt = BigInteger


val BigInt.binary: String
    get() {
        var value = this
        val buffer = StringBuilder()

        while (value > ZERO) {
            buffer.append(value mod "2")
            value = value shr 1
        }

        return buffer.toString().reversed()
    }


val BigInt.grayDecode: BigInt
    get() {
        var g = this
        var decoded = ZERO
        while (g > ZERO) {
            decoded = decoded xor g
            g = g shr 1
        }
        return decoded
    }
