package pl.s13302.mas.model.invoice.type;

import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.invoice.InvoiceType;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;

public class ProformaInvoice extends InvoiceType {

    public ProformaInvoice(Invoice invoice) {
        super(invoice);
    }

    @Override
    public InvoiceTypeEnum getInvoiceTypeEnum() {
        return InvoiceTypeEnum.PROFORMA;
    }
}
