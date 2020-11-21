package pl.s13302.mas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reader extends Person {

    private static final long serialVersionUID = 1L;

    private List<Renting> rentings = new ArrayList<>();

    public Reader(String firstName, String middleName, String lastName, LocalDate dateOfBirth) {
        super(firstName, middleName, lastName, dateOfBirth);
    }

    public List<Renting> getRentings() {
        return Collections.unmodifiableList(rentings);
    }

    public void addRenting(Renting renting) {
        if (!rentings.contains(renting)) {
            rentings.add(renting);
            renting.setReader(this);
        }
    }

    public void removeRenting(Renting renting) {
        if (getRentings().contains(renting)) {
            rentings.remove(renting);
            renting.removeReaderAssociation(this);
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                '}';
    }
}
