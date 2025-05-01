package main.java.lab3;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private List<Hall> halls;

    public Cinema(String name) {
        this.name = name;
        this.halls = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addHall(Hall hall) {
        halls.add(hall);
    }

    public List<Hall> getHalls() {
        return halls;
    }
}
