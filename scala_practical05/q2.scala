import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object LibraryManagement {
    var library: Set[Book] = Set(
        Book("1984", "George Orwell", "978-0451524935"),
        Book("To Kill a Mockingbird", "Harper Lee", "978-0446310789"),
        Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565")
    )

    def addBook(book: Book): Unit = {
        library += book
        println(s"Added: ${book.title}")
    }

    def removeBook(isbn: String): Unit = {
        val initialSize = library.size
        library = library.filterNot(_.isbn == isbn)
        if (library.size < initialSize) {
            println(s"Removed book with ISBN: $isbn")
        }
        else {
            println(s"No book found with ISBN: $isbn")
        }
    }

    def isBookInLibrary(isbn: String): Boolean = {
        library.exists(_.isbn == isbn)
    }

    def displayLibrary(): Unit = {
        println("\nCurrent Library Collection:")
        library.foreach(book => println(s"${book.title} by ${book.author} (ISBN: ${book.isbn})"))
    }

    def searchByTitle(title: String): Unit = {
        library.find(_.title.toLowerCase == title.toLowerCase) match {
            case Some(book) => println(s"Found: ${book.title} by ${book.author} (ISBN: ${book.isbn})")
            case None => println(s"No book found with title: $title")
        }
    }

    def displayBooksByAuthor(author: String): Unit = {
        val authorBooks = library.filter(_.author.toLowerCase == author.toLowerCase)
        if (authorBooks.nonEmpty) {
            println(s"\nBooks by $author:")
            authorBooks.foreach(book => println(s"${book.title} (ISBN: ${book.isbn})"))
        }
        else {
            println(s"No books found by author: $author")
        }
    }

    def main(args: Array[String]): Unit = {
        var continue = true
        while (continue) {
        println("\n--- Library Management System ---")
        println("1. Display library")
        println("2. Add a book")
        println("3. Remove a book")
        println("4. Check if a book is in the library")
        println("5. Search book by title")
        println("6. Display books by author")
        println("7. Exit")
        print("Enter your choice: ")
        
        readLine().trim match {
            case "1" => displayLibrary()
            case "2" => print("Enter title: ")
                        val title = readLine()
                        print("Enter author: ")
                        val author = readLine()
                        print("Enter ISBN: ")
                        val isbn = readLine()
                        addBook(Book(title, author, isbn))
            case "3" => print("Enter ISBN of book to remove: ")
                        removeBook(readLine())
            case "4" => print("Enter ISBN to check: ")
                        val isbn = readLine()
                        println(if (isBookInLibrary(isbn)) "Book is in the library" else "Book is not in the library")
            case "5" => print("Enter title to search: ")
                        searchByTitle(readLine())
            case "6" => print("Enter author name: ")
                        displayBooksByAuthor(readLine())
            case "7" => continue = false
                        println("Exiting...")
            case _ =>   println("Invalid choice. Please try again.")
            }
        }
    }
}
