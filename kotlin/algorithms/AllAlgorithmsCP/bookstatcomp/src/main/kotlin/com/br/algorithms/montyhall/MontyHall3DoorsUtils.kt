package com.br.algorithms.montyhall

import kotlin.random.Random

/**
 * definicao
 *
 * Imagine um jogo onde o jogador aposta um premio que está escondido atras de UMA de 3 PORTAS, as demais
 * nao contém NADA. O organizador do jogo pede para o jogador escolher uma das portas, após a escolha
 * o ORGANIZADOR abre uma das 2 portas restantes para mostrar que o premio não está la. Em seguida faz a seguinte
 * pergunta ao JOGADOR: Vc quer trocar de PORTA ?
 *
 * A pergunta que podemos fazer é, onde é mais provavel que o prêmio esteja na porta escolhida pelo
 * JOGADOR ou na porta seguinte, a que nao foi escolhida e nem aberta ?
 *
 * Ou de outra forma, utilizando o conhecimento estatístico é melhor trocar de porta ou ficar na primeira escolhida
 *
 * 1) No inioio do JOGO o jogador tinha 1/3 de chance de acertar a porta
 * 2) As portas restantes somam 2/3 de chances de possuirem o premio
 * 3) O organizador nunca vai abrir a porta que o JOGADOR escolher, por motivos obvios e vai sempre abrir uma porta que
 * ele sabe que NÃO tem o premio
 * 4) Ao abrir uma das portas antes de perguntar se JOGADOR quer trocar o ORGANIZADOR da uma INFORMACAO que o JOGADOR
 * nao tinha: QUAL A PORTA REALMENTE NAO TEM O PREMIO
 * 5) Abrindo um das 2 portas restantes la se vai 1/3 da chance do premio estar na porta aberta, sobrando 2/3
 *
 *
 * Uma analise intuitiva porem errada
 *
 * 1) No principio o JOGADOR tem 1/3 de chances de acertar
 * 2) Quando o ORGANIZADOR mostra que uma das portas nao tem o primeiro sobram 2 portas e intuitivamente
 * porem ERRADO podemos pensar que agora as chances subiram para 1/2, ou O JOGADOR escolheu a porta certa
 * ou NAO
 * 3) O erro começa ao esquecer que a porta que será aberta dependerá de qual foi escolhida pelo usuario.
 * Se o sua intuicao levar a crer que ao abrir uma das portas, que claramente nao tera o premio o ORGANIZADOR
 * eleva suas chances para 50%, ou é a porta que o JOGADOR escolher ou a que sobrou fechada,
 * ela está errada. Se seguir por esse raciocinio chegara a conclusao errada de que nao faz diferença estatisticamente
 * trocar de porta, mas lembre-se o ORGANIZADOR sabe onde está o premio e escolheu uma porta sem o premio propositalmente.
 * Esse ato so da informacoes novas ao JOGADOR
 * Se o JOGADOR escolhe a porta NAO PREMIADA na primeira chance, o ORGANIZADOR nao tem  escolha a NAO ser abrir a outra
 * porta NAO PREMIADA (lembrando que inicialmente o JOGADOR tem ~33%(1/3) de chance de acerto)
 *
 *
 * SOLUCAO
 *
 * A analise desse problema eh contra intuitiva, trocar eh a melhor opcao
 *
 * 1/3 de probabilidade de acertar
 * 2/3 de probabilidade de errar
 *
 * Ao abrir uma das portas VC diminui a chance de ERRAR em 1/3 pelos motivos citados acima e sabe
 * que se tiver escolhido a PORTA ERRADA a PORTA que foi que fora aberta te da mais 1/3 de chances
 * uma vez que nao seria aberta a porta com o PREMIO
 *
 * ISSO se aplica a toda vez que a primeira escolha for ERRADA
 *
 *
 * */

val fromOneToThree: Int
    get() = Random.nextInt(1, 4)

val choosingPrizedDoor: Int
    get() = fromOneToThree

fun choosingADifferentDoor(oldChosenDoor: Int): Int {
    var chosen = fromOneToThree
    while (chosen == oldChosenDoor) {
        chosen = fromOneToThree
    }
    return chosen
}

fun choosingLastDoor(prizedDoor: Int, firstChoice: Int): Int =
    if (prizedDoor == firstChoice) {
        choosingLastDoorIfPrizedAndFirstChoiceAreEquals(firstChoice)
    } else {
        choosingLastDoorIfPrizedAndFirstChoiceAreDifferent(prizedDoor, firstChoice)
    }


private fun choosingLastDoorIfPrizedAndFirstChoiceAreEquals(door: Int): Int =
    when (door) {
        1 -> {
            2
        }
        2 -> {
            3
        }
        else -> {
            1
        }
    }


private fun choosingLastDoorIfPrizedAndFirstChoiceAreDifferent(prizedDoor: Int, firstChoice: Int): Int =
    if (prizedDoor == 1 && firstChoice == 2 || firstChoice == 1 && prizedDoor == 2) {
        3
    } else if (prizedDoor == 2 && firstChoice == 3 || prizedDoor == 3 && firstChoice == 2) {
        1
    } else {
        2
    }
