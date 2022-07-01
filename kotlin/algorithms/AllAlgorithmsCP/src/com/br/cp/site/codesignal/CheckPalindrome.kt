package src.com.br.cp.site.codesignal

/*
    https://app.codesignal.com/arcade/intro/level-1/s5PbmwxfECC52PWyQ/solutions?solutionId=DjrGv8r5imXzxQ2tf
 */
fun solution(inputString: String): Boolean {
    var low : Int = 0
    var high : Int = inputString.length - 1
    while ( low < high ) {
        if(inputString[low] == inputString[high]){
            low++
            high--
        }else{
            return false
        }
    }
    return true
}