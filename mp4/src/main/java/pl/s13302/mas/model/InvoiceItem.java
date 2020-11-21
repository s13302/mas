package pl.s13302.mas.model;

import pl.s13302.mas.extension.BaseObject;

import java.math.BigDecimal;

public class InvoiceItem extends BaseObject {

    private Product product;
    private int count = 1;
    private double discount = 0.0;

    public InvoiceItem(Product product) {
        super();
        setProduct(product);
    }

    public InvoiceItem(Product product, int count, double discount) {
        this(product);
        setCount(count);
        setDiscount(discount);
    }

    public Product getProduct() {
        return product;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("Count cannot be lower than 1");
        }
        this.count = count;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0.0 || discount > 1.0) {
            throw new IllegalArgumentException("Discount cannot be lower than 0 or greather than 1");
        }
        this.discount = discount;
    }

    public BigDecimal getNettoPrice() {
        BigDecimal discount = product.getNettoPrice().multiply(BigDecimal.valueOf(getDiscount()));
        return product
                .getNettoPrice()
                .subtract(discount)
                .multiply(BigDecimal.valueOf(getCount()));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InvoiceItem{");
        sb.append(super.toString()).append(", ");
        sb.append("product=").append(product);
        sb.append(", count=").append(count);
        sb.append(", discount=").append(discount);
        sb.append(", nettoPrice=").append(getNettoPrice());
        sb.append('}');
        return sb.toString();
    }
}
