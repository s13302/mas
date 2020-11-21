package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person extends ObjectPlus {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        super();
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(getDateOfBirth(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", age=" + getAge() +
                '}';
    }
}
