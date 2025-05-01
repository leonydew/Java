package main.java.lab3;
import java.time.LocalDateTime;


public class Session {
    private Film film;
    private Hall hall;
    private LocalDateTime startTime;

    public Session(Film film, Hall hall, LocalDateTime startTime) {
        this.film = film;
        this.hall = hall;
        this.startTime = startTime;
    }

    public Film getMovie() {
        return film;
    }

    public Hall getHall() {
        return hall;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public boolean isSeatAvailable(int row, int col) {
        return hall.isSeatAvailable(row, col);
    }

    public void bookSeat(int row, int col) {
        hall.bookSeat(row, col);
    }
}
