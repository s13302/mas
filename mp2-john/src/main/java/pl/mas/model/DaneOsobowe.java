package pl.mas.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DaneOsobowe {

    private final String imie;
    private final String nazwisko;
    private final String numerISeriaDokumentu;

    private Set<Wypozyczenie> wypozyczenia = new HashSet<>();

    public DaneOsobowe(String imie, String nazwisko, String numerISeriaDokumentu) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerISeriaDokumentu = numerISeriaDokumentu;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getNumerISeriaDokumentu() {
        return numerISeriaDokumentu;
    }

    public Collection<Wypozyczenie> getWypozyczenia() {
        return Collections.unmodifiableCollection(wypozyczenia);
    }

    public void addWypozyczenie(Wypozyczenie wypozyczenie) {
        if (! wypozyczenia.contains(wypozyczenie)) {
            wypozyczenia.add(wypozyczenie);
            wypozyczenie.setDaneOsobowe(this);
        }
    }

    public void removeWypozyczenie(Wypozyczenie wypozyczenie) {
        if (wypozyczenia.contains(wypozyczenie)) {
            wypozyczenia.remove(wypozyczenie);
            wypozyczenie.setDaneOsobowe(null);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DaneOsobowe{");
        sb.append("imie='").append(imie).append('\'');
        sb.append(", nazwisko='").append(nazwisko).append('\'');
        sb.append(", numerISeriaDokumentu='").append(numerISeriaDokumentu).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
