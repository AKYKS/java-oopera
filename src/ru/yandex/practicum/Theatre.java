package ru.yandex.practicum;

import ru.yandex.practicum.people.*;
import ru.yandex.practicum.shows.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Theatre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Состав нашего театра имени Вячеслава
        Actor actor1 = new Actor("Валерия","Тильт", Gender.FEMALE, 140);
        Actor actor2 = new Actor("Владимир", "Четкий", Gender.MALE, 200);
        Actor actor3 = new Actor("Александр", "Малой", Gender.MALE, 160);
        ArrayList<Actor> actorsList = new ArrayList<>();
        actorsList.add(actor1);
        actorsList.add(actor2);
        actorsList.add(actor3);
        Director director = new Director("Павел", "Талый", Gender.MALE, 20);
        Person musicAuthor = new Person("Наташа", "Юху", Gender.FEMALE);
        Person choreographer = new Person("Мейби", "Бейби", Gender.FEMALE);

        //Наш репертуар
        ArrayList<Actor> actorsOfShow = new ArrayList<>();
        actorsOfShow.add(actor2);
        Show show = new Show("Что кайф", 120, director, actorsOfShow);

        ArrayList<Actor> actorsOfOpera = new ArrayList<>();
        actorsOfOpera.add(actor2);
        String librettoTextOpera = "Название: «А когда не делал»\n" +
                "Жанр: современная камерная опера";
        Opera opera = new Opera("А когда не делал", 120, director, actorsOfOpera, musicAuthor,
                librettoTextOpera, 10);

        ArrayList<Actor> actorsOfBallet = new ArrayList<>();
        actorsOfBallet.add(actor1);
        actorsOfBallet.add(actor3);
        String librettoTextBallet = "Жанр: трагикомедия с элементами абсурда.\n" +
                "Тон: ироничный, но тёплый; смех сквозь слёзы.\n" +
                "Место действия: условное пространство, напоминающее одновременно квартиру, офис и вокзал.\n" +
                "Время: «сейчас и всегда» — вне конкретной эпохи.";
        Ballet ballet = new Ballet("А когда мы уже того", 120, director, actorsOfBallet, musicAuthor,
                librettoTextBallet, choreographer);

        //Меню
        while(true) {
            printMenu();
            int command = sc.nextInt();
            if(command == 1) { //Добавление актера в состав
                System.out.println("Выберите в какой спектакль добавить актера:");
                System.out.println("1. Спектакль");
                System.out.println("2. Опера");
                System.out.println("3. Балет");
                int SelectedShow = sc.nextInt();

                System.out.println("Выберите актера:");
                for(int i = 0; i < actorsList.size(); i++) {
                    System.out.println((i+1) + ". " + actorsList.get(i).toString());
                }
                int SelectedActor = sc.nextInt();

                if(SelectedShow == 1 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    show.addActor(actorsList.get(SelectedActor-1));
                }else if(SelectedShow == 2 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    opera.addActor(actorsList.get(SelectedActor-1));
                }else if(SelectedShow == 3 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    ballet.addActor(actorsList.get(SelectedActor-1));
                }else {
                    System.out.println("Ошибка в выборе спектакля или актера");
                }
            }else if(command == 2) { //Вывод актерского состава
                System.out.println("Актерский состав спектакля:");
                show.getListOfActors();
                System.out.println("\n" + "-".repeat(20) + "\n");
                System.out.println("Актерский состав оперы:");
                opera.getListOfActors();
                System.out.println("\n" + "-".repeat(20) + "\n");
                System.out.println("Актерский состав балета:");
                ballet.getListOfActors();
            }else if(command == 3) { //Замена актера в спектакле
                System.out.println("Выберите в каком спектакле поменять актера:");
                System.out.println("1. Спектакль");
                System.out.println("2. Опера");
                System.out.println("3. Балет");
                int SelectedShow = sc.nextInt();

                System.out.println("Выберите актера для замены:");
                for(int i = 0; i < actorsList.size(); i++) {
                    System.out.println((i+1) + ". " + actorsList.get(i).toString());
                }
                int SelectedActor = sc.nextInt();

                System.out.println("Напишите фамилию актера, которого нужно заменить:");
                String replaceActor = sc.next();

                if(SelectedShow == 1 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    show.replaceActor(actorsList.get(SelectedActor-1), replaceActor);
                    System.out.println("Актерский состав спектакля:");
                    show.getListOfActors();
                }else if(SelectedShow == 2 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    opera.replaceActor(actorsList.get(SelectedActor-1), replaceActor);
                    System.out.println("Актерский состав оперы:");
                    opera.getListOfActors();
                }else if(SelectedShow == 3 && SelectedActor <= actorsList.size() && SelectedActor > 0) {
                    ballet.replaceActor(actorsList.get(SelectedActor-1), replaceActor);
                    System.out.println("Актерский состав балета:");
                    ballet.getListOfActors();
                }else {
                    System.out.println("Ошибка в выборе спектакля или актера");
                }
            }else if(command == 4) { //Вывод либретто оперы и балета
                System.out.println("Либретто оперы:");
                opera.printLibrettoText();
                System.out.println("\n" + "-".repeat(20) + "\n");
                System.out.println("Либретто балета:");
                ballet.printLibrettoText();
            }else if(command == 0) {
                break;
            }else {
                System.out.println("Такой команды нет.");
            }
            System.out.println();
        }
    }

    public static void printMenu() {
        System.out.println("Выбери пункт меню:");
        System.out.println("1. Добавить актера в спектакль");
        System.out.println("2. Вывести актеров спектаклей");
        System.out.println("3. Заменить актера");
        System.out.println("4. Вывести текст либретто");
        System.out.println("0. Выход");
    }
}
