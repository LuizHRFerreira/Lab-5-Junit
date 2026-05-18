package com.example.tdd.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonDAOTest {

    private final PersonDAO dao = new PersonDAO();

    @Test
    void shouldValidateCorrectPerson() {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(25);
        person.setEmails(List.of(new Email("joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.isEmpty());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "Joao",
            "Joao123",
            "Joao Silva!",
            "   "
    })
    void shouldReturnErrorForInvalidName(String name) {

        Person person = new Person();
        person.setName(name);
        person.setAge(25);
        person.setEmails(List.of(new Email("joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Invalid name"));
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "200"
    })
    void shouldAcceptAgeInsideValidRange(int age) {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(age);
        person.setEmails(List.of(new Email("joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertFalse(errors.contains("Invalid age"));
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "201"
    })
    void shouldReturnErrorForInvalidAge(int age) {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(age);
        person.setEmails(List.of(new Email("joao@email.com")));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Invalid age"));
    }

    @Test
    void shouldReturnErrorWhenEmailsListIsNull() {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(20);

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Person must have at least one email"));
    }

    @Test
    void shouldReturnErrorWhenEmailsListIsEmpty() {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(20);
        person.setEmails(List.of());

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Person must have at least one email"));
    }

    @Test
    void shouldReturnErrorWhenEmailObjectIsNull() {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(20);
        person.setEmails(java.util.Collections.singletonList(null));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Invalid email"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {
            "emailinvalido",
            "@email.com",
            "joao@.com",
            "joao@email.",
            "joao email@email.com"
    })
    void shouldReturnErrorForInvalidEmail(String emailAddress) {

        Person person = new Person();
        person.setName("Joao Silva");
        person.setAge(20);
        person.setEmails(List.of(new Email(emailAddress)));

        List<String> errors = dao.isValidToInclude(person);

        assertTrue(errors.contains("Invalid email"));
    }

    @Test
    void shouldReturnErrorForNullPerson() {

        List<String> errors = dao.isValidToInclude(null);

        assertTrue(errors.contains("Invalid person"));
    }

    @Test
    void shouldReadAndWritePersonFields() {

        Email email = new Email("maria@email.com");
        Person person = new Person();
        person.setId(10);
        person.setName("Maria Souza");
        person.setAge(30);
        person.setEmails(List.of(email));

        assertEquals(10, person.getId());
        assertEquals("Maria Souza", person.getName());
        assertEquals(30, person.getAge());
        assertEquals(List.of(email), person.getEmails());
    }

    @Test
    void shouldReadAndWriteEmailFields() {

        Email email = new Email();
        email.setId(20);
        email.setName("maria@email.com");

        assertEquals(20, email.getId());
        assertEquals("maria@email.com", email.getName());
    }
}
