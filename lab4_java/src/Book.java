package lab4;

public class Book {
    private String title = "";
    private String author = "";
    private int year = 0;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String GetTitle() {
        return title;
    }

    public String GetAuthor() {
        return author;
    }

    public int GetYear() {
        return year;
    }

    public String toString(){
        return "Book: " + title + ", Author: " + author + ", Year: " + year; 
    }

    public boolean equals(Book book) {
        if (book == null) {
            return false;
        }
        return title == book.GetTitle() && author == book.GetAuthor() && year == book.GetYear();
    }

    public int hashCode() {
        int result = 0;
        result += year;
        result =+ title.hashCode();
        result =+ author.hashCode();
        return result;
    }

}
