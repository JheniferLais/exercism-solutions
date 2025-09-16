object Bob {
    fun hey(input: String): String {
        val trimmed = input.trim()

        if (trimmed.isEmpty()) return "Fine. Be that way!"

        val letters = trimmed.filter { it.isLetter() }
        val isYelling = letters.isNotEmpty() && letters.all { it.isUpperCase() }
        val isQuestion = trimmed.endsWith("?")

        return when {
            isYelling && isQuestion -> "Calm down, I know what I'm doing!"
            isYelling               -> "Whoa, chill out!"
            isQuestion              -> "Sure."
            else                    -> "Whatever."
        }
    }
}
