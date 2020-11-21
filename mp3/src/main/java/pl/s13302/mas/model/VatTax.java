package pl.s13302.mas.model;

public enum VatTax {

    VAT_23(0.23), VAT_8(0.08), VAT_0(0);

    private double vatValue;

    private VatTax(double value) {
        this.vatValue = value;
    }

    public double getVatValue() {
        return vatValue;
    }
}
