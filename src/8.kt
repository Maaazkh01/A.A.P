data class Transaction(val amount: Int, val type: String, val date: String)

val transactions = mutableListOf<Transaction>()

fun addTransaction(amount: Int, type: String, date: String) {
    transactions.add(Transaction(amount, type, date))
}

fun totalIncome(): Int {
    var income = 0
    for (t in transactions) {
        if (t.type == "income") {
            income += t.amount
        }
    }
    return income
}

fun totalExpense(): Int {
    var expense = 0
    for (t in transactions) {
        if (t.type == "expense") {
            expense += t.amount
        }
    }
    return expense
}

fun monthlyBalance(): Int {
    return totalIncome() - totalExpense()
}

fun main() {
    addTransaction(5000, "income", "2025-06-01")
    addTransaction(2000, "expense", "2025-06-05")
    addTransaction(1000, "expense", "2025-06-10")
    addTransaction(3000, "income", "2025-06-15")

    println("Total Income: ₹" + totalIncome())
    println("Total Expenses: ₹" + totalExpense())
    println("Monthly Balance: ₹" + monthlyBalance())
}