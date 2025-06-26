// Data Class Example in Kotlin

// A data class automatically generates:
// - equals() and hashCode()
// - toString()
// - componentN() functions for destructuring
// - copy() function

// Person data class with three properties
data class Person(
    val name: String,
    val age: Int,
    val email: String
)

// Product data class example
data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val category: String
)

fun main() {
    // Creating instances of Person data class
    val person1 = Person("Alice", 30, "alice@example.com")
    val person2 = Person("Alice", 30, "alice@example.com")
    val person3 = Person("Bob", 25, "bob@example.com")
    
    // Demonstrating toString() - automatically generated
    println("toString() demonstration:")
    println(person1)  // Output: Person(name=Alice, age=30, email=alice@example.com)
    
    // Demonstrating equals() - structural equality
    println("\nequals() demonstration:")
    println("person1 == person2: ${person1 == person2}")  // true (same content)
    println("person1 == person3: ${person1 == person3}")  // false (different content)
    
    // Demonstrating copy() - create modified copies
    println("\ncopy() demonstration:")
    val updatedPerson = person1.copy(age = 31)
    println("Original: $person1")
    println("Updated: $updatedPerson")
    
    // Demonstrating destructuring declarations
    println("\nDestructuring demonstration:")
    val (name, age, email) = person1
    println("Name: $name, Age: $age, Email: $email")
    
    // Product example
    println("\nProduct example:")
    val product = Product("P123", "Laptop", 999.99, "Electronics")
    println(product)
    
    // Creating a discounted product using copy()
    val discountedProduct = product.copy(price = 899.99)
    println("Original price: $${product.price}")
    println("Discounted price: $${discountedProduct.price}")
}