package main.java.lab3;


public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addMovie(Cinema cinema, Film movie) {
        System.out.println("Фильм \"" + movie.getTitle() + "\" добавлен в кинотеатр \"" + cinema.getName() + "\"!");
    }
}
