package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person extends ObjectPlus {

    private static final long serialVersionUID = 1L;

    private String name;
    private String surname;
    private Address address;
    private LocalDate birthDate;

    public Person(String name, String surname, Address address, LocalDate birtthDate) {
        super();
        setName(name);
        setSurname(surname);
        setAddress(address);
        setBirthDate(birtthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("You need to specify name");
        }
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.length() == 0) {
            throw new IllegalArgumentException("You need to specify surname");
        }
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("You need to specify address");
        }
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getAge() {
        return countAge(getBirthDate());
    }

    public static Integer countAge(LocalDate birthDate) {
        if (birthDate != null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                ", birthDate=" + birthDate +
                '}';
    }
}
