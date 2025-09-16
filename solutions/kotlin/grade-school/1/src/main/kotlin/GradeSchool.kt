class School {

    private val studentsInGrade = mutableMapOf<Int, MutableList<String>>()
    private val allStudents = mutableSetOf<String>()

    fun add(student: String, grade: Int) {
        check(allStudents.add(student)) {
            "Student '$student' is already enrolled."
        }
        val names = studentsInGrade.getOrPut(grade) { mutableListOf() }
        names += student
    }

    fun grade(grade: Int): List<String> =
        studentsInGrade[grade]?.sorted() ?: emptyList()

    fun roster(): List<String> =
        studentsInGrade.keys.sorted()
            .flatMap { g -> (studentsInGrade[g] ?: emptyList()).sorted() }
}