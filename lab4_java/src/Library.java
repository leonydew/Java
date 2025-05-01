package lab4;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Library {
    private List<Book> books;
    private Set<String> uniqueAuthors;
    private Map<String, Integer> authorBooks;

    public Library(){
        books = new ArrayList<Book>();
        uniqueAuthors = new HashSet<String>();
        authorBooks = new HashMap<String, Integer>();
    }

    void AddBook(Book book){
        books.add(book);
        uniqueAuthors.add(book.GetAuthor());
        if (authorBooks.containsKey(book.GetAuthor())) {
            authorBooks.put(book.GetAuthor(), authorBooks.get(book.GetAuthor()) + 1);
        } 
        else {
            authorBooks.put(book.GetAuthor(), 1);
        }
    }

    void RemoveBook(Book book){
        books.remove(book);
        if (authorBooks.get(book.GetAuthor()) == 1) {
            authorBooks.remove(book.GetAuthor());
            uniqueAuthors.remove(book.GetAuthor());
        } else {
            authorBooks.put(book.GetAuthor(), authorBooks.get(book.GetAuthor()) - 1);
        }
    }

    public List<Book> FindBooksByAuthor(String author) {
        List<Book> nedeedBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.GetAuthor().equals(author)) {
                nedeedBooks.add(book);
            }
        }
        return nedeedBooks;
    }

    public List<Book> FindBooksByYear(int year) {
        List<Book> yearBooks = new ArrayList<Book>();
        for (Book book : books) {
            if (book.GetYear() == year) {
                yearBooks.add(book);
            }
        }
        return yearBooks;
    }

    public void PrintAllBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public void PrintUniqueAuthors() {
        for (String author: uniqueAuthors) {
            System.out.println(author);
        }
    }

    public void PrintAuthorsStatistics() {
        for (String author: uniqueAuthors) {
            System.out.println("Author: " + author + " Books amount: " + authorBooks.get(author));
        }
    }
}
