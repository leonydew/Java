package main.java.lab3;

public class Film {
    private String title;
    private int duration;

    public Film(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
