package ru.academits.bozhko.java;

import java.util.*;

import ru.academits.bozhko.person.Person;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

// создать список из нескольких людей
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Дмитрий", 44));
        persons.add(new Person("Роман", 42));
        persons.add(new Person("Виктор", 27));
        persons.add(new Person("Павел", 32));
        persons.add(new Person("Евгений", 4));
        persons.add(new Person("Анна", 16));
        persons.add(new Person("Екатерина", 30));
        persons.add(new Person("Анастасия", 20));
        persons.add(new Person("Андрей", 33));
        persons.add(new Person("Роман", 33));
        persons.add(new Person("Павел", 10));

        // получить список уникальных имен
        List<String> uniqueNames = persons.stream().map(Person::getName).distinct().collect(Collectors.toList());

        // вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        System.out.println("Уникальные имена: " + uniqueNames.stream().collect(Collectors.joining(", ")));

        // получить список людей младше 18, посчитать для них средний возраст
        System.out.println(System.lineSeparator()+ "Средний возраст из списка людей младше 18: " + persons.stream().filter(age -> age.getAge() < 18).mapToInt(Person::getAge).average());

        // при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Map<String, Double> nameAndAverageAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        nameAndAverageAge.forEach((name, ages) -> System.out.printf("Имя %s: %s%n", name, ages));

        // получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
        List<String> personsBetween20And45 = persons.stream()
                .filter(age -> age.getAge() >= 20 && age.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName).collect(Collectors.toList());
        System.out.println(personsBetween20And45);
    }
}
