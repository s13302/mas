package pl.s13302.mas.model.invoice.status;

import pl.s13302.mas.model.contracor.Buyer;
import pl.s13302.mas.model.contracor.Seller;
import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;

public class PaidInvoice extends Invoice {

    public PaidInvoice(InvoiceTypeEnum invoiceType, String invoiceNo, Buyer buyer, Seller seller) {
        super(invoiceType, invoiceNo, buyer, seller);
    }

    public PaidInvoice(Invoice previousInvoice) {
        super(previousInvoice);
    }

}
