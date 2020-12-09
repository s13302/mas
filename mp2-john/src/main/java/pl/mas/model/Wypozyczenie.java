package pl.mas.model;

import java.util.Objects;

public class Wypozyczenie {

    private DaneOsobowe daneOsobowe;

    Wypozyczenie() {
        setDaneOsobowe(null);
    }

    public Wypozyczenie(DaneOsobowe daneOsobowe) {
        this();
        setDaneOsobowe(daneOsobowe);
    }

    public DaneOsobowe getDaneOsobowe() {
        return daneOsobowe;
    }

    public void setDaneOsobowe(DaneOsobowe daneOsobowe) {
        if (! Objects.equals(daneOsobowe, this.daneOsobowe)) {
            if (this.daneOsobowe != null) {
                this.daneOsobowe.removeWypozyczenie(this);
            }
            this.daneOsobowe = daneOsobowe;
            if (daneOsobowe != null) {
                daneOsobowe.addWypozyczenie(this);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Wypozyczenie{");
        sb.append("daneOsobowe=").append(daneOsobowe);
        sb.append('}');
        return sb.toString();
    }
}
