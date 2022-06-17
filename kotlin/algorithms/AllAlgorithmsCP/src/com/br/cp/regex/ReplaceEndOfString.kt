package src.com.br.cp.regex

private fun test() {
    /*
    println("https://mercadolivre.com.br/supermercado/_Deal_teste_1".replace("_Deal[a-zA-Z0-9_-]*$".toRegex(), ""))
    println("https://mercadolivre.com.br/supermercado/_Deal_teste_1-123".replace("_Deal[a-zA-Z0-9_-]*$".toRegex(), ""))
    println("https://mercadolivre.com.br/supermercado/_Deal".replace("_Deal[a-zA-Z0-9_-]*$".toRegex(), ""))
    println("https://mercadolivre_Deal.com.br/supermercado_Deal/_Deal".replace("_Deal[a-zA-Z0-9_-]*$".toRegex(), ""))

     */

    arrayOf(
        "https://mercadolivre_Deal.com.br/supermercado_Deal/_Deal_cpg-paquete-ahorres?",
        "https://mercadolivre.com.br/supermercado/_Deal_cpg-paquete-ahorres",
        "https://mercadolivre.com.br/supermercado/_deal_cpg-paquete-ahorres?",
        "https://mercadolivre.com.br/supermercado/_deal_CPG-paquete-ahorres",
        "https://mercadolivre.com.br/supermercado/_deal_123-paquete-ahorres",
        "https://mercadolivre.com.br/supermercado/_deal_123-paquete-ahorres",
        "https://mercadolivre.com.br/supermercado/_deal",
        "https://mercadolivre.com.br/supermercado/_deal?",
        "https://mercadolivre.com.br/supermercado/_deal?teste",
    ).forEach {
        println(
            it.replace("/_([Dd])eal[a-zA-Z0-9_-]*\\?*.*$".toRegex(), "")
        )
    }
}


fun main() {
    test()
}