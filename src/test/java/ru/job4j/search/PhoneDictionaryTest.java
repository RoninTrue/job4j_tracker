package ru.job4j.search;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;

class PhoneDictionaryTest {

    @Test
    void whenFindByName() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phoneDictionary.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    void whenNotFind() {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Sergey", "Vasenev", "89000", "Tomsk"));
        var persons = phoneDictionary.find("vasenev");
        assertTrue(persons.isEmpty());
    }
}