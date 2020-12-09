package pl.mas.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Instruktor {

    private String imie;
    private String nazwisko;

    private final Set<Grafik> grafik = new HashSet<>();
    private final Set<SprzetInstruktora> sprzetInstruktora = new HashSet<>();

    public Instruktor(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Set<Grafik> getGrafik() {
        return Collections.unmodifiableSet(grafik);
    }

    public void addGrafik(Grafik grafik) {
        if (! this.grafik.contains(grafik) && grafik != null) {
            this.grafik.add(grafik);
            grafik.setInstruktor(this);
        }
    }

    public void removeGrafik(Grafik grafik) {
        if (this.grafik.contains(grafik)) {
            this.grafik.remove(grafik);
            grafik.setInstruktor(null);
        }
    }

    public Set<SprzetInstruktora> getSprzetInstruktora() {
        return Collections.unmodifiableSet(sprzetInstruktora);
    }

    public void addSprzetInstruktora(String rodzaj) {
        SprzetInstruktora sprzetInstruktora = new SprzetInstruktora(this, rodzaj);
        this.sprzetInstruktora.add(sprzetInstruktora);
    }

    public class SprzetInstruktora {

        private final Instruktor instruktor;
        private String rodzaj;

        private SprzetInstruktora(Instruktor instruktor, String rodzaj) {
            this.instruktor = instruktor;
            setRodzaj(rodzaj);
        }

        public Instruktor getInstruktor() {
            return instruktor;
        }

        public String getRodzaj() {
            return rodzaj;
        }

        public void setRodzaj(String rodzaj) {
            if ("narty".equalsIgnoreCase(rodzaj) || "snowboard".equalsIgnoreCase(rodzaj)) {
                this.rodzaj = rodzaj;
            } else {
                throw new IllegalArgumentException("Rodzaj może być tylko \"narty\" lub \"snowboard\"");
            }
        }
    }

}
