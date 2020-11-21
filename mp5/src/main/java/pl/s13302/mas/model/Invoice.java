package pl.s13302.mas.model;

import pl.s13302.mas.base.BaseObject;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Invoice extends BaseObject {

    private String invoiceNo;
    private Set<InvoiceItem> items;

    public Invoice() {
        super();
        setItems(new HashSet<>());
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Set<InvoiceItem> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public void addItem(InvoiceItem invoiceItem) {
        items.add(invoiceItem);
    }

    private void setItems(Set<InvoiceItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append(super.toString());
        sb.append("invoiceNo='").append(getInvoiceNo()).append('\'');
        sb.append(", items=").append(getItems());
        sb.append('}');
        return sb.toString();
    }
}
