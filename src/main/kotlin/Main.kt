import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    // დავალება 1
    println("დავალება 1")
    println("List Of Palindromes : " + getArrayOfPalindromeSquares(1, 1000))
    println("---------------------------------")

    // დავალება 2
    println("დავალება 2")
    println("Highest Number : " + getHighestNum(58472698, 3))
    println("---------------------------------")

    // დავალება 3
    println("დავალება 3")
    println("Simple Dividers : " + getSimpleDividers(65))
    println("---------------------------------")

}

// დავალება 1

val Int.isPalindrome get() = this.toString() == this.toString().reversed()
val Int.square get() = this * this

fun getArrayOfPalindromeSquares(n: Int, m: Int): List<Int> {
    val listOfPalindromes = mutableListOf<Int>()
    for (num in n until m) {
        if (num.isPalindrome && num.square.isPalindrome) {
            listOfPalindromes.add(
                num
            )
        }
    }
    return listOfPalindromes
}

// დავალება 2

fun Int.toDigits(): List<Int> = toString().map { it.toString().toInt() }
fun List<Int>.concat() = this.joinToString("") { it.toString() }.takeWhile { it.isDigit() }.toInt()

fun getCommonElements(list1: List<Int>, list2: List<Int>): List<Int> {
    val commonElements = mutableListOf<Int>()

    for (element1 in list1) {
        if (list2.contains(element1)) {
            commonElements.add(element1)
        }
    }

    return commonElements
}

fun getHighestNum(number: Int, k: Int): Int {
    val list2 = number.absoluteValue.toDigits().sortedDescending().dropLast(k)
    return getCommonElements(number.absoluteValue.toDigits(), list2).concat()
}


// დავალება 3

fun getSimpleDividers(n: Int): List<Int> {
    val simpleDividers = mutableListOf<Int>()
    var tempNum = n

    for  (i in 1 .. tempNum) {
        if (i % 2 != 0 || i == 2) {
            if (tempNum % i == 0){
                tempNum /= i
                simpleDividers.add(i)
            }
        }
    }

    return simpleDividers
}
