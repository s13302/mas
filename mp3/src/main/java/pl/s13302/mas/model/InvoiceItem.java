package pl.s13302.mas.model;

import java.math.BigDecimal;

public abstract class InvoiceItem {

    private String name;
    private double amount;
    private BigDecimal nettoValue;

    public InvoiceItem(String name, double amount, BigDecimal nettoValue) {
        this.name = name;
        this.amount = amount;
        this.nettoValue = nettoValue;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public BigDecimal getNettoValue() {
        return nettoValue;
    }

    public BigDecimal getNettoAmount() {
        return this.getNettoValue().multiply(BigDecimal.valueOf(getAmount()));
    }

    public BigDecimal getVatValue() {
        return this.getNettoValue().multiply(BigDecimal.valueOf(getVatTax().getVatValue()));
    }

    public BigDecimal getVatAmount() {
        return this.getNettoAmount().multiply(BigDecimal.valueOf(getVatTax().getVatValue()));
    }

    public BigDecimal getBruttoValue() {
        return getNettoValue().add(getVatValue());
    }

    public BigDecimal getBruttoAmount() {
        return getNettoAmount().add(getVatAmount());
    }

    public abstract VatTax getVatTax();

    @Override
    public String toString() {
        return "InvoiceItem{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", nettoValue=" + nettoValue +
                ", vatTax=" + getVatTax() +
                '}';
    }
}
