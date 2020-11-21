package pl.s13302.mas;

import pl.s13302.mas.extension.ObjectPlus;
import pl.s13302.mas.model.Address;
import pl.s13302.mas.model.Person;
import pl.s13302.mas.model.Student;

import java.time.LocalDate;

public class Main {

    private static Address address, address1;
    private static Student student, student1;

    public static void main(String[] args) {
        if (ObjectPlus.loadExtension()) { // Ekstensja trwałość - ładowanie z zapisanego pliku + Metoda klasowa
            address = Address.findAddressInExtension("Koszykowa", 1 , "Warszawa", "00-000");
            address1 = Address.findAddressInExtension(null, 54, "Warszawa", "00-834");

            student = Student.findStudentInExtenstion("Kazimierz", "Kowalski", address, LocalDate.of(1998, 9, 10), "Sieci Urządzeń Mobilnych");
            student1 = Student.findStudentInExtenstion("Mirosław", "Nowak", address1, LocalDate.of(1950, 2, 2), "Spec1", "Spec2", "Spec3");
        } else {
            address = new Address("Koszykowa", 1, "Warszawa", "00-000");
            address1 = new Address(/*"Koszykowa", */54, "Warszawa", "00-834"); // Atrybut street jest opcjonalny (zakomentowany)

            student = new Student("Kazimierz", "Kowalski", address, LocalDate.of(1998, 9, 10), "Sieci Urządzeń Mobilnych");
            student1 = new Student("Mirosław", "Nowak", address1, LocalDate.of(1950, 2, 2), "Spec1", "Spec2", "Spec3");
        }

        System.out.println("Adres: " + student.getAddress()); // Atrybut złożony
        System.out.println("Wiek: " + student.getAge()); // Atrybut pochodny

        System.out.println("Specjalizacje: " + student1.getSpecializations()); // Atrybut powtarzalny

        System.out.println("Minimalny wiek studenta: " + Student.MIN_AGE); // Atrybut klasowy
        System.out.println("Obliczanie wieku: " + Person.countAge(LocalDate.now())); // Metoda klasowa

        student1.setBirthDate(LocalDate.of(1970, 1, 1)); // Przesłonięcie
        student1.setBirthDate(LocalDate.of(1950, 2, 2)); // Przesłonięcie

        System.out.println(String.format("[Student] Ekstensja (%d): %s", ObjectPlus.getExtension(Student.class).size(), ObjectPlus.getExtension(Student.class).toString())); // Ekstensja - wyświetlenie w konsoli całej ekstensji
        System.out.println(String.format("[Adres] Ekstensja (%d): %s", ObjectPlus.getExtension(Address.class).size(), ObjectPlus.getExtension(Address.class).toString())); // Ekstensja - wyświetlenie w konsoli całej ekstensji
        System.out.println(String.format("[Person] Ekstensja (%d): %s", ObjectPlus.getExtension(Person.class).size(), ObjectPlus.getExtension(Person.class).toString())); // Ekstensja - wyświetlenie w konsoli całej ekstensji

        student1.addSpecialization("Specjalizacja 1"); // Przeciążanie metod - metoda przyjmuje pojedynczy obiekt typu String
        student1.addSpecialization("Specjalizacja 2", "Specjalizacja 3", "Specjalizacja 4"); // Przeciążanie metod - metoda przyjmuje wiele obiektów typu String
        student1.addSpecialization(new String[] {"Specjalizacja 5", "Specjalizacja 6", "Specjalizacja 7"}); // Przeciążanie metod - metoda przyjmuje tablicę obieków typu String
        student1.removeSpecialization("Specjalizacja 1", "Specjalizacja 2", "Specjalizacja 3", "Specjalizacja 4", "Specjalizacja 5", "Specjalizacja 6", "Specjalizacja 7");

        ObjectPlus.saveExtension(); // Ekstensja trwałość - zapis do pliku + Metoda klasowa
    }

}
