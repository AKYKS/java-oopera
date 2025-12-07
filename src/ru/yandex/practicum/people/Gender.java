package ru.yandex.practicum.people;

public enum Gender {
    MALE,
    FEMALE;

    public String toString(Gender gender) {
        if (gender == Gender.MALE) {
            return "мужчина";
        } else if (gender == Gender.FEMALE) {
            return "женщина";
        }
        return null;
    }
}
