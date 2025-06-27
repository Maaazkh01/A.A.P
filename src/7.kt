val users = mutableMapOf<String, String>()

fun addUser(username: String, password: String) {
    users[username] = password
}

fun login(username: String, password: String): Boolean {
    if (users.containsKey(username)) {
        return users[username] == password
    }
    return false
}

fun resetPassword(username: String, newPassword: String): Boolean {
    if (users.containsKey(username)) {
        users[username] = newPassword
        return true
    }
    return false
}

fun main() {
    addUser("maaz", "1234")
    addUser("ali", "pass")
    addUser("zara", "abcd")

    println("Login 1: " + login("maaz", "1234"))   // true
    println("Login 2: " + login("ali", "wrong"))   // false
    println("Login 3: " + login("zara", "abcd"))   // true

    println("Resetting password for 'ali'")
    val reset = resetPassword("ali", "newpass")
    println("Reset Success? $reset")

    println("Login 4: " + login("ali", "newpass")) // true now
}