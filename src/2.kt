class Book(val author: String,val title: String,val isbn: String,var isavailable: Boolean = true)

val books = mutableListOf<Book>()

fun addbook(author: String, title: String, isbn: String) {
    val book = Book(author,title,isbn)
    books.add(book)
    println("BOOK ADDED SUCCESSFULLY $title BY $author - ISBN: $isbn")
}
fun showbooks(){
    if(books.isEmpty()){
        println("NO BOOKS AVAILABLE")
        }else{
        for(i in books){
         println("${i.title} BY ${i.author} - ISBN: ${i.isbn} - Available: ${if (i.isavailable) "Yes" else "No"}")
        }
    }

    println("=============================================================")
}
fun searchbytitle(title: String){
    for(i in books){
        if(i.title.contains(title,ignoreCase = true)){
            println("BOOK FOUND: ${i.title} BY ${i.author} - ISBN: ${i.isbn} - Available: ${if (i.isavailable) "Yes" else "No"}")
        }
    }
}
fun searchbyauthor(author: String){
    for(i in books){
        if(i.author.contains(author,ignoreCase = true)){
            println("BOOK FOUND: ${i.title} BY ${i.author} - ISBN: ${i.isbn} - Available: ${if (i.isavailable) "Yes" else "No"}")
        }
    }
}
fun lendbook(isbn: String){
    if(books.isEmpty()){
        println("NO BOOKS AVAILABLE TO LEND")
        return
    }
    for(i in books){
        if(i.isbn==isbn && i.isavailable){
            i.isavailable=false
            println("BOOK LENT SUCCESSFULLY: ${i.title} BY ${i.author} - ISBN: ${i.isbn}")
        }
        return
    }
    println("BOOK NOT FOUND OR NOT AVAILABLE")
}
fun returnbook(isbn: String){
    for(i in books){
        if(i.isbn==isbn && !i.isavailable){
            i.isavailable = true
            println("BOOK RETURNED SUCCESSFULLY: ${i.title} BY ${i.author} - ISBN: ${i.isbn}")
        }
        return
    }
    println("BOOK NOT FOUND OR NOT LENT OUT")
}
fun main(){

    addbook("J.K. Rowling", "Harry Potter and the Philosopher's Stone", "123")
    addbook("J.R.R. Tolkien", "The Hobbit", "456")
    addbook("George Orwell", "1984", "789")

    showbooks()

    searchbytitle("Harry Potter")
    searchbyauthor("Tolkien")

    lendbook("123")

    showbooks()

    returnbook("123")

    showbooks()
}