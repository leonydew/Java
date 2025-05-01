package lab3;
import java.time.LocalDateTime;
import java.util.Scanner;

import main.java.lab3.Hall;
import main.java.lab3.Session;
import main.java.lab3.Admin;
import main.java.lab3.Cinema;
import main.java.lab3.Film;
import main.java.lab3.TicketManage;
import main.java.lab3.User;
import main.java.lab3.Console;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("admin", "1");
        User user = new User("user", "user12345");

        System.out.print("Введите логин: ");
        String username = scanner.next();
        System.out.print("Введите пароль: ");
        String password = scanner.next();

        User currentUser = null;

        if (admin.login(username, password)) {
            currentUser = admin;
        } else if (user.login(username, password)) {
            currentUser = user;
        }

        if (currentUser == null) {
            System.out.println("Ошибка: Неверные данные!");
            return;
        }

        System.out.println("Добро пожаловать, " + username + "!");
        
        Cinema cinema = new Cinema("КиноПарк");
        Hall hall = new Hall("Зал 1", 5, 5);
        cinema.addHall(hall);
        Film film = new Film("какой то фильм ", 90);
        Session session = new Session(film, hall, LocalDateTime.of(2001, 1, 15, 17, 30));

        if (currentUser instanceof Admin) {
            Admin adminUser = (Admin) currentUser;
            System.out.print("Введите название нового фильма: ");
            scanner.nextLine(); // Прочитать оставшийся Enter
            String newMovieTitle = scanner.nextLine();
            System.out.print("Введите длительность фильма (в минутах): ");
            int duration = scanner.nextInt();

            Film newFilm = new Film(newMovieTitle, duration);
            adminUser.addMovie(cinema, newFilm);
        } else {
            Console.start(session);
        }
    }
}
