package pl.s13302.mas.model;

import pl.s13302.mas.base.BaseObject;

import java.math.BigDecimal;

public class Product extends BaseObject {

    private String productName;
    private BigDecimal nettoValue;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getNettoValue() {
        return nettoValue;
    }

    public void setNettoValue(BigDecimal nettoValue) {
        this.nettoValue = nettoValue;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append(super.toString());
        sb.append("productName='").append(productName).append('\'');
        sb.append(", nettoValue=").append(nettoValue);
        sb.append('}');
        return sb.toString();
    }
}
