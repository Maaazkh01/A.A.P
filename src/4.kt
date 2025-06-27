data class Task(val title: String, val dueDate: String, var isCompleted: Boolean = false)

val tasks = mutableListOf<Task>()

fun addTask(title: String, dueDate: String) {
    tasks.add(Task(title, dueDate))
}

fun markComplete(title: String) {
    for (task in tasks) {
        if (task.title == title) {
            task.isCompleted = true
        }
    }
}

fun filterByStatus(completed: Boolean): List<Task> {
    return tasks.filter { it.isCompleted == completed }
}

fun filterByDueDate(date: String): List<Task> {
    return tasks.filter { it.dueDate == date }
}

fun sortByDate(): List<Task> {
    return tasks.sortedBy { it.dueDate }
}

fun main() {
    addTask("Do Kotlin homework", "2025-06-25")
    addTask("Go to gym", "2025-06-23")
    addTask("Buy groceries", "2025-06-24")

    markComplete("Go to gym")

    println("All Tasks:")
    for (t in tasks) println(t)

    println("\nIncomplete Tasks:")
    for (t in filterByStatus(false)) println(t)

    println("\nTasks due on 2025-06-24:")
    for (t in filterByDueDate("2025-06-24")) println(t)

    println("\nTasks sorted by date:")
    for (t in sortByDate()) println(t)
}