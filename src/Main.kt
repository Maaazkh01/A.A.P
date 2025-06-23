// write a Kotlin function to reverse a string

fun reverseString(input: String): String {
    return input.reversed()
}
// Example usage
fun main() {
    val original = "Hello, World!"
    val reversed = reverseString(original)
    println("Original: $original")
    println("Reversed: $reversed")
}