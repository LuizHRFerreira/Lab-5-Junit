package com.example.tdd.person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public List<String> isValidToInclude(Person person) {

        List<String> errors = new ArrayList<>();

        if (person == null) {
            errors.add("Invalid person");
            return errors;
        }

        if (!isValidName(person.getName())) {
            errors.add("Invalid name");
        }

        if (person.getAge() < 1 || person.getAge() > 200) {
            errors.add("Invalid age");
        }

        if (person.getEmails() == null || person.getEmails().isEmpty()) {
            errors.add("Person must have at least one email");
        } else {
            for (Email email : person.getEmails()) {
                if (!isValidEmail(email)) {
                    errors.add("Invalid email");
                }
            }
        }

        return errors;
    }

    private boolean isValidName(String name) {

        if (name == null) {
            return false;
        }

        return name.trim().matches("^\\p{L}+(\\s+\\p{L}+)+$");
    }

    private boolean isValidEmail(Email email) {

        return email != null
                && email.getName() != null
                && email.getName().matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    }
}
