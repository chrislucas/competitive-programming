package src.com.br.cp.math.combinatorics.patternlock;


/**
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * KNIGHT MOVE: conseguir ir por exemplo do ponto 1 ao 6 no teclado sem tocar em nenhum outro ponto (movimento na diagonal)
 * ou so so 1 ao 5
 *
 * PEGGED MOVE: ir de um ponto A ao C sabendo que obrigatoriamente passou pelo B, 1 ao 3 tendo o 2 no caminho, ou
 * 1 ao 7, ou 4 ao 6 e assim por diante
 *
 * https://github.com/delight-im/AndroidPatternLock/tree/master/src
 *
 * https://ece.uwaterloo.ca/~dwharder/Patterns/
 *
 * https://math.stackexchange.com/questions/634437/how-many-combinations-does-android-pattern-have
 * https://stackoverflow.com/questions/6979524/android-lock-password-combinations
 * * https://stackoverflow.com/questions/34604605/number-of-possible-paths-in-android-pattern-lock
 * https://www.kaspersky.com/blog/lock-screen-patterns-predictability/9528/
 * https://stackoverflow.com/questions/6979524/android-lock-password-combinations
 *
 * count possible pattern locks
 * http://oaji.net/articles/2014/1095-1408891379.pdf
 * * https://www.quora.com/How-many-unlock-patterns-are-there-for-Android-OS-Whats-the-formula-to-calculate-the-number
 * https://math.stackexchange.com/questions/37167/combination-of-smartphones-pattern-password
 * https://puzzling.stackexchange.com/questions/55105/what-is-the-number-of-pattern-locks-possible-for-n-%C3%97-n-grid
 * * https://www.careercup.com/question?id=5663422257561600
 * * https://medium.com%2F@medium.com/@kabab/number-of-possibilities-in-android-code-pattern-295bc6841bf4
 *
 *
 * https://android.imyfone.com/remove-screen-lock/all-possible-android-unlock-patterns/
 * */