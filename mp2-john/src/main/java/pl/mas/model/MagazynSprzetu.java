package pl.mas.model;

import java.util.*;

public class MagazynSprzetu {

    private final Map<String, Sprzet> dostepnySprzet = new HashMap<>();
    private final Set<Grafik> grafik = new HashSet<>();

    public Sprzet getSprzet(String numerSeryjny) {
        return dostepnySprzet.getOrDefault(numerSeryjny, null);
    }


    Collection<Sprzet> getSprzet() {
        return dostepnySprzet.values();
    }

    public void addSprzet(Sprzet sprzet) {
        if (sprzet != null) {
            if (!dostepnySprzet.containsKey(sprzet.getNumerSeryjny())) {
                dostepnySprzet.put(sprzet.getNumerSeryjny(), sprzet);
                sprzet.setMagazyn(this);
            }
        }
    }

    public void removeSprzet(String numerSeryjny) {
        if (numerSeryjny != null) {
            Sprzet sprzet = getSprzet(numerSeryjny);
            removeSprzet(sprzet);
        }
    }

    void removeSprzet(Sprzet sprzet) {
        if (dostepnySprzet.containsValue(sprzet)) {
            dostepnySprzet.remove(sprzet.getNumerSeryjny());
            sprzet.setMagazyn(null);
        }
    }

    public Set<Grafik> getGrafik() {
        return Collections.unmodifiableSet(grafik);
    }

    public void addGrafik(Grafik grafik) {
        if (! this.grafik.contains(grafik) && grafik != null) {
            this.grafik.add(grafik);
            grafik.setMagazynSprzetu(this);
        }
    }

    public void removeGrafik(Grafik grafik) {
        if (this.grafik.contains(grafik)) {
            this.grafik.remove(grafik);
            grafik.setMagazynSprzetu(null);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MagazynSprzetu{");
        sb.append("dostepnySprzet=").append(dostepnySprzet);
        sb.append('}');
        return sb.toString();
    }
}
