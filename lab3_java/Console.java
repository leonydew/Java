package main.java.lab3;
import java.util.Scanner;

public class Console {
    public static void start(Session session) {
        Scanner scanner = new Scanner(System.in);
        session.getHall().printSeating();

        System.out.print("Введите ряд: ");
        int row = scanner.nextInt();
        System.out.print("Введите место: ");
        int col = scanner.nextInt();

        if (session.isSeatAvailable(row, col)) {
            session.bookSeat(row, col);
            System.out.println("Билет куплен!");
        } else {
            System.out.println("Место занято.");
        }
    }
}
