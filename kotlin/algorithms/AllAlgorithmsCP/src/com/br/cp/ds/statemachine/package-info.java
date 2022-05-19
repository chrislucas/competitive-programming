package src.com.br.cp.ds.statemachine;


/**
 * What is a Finite State Machine?
 * https://medium.com/@mlbors/what-is-a-finite-state-machine-6d8dec727e2c
 *
 * - Uma maquina de estado finito (MSF ou FSM finite state machine) e um dispositivo armazenando o estado de algo
 * num determinado momento
 *
 * - O estado desse "algo" muda baseado em inputs, provendo valores de saida
 * para uma mudanca implementada
 *
 * - FSM venho de um ramo da computacao chhamado Automata theory, familia de
 * estruturas de dados pertencendo tambem a chamada Turing machine
 *
 *    Pontos relevantes sobre FSM
 *    - Existem um conjunto fixo de possiveis estados que uma maquina pode assumir
 *    - A maquina pode estar num unico estado por vez
 *    - A maquina recebe uma sequencia de valores de entrada
 *    - Tod0 estado tem um conjunto de transicoes e toda transicao e associada com um
 *    valor de entrada e aponta para um estado
 *
 *
 * ***********************************************************************************************
 *
 * Introducao ao automato finito
 * https://www.geeksforgeeks.org/introduction-of-finite-automata/
 *
 * - Automato finito (FA) eh uma maquina simples de reconhecimento de padroes
 * - Um automato finito ou maquina de estados finitos é uma abstracao de uma
 * maquina que tem 5 elementos ou tuplas. Ele tem um conjunto de estados
 * e regras para mover de um estado para outro, mudança que depende de um valor
 * de entrada
 *
 * - um modelo abstrato de um computador digital
 *
 * Tipos de FA
 *
 * - DFA automato finito determinisco
 *  - conjunto de todos os estados Q
 *  - conjunto de simbolo de entradas Sigma
 *  - estado inicial
 *  - conjunto de estatos finais
 *  - funcao de transicao de estado
 *      - f :  Q x Signma --> Q (novo estado)
 *
 * - NFA automato finito nao determinisco
 *  - similar a uma DFA com as seguintes mudancas
 *      - um estado pode ser alterado sem a leitura de um simbolo
 *      - mudar para qualquer (numero de) estado para uma entrada particular
 *  - funcao de transicao
 *      - f: Q x (Sigma ou null) -> 2 ^ Q
 *
 *
 * - isso nao da nenhum poder a mais para esse tipo de FA, NFA e DFA sao
 * equivalentes em termos de poder
 *
 *
 * ***********************************************************************************************
 *
 * https://brilliant.org/wiki/finite-state-machines/
 *
 *
 * ***********************************************************************************************
 * Finite State Machine Explained
 * https://www.freecodecamp.org/news/finite-state-machines/
 *
 * ***********************************************************************************************
 * Applications of various Automata
 * https://www.geeksforgeeks.org/applications-of-various-automata/
 *
 *  ***********************************************************************************************
 *
 *  https://www.tutorialspoint.com/automata_theory/pushdown_automata_introduction.htm
 *
 *  ***********************************************************************************************
 * 8. Finite State Machine in Python
 * https://python-course.eu/applications-python/finite-state-machine.php
 *
 *
 * State machine
 * https://www.geeksforgeeks.org/introduction-of-finite-automata/
 * https://brilliant.org/wiki/finite-state-machines/
 * https://www.javatpoint.com/finite-state-machine
 *
 * Automato finito deterministico
 * https://www.geeksforgeeks.org/introduction-of-finite-automata/
 * https://www.geeksforgeeks.org/difference-between-dfa-and-nfa/
 *
 * https://en.wikipedia.org/wiki/Deterministic_finite_automaton
 * https://www.tutorialspoint.com/automata_theory/deterministic_finite_automaton.htm
 *
 * deterministic finite automaton competitive programming
 * https://cp-algorithms.com/string/suffix-automaton.html
 * https://www.geeksforgeeks.org/finite-automata-algorithm-for-pattern-searching/
 * https://www.geeksforgeeks.org/program-build-dfa-starts-end-input-b/
 * https://codeforces.com/blog/entry/20861
 * https://www.geeksforgeeks.org/program-to-construct-a-dfa-which-accept-the-language-l-anbm-n-mod-20-m1/
 *
 * Suffix Automata
 * https://akshay.jaggi.co/blog/suffix-automata/
 *
 * Finite Automata in Theory of Computation
 * https://iq.opengenus.org/finite-automata/
 *
 * A Simplistic TCP Finite State Machine (FSM)
 * https://www.codewars.com/kata/54acc128329e634e9a000362?utm_source=newsletter
 *
 * https://www.codewars.com/kata/59eb1e4a0863c7ff7e000008?utm_source=newsletter
 *
 * ***********************************************************************************************
 * https://www.geeksforgeeks.org/conversion-from-nfa-to-dfa/
 * ***********************************************************************************************
 *
 * https://salimsah.github.io/Automata/fa/ummugulsum_nfa
 * ***********************************************************************************************
 *
 * https://www.geeksforgeeks.org/designing-non-deterministic-finite-automata-set-3/
 *
 * ***********************************************************************************************
 *
 *
 * Non deterministic Finite Automata
 * https://acervolima.com/conversao-de-nfa-para-dfa/
 *
 * ***********************************************************************************************
 * https://www.javatpoint.com/non-deterministic-finite-automata
 * ***********************************************************************************************
 *
 * https://en.wikipedia.org/wiki/Generalized_nondeterministic_finite_automaton
 * ***********************************************************************************************
 *
 * Stack-Based FSM
 * https://gamedevelopment.tutsplus.com/tutorials/finite-state-machines-theory-and-implementation--gamedev-11867
 */