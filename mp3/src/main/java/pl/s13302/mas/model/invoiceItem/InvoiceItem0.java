package pl.s13302.mas.model.invoiceItem;

import pl.s13302.mas.model.InvoiceItem;
import pl.s13302.mas.model.VatTax;

import java.math.BigDecimal;

public class InvoiceItem0 extends InvoiceItem {

    public InvoiceItem0(String name, double amount, BigDecimal nettoValue) {
        super(name, amount, nettoValue);
    }

    @Override
    public VatTax getVatTax() {
        return VatTax.VAT_0;
    }

}
