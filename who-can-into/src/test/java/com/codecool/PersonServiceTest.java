package com.codecool;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PersonServiceTest {

    @Test
    public void testPersonService(){
        List<Person> persons = Arrays.asList(
                new Person("Karol", "696 969 696", Arrays.asList("java", "troll")),
                new Person("Krzysio", "777 777 777", Arrays.asList("java", "troll", "nice")),
                new Person("Rafal", "666 666 666", Collections.singletonList("dumb"))
        );
        PersonService service = new PersonService();
        String expected = "Karol 696 969 696\nKrzysio 777 777 777";

        String acutal = service.peopleWhoCan("java", persons);

        assertEquals(expected, acutal);
    }
}
