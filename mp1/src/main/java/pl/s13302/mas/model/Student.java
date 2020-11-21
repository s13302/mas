package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Student extends Person {

    private static final long serialVersionUID = 1L;

    public static final int MIN_AGE = 18;

    private List<String> specializations = new ArrayList<>();

    public Student(String name, String surname, Address address, LocalDate birtthDate, String... specializations) {
        super(name, surname, address, birtthDate);
        addSpecialization(specializations);
    }

    public List<String> getSpecializations() {
        return Collections.unmodifiableList(specializations);
    }

    public void addSpecialization(String specialization) {
        if (specialization == null || specialization.length() == 0) {
            throw new IllegalArgumentException("Specialization which you specified needs to have at least one character");
        }
        this.specializations.add(specialization);
    }

    public void addSpecialization(String... specializations) {
        if (specializations == null || specializations.length == 0) {
            throw new IllegalArgumentException("You need to specify at least one specialization");
        }
        for (String specialization : specializations) {
            addSpecialization(specialization);
        }
    }

    public void removeSpecialization(String specialization) {
        if (getSpecializations().contains(specialization)) {
            specializations.remove(specialization);
        }
    }

    public void removeSpecialization(String... specialization) {
        if (specialization != null && specialization.length > 0) {
            for (String spec : specialization) {
                removeSpecialization(spec);
            }
        }
    }

    @Override
    public void setBirthDate(LocalDate birthDate) {
        if (birthDate == null) {
            throw new IllegalArgumentException("Your age cannot be null");
        }
        if (countAge(birthDate) <= MIN_AGE) {
            throw new IllegalArgumentException("Your age is less than " + MIN_AGE);
        }
        super.setBirthDate(birthDate);
    }

    public static Student findStudentInExtenstion(String name, String surname, Address address, LocalDate birthDate, String... specializations) {
        for (ObjectPlus objectPlus : getExtension(Student.class)) {
            if (objectPlus instanceof Student) {
                Student student = (Student) objectPlus;
                if (student.getName().equals(name)
                        && student.getSurname().equals(surname)
                        && student.getAddress().equals(address)
                        && student.getBirthDate().equals(birthDate)
                        && student.getSpecializations().containsAll(Arrays.asList(specializations))) {
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "specializations=" + specializations +
                '}';
    }
}
