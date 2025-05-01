package main.java.lab3;
import java.util.Arrays;

public class Hall {
    private String name;
    private boolean[][] seats;

    public Hall(String name, int rows, int cols) {
        this.name = name;
        this.seats = new boolean[rows][cols];
    }

    public String getName() {
        return name;
    }

    public boolean isSeatAvailable(int row, int col) {
        return !seats[row][col];
    }

    public void bookSeat(int row, int col) {
        seats[row][col] = true;
    }

    public void printSeating() {
        for (boolean[] row : seats) {
            for (boolean seat : row) {
                System.out.print(seat ? "[X] " : "[ ] ");
            }
            System.out.println();
        }
    }
}
