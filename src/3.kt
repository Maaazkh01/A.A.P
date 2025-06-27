class Student(val name: String, val math: Int, val science: Int, val english: Int) {
    fun total(): Int {
        return math + science + english
    }

    fun average(): Double {
        return total() / 3.0
    }

    fun grade(): String {
        val avg = average()
        return if (avg >= 90) "A"
        else if (avg >= 80) "B"
        else if (avg >= 70) "C"
        else if (avg >= 60) "D"
        else "F"
    }
}

fun main() {
    val student1 = Student("Ali", 85, 90, 80)
    val student2 = Student("Sara", 95, 92, 89)
    val student3 = Student("John", 70, 65, 75)

    val students = listOf(student1, student2, student3)

    for (s in students) {
        println("${s.name}'s Total Marks: ${s.total()}")
        println("${s.name}'s Average Marks: ${s.average()}")
        println("${s.name}'s Grade: ${s.grade()}")
        println()
    }

    println("Sorted by average marks:\n")

    val sorted = students.sortedByDescending { it.average() }

    for (s in sorted) {
        println("${s.name} - Avg: ${s.average()} - Grade: ${s.grade()}")
    }
}