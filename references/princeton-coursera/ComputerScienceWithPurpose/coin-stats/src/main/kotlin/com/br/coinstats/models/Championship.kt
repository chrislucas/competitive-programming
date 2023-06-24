package com.br.coinstats.models

/*
    Representa um campeonato de mata-mata
    se tivermos N jogadores N > 2 teremos log2(n) + 1 fases
 */
data class Championship(val matches: LinkedHashMap<Int, List<Result>>)


val Championship.final: List<Result>?
    get() = matches[matches.keys.last()]