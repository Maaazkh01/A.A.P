data class Movie(val title: String, val genre: String, val rating: Double, val year: Int)

val movies = mutableListOf<Movie>()

fun addMovie(title: String, genre: String, rating: Double, year: Int) {
    movies.add(Movie(title, genre, rating, year))
}

fun getMoviesByGenre(genreName: String): List<Movie> {
    val result = mutableListOf<Movie>()
    for (movie in movies) {
        if (movie.genre == genreName) {
            result.add(movie)
        }
    }
    return result
}

fun sortByRating(): List<Movie> {
    return movies.sortedByDescending { it.rating }
}

fun getTop5RecentHighRated(): List<Movie> {
    val sorted = movies.sortedWith(compareByDescending<Movie> { it.year }.thenByDescending { it.rating })
    val result = mutableListOf<Movie>()
    var count = 0
    for (movie in sorted) {
        if (count < 5) {
            result.add(movie)
            count++
        }
    }
    return result
}

fun main() {
    addMovie("Inception", "Sci-Fi", 8.8, 2010)
    addMovie("The Dark Knight", "Action", 9.0, 2008)
    addMovie("Interstellar", "Sci-Fi", 8.6, 2014)
    addMovie("Joker", "Drama", 8.5, 2019)
    addMovie("Parasite", "Thriller", 8.6, 2019)
    addMovie("Avengers", "Action", 8.0, 2012)
    addMovie("The Matrix", "Sci-Fi", 8.7, 1999)
    addMovie("Gladiator", "Action", 8.5, 2000)

    println("All Movies:")
    for (m in movies) println(m)

    println("\nMovies in Sci-Fi Genre:")
    val scifi = getMoviesByGenre("Sci-Fi")
    for (m in scifi) println(m)

    println("\nMovies sorted by rating:")
    val sortedRating = sortByRating()
    for (m in sortedRating) println(m)

    println("\nTop 5 Movies by Year & Rating:")
    val top5 = getTop5RecentHighRated()
    for (m in top5) println(m)
}