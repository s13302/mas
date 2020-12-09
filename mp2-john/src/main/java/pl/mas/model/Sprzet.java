package pl.mas.model;

public abstract class Sprzet {

    private final String marka;
    private final String model;
    private final String numerSeryjny;

    private MagazynSprzetu magazyn;

    public Sprzet(String marka, String model, String numerSeryjny) {
        this.marka = marka;
        this.model = model;
        this.numerSeryjny = numerSeryjny;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public MagazynSprzetu getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(MagazynSprzetu magazyn) {
        if (this.magazyn != magazyn) {
            if (this.magazyn != null) {
                this.magazyn.removeSprzet(this);
            }
            this.magazyn = magazyn;
            if (magazyn != null) {
                magazyn.addSprzet(this);
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sprzet{");
        sb.append("marka='").append(marka).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", numerSeryjny='").append(numerSeryjny).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
