// Create classes BankAccount, SavingsAccount, and CurrentAccount.
// Implement methods like deposit, withdraw, displayBalance
// Add overdraft limit in CurrentAccount and interest rate in SavingsAccount.
//use accountNumber to identify accounts.


open class BankAccount(val accountNumber: String, var balance: Double) {
    open fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposited $$amount. New balance: $$balance")
        } else {
            println("Deposit amount must be positive.")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && amount <= balance) {
            balance -= amount
            println("Withdrew $$amount. New balance: $$balance")
        } else {
            println("Insufficient funds or invalid withdrawal amount.")
        }
    }
}
class SavingsAccount(accountNumber: String, balance: Double) : BankAccount(accountNumber, balance) {
    private val interestRate = 0.03 // 3% interest rate

    fun applyInterest() {
        val interest = balance * interestRate
        deposit(interest)
        println("Applied interest of $$interest. New balance: $$balance")
    }
}
class CurrentAccount(accountNumber: String, balance: Double) : BankAccount(accountNumber, balance) {
    private val overdraftLimit = 500.0 // Overdraft limit of $500

    override fun withdraw(amount: Double) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount
            println("Withdrew $$amount. New balance: $$balance")
        } else {
            println("Withdrawal exceeds overdraft limit or invalid amount.")
        }
    }
}

fun main() {
    val savingsAccount = SavingsAccount("SA12345", 1000.0)
    savingsAccount.deposit(200.0)
    savingsAccount.withdraw(150.0)
    savingsAccount.applyInterest()

    val currentAccount = CurrentAccount("CA12345", 500.0)
    currentAccount.deposit(300.0)
    currentAccount.withdraw(700.0) // Should succeed due to overdraft limit
    currentAccount.withdraw(1000.0) // Should fail due to overdraft limit
}
