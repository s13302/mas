package pl.s13302.mas.model;

import pl.s13302.mas.extension.BaseObject;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class Invoice extends BaseObject {

    private String number;
    private Collection<InvoiceItem> items = new TreeSet<>(Comparator.comparing(InvoiceItem::getNettoPrice));

    public Invoice(String number) {
        super();
        setNumber(number);
    }

    public Invoice(String number, long id) {
        super(id);
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number == null) {
            throw new IllegalArgumentException("Invoice number cannot be null");
        }
        this.number = number;
    }

    public Collection<InvoiceItem> getItems() {
        return Collections.unmodifiableCollection(items);
    }

    public void addItem(InvoiceItem item) {
        if (items.contains(item)) return;
        this.items.add(item);
    }

    public BigDecimal getNettoPrice() {
        return items.stream()
            .map(InvoiceItem::getNettoPrice)
            .reduce(BigDecimal::add)
            .get();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append(super.toString()).append(", ");
        sb.append("number='").append(number).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
