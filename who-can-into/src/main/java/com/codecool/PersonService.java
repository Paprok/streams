package com.codecool;

import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    public String peopleWhoCan(String skill, List<Person> peoples){
        return peoples.stream().filter(person -> person.hasSkill(skill))
                .map(Person::toString)
                .collect(Collectors.joining("\n"));
    }
}
