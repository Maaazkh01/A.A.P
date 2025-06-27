fun String.isPalindrome(): Boolean {
    val clean = this.replace(" ", "").lowercase()
    return clean == clean.reversed()
}

fun String.wordCount(): Int {
    val words = this.trim().split(" ")
    var count = 0
    for (word in words) {
        if (word != "") {
            count++
        }
    }
    return count
}

fun String.toTitleCase(): String {
    val words = this.lowercase().split(" ")
    val capitalizedWords = mutableListOf<String>()

    for (word in words) {
        if (word != "") {
            val first = word[0].uppercase()
            val rest = word.substring(1)
            capitalizedWords.add(first + rest)
        }
    }

    return capitalizedWords.joinToString(" ")
}

fun main() {
    val str1 = "Madam"
    val str2 = "hello world this is kotlin"
    val str3 = "this is a title case test"

    println("Is '$str1' a palindrome? → ${str1.isPalindrome()}")
    println("Word count in '$str2' → ${str2.wordCount()}")
    println("Title Case of '$str3' → ${str3.toTitleCase()}")
}