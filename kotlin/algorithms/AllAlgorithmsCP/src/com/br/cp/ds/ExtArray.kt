package src.com.br.cp.ds

private inline fun <reified T> Array<T>.copy(): Array<T> {
    val cp = Array(this.size) { T::class.java.getDeclaredConstructor().newInstance() }
    System.arraycopy(this, 0, cp, 0, this.size)
    return cp
}

private inline fun <reified T> Array<T>.copy(srcPos: Int, destPos: Int): Array<T> {
    val cp = Array(this.size) { T::class.java.getDeclaredConstructor().newInstance() }
    System.arraycopy(this, srcPos, cp, destPos, this.size)
    return cp
}