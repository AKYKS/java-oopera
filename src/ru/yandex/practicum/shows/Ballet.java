package ru.yandex.practicum.shows;

import ru.yandex.practicum.people.*;
import java.util.ArrayList;

public class Ballet extends MusicalShow{
    private Person choreographer;

    public Ballet(String title, int duration, Director director, ArrayList<Actor> listOfActors, Person musicAuthor,
                  String librettoText, Person choreographer) {
        super(title, duration, director, listOfActors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}
