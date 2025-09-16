
enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0) { "Use only positive integers (got $naturalNumber)." }

    val aliquot = sumOfProperDivisors(naturalNumber)

    return when {
        aliquot == naturalNumber.toLong() -> Classification.PERFECT
        aliquot >  naturalNumber.toLong() -> Classification.ABUNDANT
        else                  -> Classification.DEFICIENT
    }
}

private fun sumOfProperDivisors(naturalNumber: Int): Long {
    if (naturalNumber == 1) return 0
    var total = 1L
    var divisor = 2

    while (divisor * divisor <= naturalNumber) {
        if (naturalNumber % divisor == 0) {
            val pairedDivisor = naturalNumber / divisor
            total += divisor
            if (pairedDivisor != divisor) total += pairedDivisor
        }
        divisor++
    }
    return total
}