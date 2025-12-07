package ru.yandex.practicum.people;

import java.util.Objects;

public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows)
    {
        super(name, surname, gender);
        this.numberOfShows = numberOfShows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Director director = (Director) o;
        return numberOfShows == director.numberOfShows;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfShows);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
