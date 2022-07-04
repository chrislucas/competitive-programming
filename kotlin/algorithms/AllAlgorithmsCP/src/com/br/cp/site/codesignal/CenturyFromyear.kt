package src.com.br.cp.site.codesignal

/*
    https://app.codesignal.com/arcade/intro/level-1/egbueTZRRL5Mm4TXN/solutions
    DONE
 */
fun solution(year: Int) = if (year % 100 == 0) {
    year / 100
} else {
    year / 100 + 1
}