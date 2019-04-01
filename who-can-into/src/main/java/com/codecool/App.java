package com.codecool;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Karol", "696 969 696", Arrays.asList("java", "troll")),
                new Person("Krzysio", "777 777 777", Arrays.asList("java", "troll", "nice")),
                new Person("Rafal", "666 666 666", Collections.singletonList("dumb"))
        );

        PersonService service = new PersonService();
        System.out.println(service.peopleWhoCan("java", persons));
    }
}
