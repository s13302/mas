package pl.mas.model;

public class Narty extends Sprzet {

    private final double dlugosc;

    public Narty(String marka, String model, String numerSeryjny, double dlugosc) {
        super(marka, model, numerSeryjny);
        this.dlugosc = dlugosc;
    }

    public double getDlugosc() {
        return dlugosc;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Narty{");
        sb.append("dlugosc=").append(dlugosc);
        sb.append('}');
        return sb.toString();
    }
}
