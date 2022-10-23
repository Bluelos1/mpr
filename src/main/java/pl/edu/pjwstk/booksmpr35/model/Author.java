package pl.edu.pjwstk.booksmpr35.model;

import java.time.LocalDate;

public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Author() {
    }

    public Author(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
