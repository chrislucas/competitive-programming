package src.com.br.cp.ext.bigint



import java.math.BigInteger
import java.math.BigInteger.ONE
import java.math.BigInteger.ZERO

typealias BigInt = BigInteger


infix fun BigInt.mod(value: String): BigInt = this.mod(BigInt(value))

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

val BigInt.grayEncode: BigInt
    get() = this xor (this shr 1)


val BigInt.nextPowerOf2: BigInt
    get() {
        var value = this
        value -= ONE
        value = value or (value shr 1)
        value = value or (value shr 2)
        value = value or (value shr 4)
        value = value or (value shr 8)
        value = value or (value shr 16)
        return value + ONE
    }

fun main() {
    println(BigInt("120").nextPowerOf2)
}