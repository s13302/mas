package pl.s13302.mas.model.invoice;

import pl.s13302.mas.model.InvoiceItem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class InvoiceType {

    public Invoice invoice;

    public InvoiceType(Invoice invoice) {
        this.invoice = invoice;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public abstract InvoiceTypeEnum getInvoiceTypeEnum();

    public BigDecimal getNettoAmount() {
        return getInvoice()
                .getInvoiceItems()
                .stream()
                .map(InvoiceItem::getNettoAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getBruttoAmount() {
        return getInvoice()
                .getInvoiceItems()
                .stream()
                .map(InvoiceItem::getBruttoAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTaxAmount() {
        return getInvoice()
                .getInvoiceItems()
                .stream()
                .map(InvoiceItem::getVatAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

}
