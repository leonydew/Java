
package lab4;

import java.util.List;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Book[] testBooks = {new Book("book1", "author1", 1),
                            new Book("book2", "author1", 2),
                            new Book("book3", "author2", 2),
                            new Book("book4", "author3", 5),
                            new Book("book5", "author3", 5)};
        

        Library myLib = new Library();

        for (Book book : testBooks){
            myLib.AddBook(book);
        }

        System.out.println("all books");
        myLib.PrintAllBooks();

        System.out.println("unique authors");
        myLib.PrintUniqueAuthors();

        System.out.println("number of author's book");
        myLib.PrintAuthorsStatistics();

        System.out.println("author's3 books");
        List<Book> booksAuthor3 = myLib.FindBooksByAuthor("author3");
        for(int i = 0; i<booksAuthor3.size(); i++){
            System.out.println(booksAuthor3.get(i).GetTitle());
        }

        Book book = testBooks[3];
        myLib.RemoveBook(book);

        System.out.println("books of year 5");
        List<Book> booksYear5 = myLib.FindBooksByYear(5);
        for(int i = 0; i<booksYear5.size(); i++){
            System.out.println(booksYear5.get(i).GetTitle());
        }

    }
}
