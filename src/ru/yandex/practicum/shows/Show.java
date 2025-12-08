package ru.yandex.practicum.shows;

import ru.yandex.practicum.people.*;
import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    public void getDirector() {
        System.out.println(director.toString());
    }

    public void getListOfActors() {
        if (!(listOfActors.isEmpty())) {
            for (Actor actor : listOfActors) {
                System.out.println(actor.toString());
            }
        }
    }

    public void addActor(Actor actor) {
        if (!listOfActors.contains(actor)) {
            listOfActors.add(actor);
        }
    }

    public void replaceActor(Actor newActor, String surname) {
        boolean foundActor = false;
        for (Actor actor : listOfActors) {
            if (actor.getSurname().equals(surname)) {
                foundActor = true;
            }
            if (foundActor) {
                listOfActors.remove(actor);
                listOfActors.add(newActor);
                break;
            }
        }
        if (!foundActor) {
            System.out.println("Актер c фамилией \"" + surname + "\" не состоит в постановке");
        }
    }
}
