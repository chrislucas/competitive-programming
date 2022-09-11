package src.com.br.tutorials.estatistica.amostragem;

/**
 * https://blog.remesh.ai/how-to-calculate-sample-size
 * https://www.statisticshowto.com/probability-and-statistics/find-sample-size/
 *
 * <p>-----------------------------------------------------------------------------------------------------------------
 * Intervalo de confianca https://pt.wikipedia.org/wiki/Intervalo_de_confian%C3%A7a
 *
 * <p>O INTERVALO DE CONFIANCA É UM TIPO DE ESTIMATIVA DE UM PARÂMETRO POPULACIONAL
 *
 * <p>estimativa de intervalo -> https://pt.wikipedia.org/wiki/Estimativa_por_intervalo parametro
 * populacional -> https://pt.wikipedia.org/wiki/Par%C3%A2metro_(estat%C3%ADstica)
 *
 * <p>- Essa tipo de estimativa foi indotruzido por Jerzy Neyman
 * (https://pt.wikipedia.org/wiki/Jerzy_Neyman) em 1937 - É um intervalo observado (calculado a
 * partir de observaçòes) - Variam conforme a amostra - Dada a frequencia (nivel de confianca)
 * inclui o parâmetro de interesse real nao observavel
 *
 * <p>- Como os dados observados sao amostras aleatorias da populacao, o intervalo de confianca
 * construido a partir dos dados tbm eh aleatório
 *
 * <p>- O nivel de confianca e a frequencia com a qual o intervalo observado contem o parametro real
 * de interesse quando o experimento e repetido varias vezes
 *
 * <p>- O niivel de confianca de 99% siginifica que 99% dos intervalos de confianca construidos a
 * partir das amostras aleatorias contem o parametro real.
 *
 * <p>- O nivel de confianca e definido pelo pesquisador, nao pelos dados. - Se um teste de hipotese
 * for realizado, o nivel de confianca e o complemento do nivel de SIGNIFICANCIA. Isto é, um
 * intervalo de confianca de 95% reflete um nivel de significancia de 5%
 *
 * <p>Parametro - Estatística - https://pt.wikipedia.org/wiki/Par%C3%A2metro_(estat%C3%ADstica) - Em
 * estatística, um parametro é uma característica da população Exemplo:
 *
 * <p>- Seja uma variável aleatório "idade dos interessados algo X". "Numero de elementos", no caso
 * numero total de pessoas interessadas em X é um parametro desta populacao.
 *
 * <p>ESPERANCA ou VALOR ESPERADO (https://pt.wikipedia.org/wiki/Valor_esperado)
 *
 * <p>- A Esperacao desta variavel aleatoria, seja 35 anos, tambem e um parametro da populacao. Isso
 * é diferente da média amostral, valor que podemos obter tomando alguns interessados em X e
 * calculando a média de suas idades
 *
 * <p>VARIAVEL ALEATORIA(https://pt.wikipedia.org/wiki/Vari%C3%A1vel_aleat%C3%B3ria)
 *
 * <p>Mais sobre parametros populacionais
 * https://www.inf.ufsc.br/~andre.zibetti/probabilidade/estimacao-de-parametros.html
 *
 * <p>Definicao informal - https://pt.wikipedia.org/wiki/Intervalo_de_confian%C3%A7a
 *
 * <p>- Um intervalo de confianca para um parametro populacional é um intervalo com uma proporção
 * associada 'p' gerada por uma amostra aleatória de uma população subjacente, de tal forma que se o
 * experimento for repetido varias vezes e o intervalo de confianca for recalculado para cada
 * experimento com mesmo procedimento, uma propocao 'p' dos intervalos de confianca conteria o
 * parametro estatítico em questao
 *
 * <p>"Os intervalos de confianca sao usados para indicar a confiabilidade de uma estimativa"
 *
 * <p>Exemplo: O intervalo de confianac pode ser usado para descrever o quao confiaveis sao os
 * resultados de uma pesquisa.
 *
 * <p>- O intervalo de confianca com nivel de confianca de 95% eh o mais comum e significa que o
 * resultado esta dentro do intervalo de confiança em 95 das 100 amostras realizadas
 *
 * <p>Significância estatística https://pt.wikipedia.org/wiki/Signific%C3%A2ncia_estat%C3%ADstica#
 *
 * <p>http://leg.ufpr.br/~paulojus/ce003/ce003/node5.html
 * https://www.significados.com.br/intervalo-de-confianca/
 *
 * <p>------------------------------------------------------------------------------------------------------------------
 *
 * <p>Pesquisa eleitoral
 * https://educacao.uol.com.br/disciplinas/matematica/estatistica-conceitos-para-entender-pesquisas.htm
 * https://cienciahoje.org.br/coluna/as-pesquisas-eleitorais-e-os-modelos-cientificos/
 *
 * <p>Media, Desvio Padrao e Variancia https://www.todamateria.com.br/desvio-padrao/#
 * https://www.mathsisfun.com/data/standard-deviation.html
 */
