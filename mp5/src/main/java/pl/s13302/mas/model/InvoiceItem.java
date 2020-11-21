package pl.s13302.mas.model;

import pl.s13302.mas.base.BaseObject;

import java.math.BigDecimal;

public class InvoiceItem extends BaseObject {

    private Product product;
    private BigDecimal nettoAmount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getNettoAmount() {
        return nettoAmount;
    }

    public void setNettoAmount(BigDecimal nettoAmount) {
        this.nettoAmount = nettoAmount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvoiceItem{");
        sb.append(super.toString());
        sb.append("product=").append(getProduct());
        sb.append(", nettoAmount=").append(getNettoAmount());
        sb.append('}');
        return sb.toString();
    }
}
