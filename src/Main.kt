
open class Bankaccount(var balance: Double)
{
    open fun deposit(amount:Double){
        balance +=amount
        println("DEPOSIT SUCCESSFUL")
        println("DEPOSITED AMOUNT:- $amount" )
    }
    open fun withdraw(amount:Double){
        if(balance<amount){
            println("Insufficient balance")
        }else{
            balance -=amount
           println("WITHDRAWAL SUCCESSFUL")
           println("WITHDRAWN AMOUNT:- $amount")
        }
    }

    open fun displaybalance(){
        println("BALANCE:- $balance")
        println("=====================================")
    }
}
class Savingsaccount(balance:Double,val interestrate:Double):Bankaccount(balance){
    fun applyinterest(){
        val interest=balance*interestrate/100
        balance+=interest
        println("INTEREST APPLIED")
        println("INTEREST AMOUNT:- $interest")
    }

}
class Currentaccount(balance:Double,val overdraft:Double):Bankaccount(balance){
    override fun withdraw(amount:Double){
        if (balance+overdraft>=amount){
            balance-=amount
            println("WITHDRAWAL SUCCESSFUL")
            println("WITHDRAWN AMOUNT:- $amount")
        }else{
            println("OVERDRAFT LIMIT EXCEEDED")
        }
    }

}
fun main(){
    val savings=Savingsaccount(10000.0,10.0)
    val current=Currentaccount(5000.0,2000.0)

    savings.deposit(1000.0)
    savings.applyinterest()
    savings.displaybalance()

    current.withdraw(5000.0)
    current.displaybalance()
    current.withdraw(1000.0)
    current.displaybalance()
    current.withdraw(1000.0)
    current.displaybalance()
    current.withdraw(1000.0)
    current.displaybalance()
}