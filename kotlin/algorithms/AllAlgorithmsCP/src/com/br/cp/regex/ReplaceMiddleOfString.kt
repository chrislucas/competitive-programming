package src.com.br.cp.regex

/**
 * remover uma substring especifca no meio da string
 */
private fun test() {

    arrayOf(
        "https://mercadolivre.com.br/supermercado/123123_deal",
        "https://mercadolivre.com.br/supermercado/123123_deal?",
        "https://mercadolivre.com.br/supermercado/teste_deal?teste",
    ).forEach {
        println(
            it.replace("_([Dd])eal[a-zA-Z0-9_-]*\\?*$".toRegex(), "")
        )
    }
}


fun main() {
    test()
}