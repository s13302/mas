package pl.s13302.mas.model;

import pl.s13302.mas.extension.BaseObject;

import java.math.BigDecimal;

public class Product extends BaseObject {

    private BigDecimal nettoPrice;

    public Product(BigDecimal nettoPrice) {
        super();
        setNettoPrice(nettoPrice);
    }

    public Product(long id, BigDecimal nettoPrice) {
        super(id);
        setNettoPrice(nettoPrice);
    }

    public BigDecimal getNettoPrice() {
        return nettoPrice;
    }

    public void setNettoPrice(BigDecimal nettoPrice) {
        if (nettoPrice == null ||
                nettoPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Netto price is requred and cannot be lower than 0");
        }
        this.nettoPrice = nettoPrice;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append(super.toString()).append(", ");
        sb.append("nettoPrice=").append(nettoPrice);
        sb.append('}');
        return sb.toString();
    }
}
