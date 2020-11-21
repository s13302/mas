package pl.s13302.mas.model.invoice.status;

import pl.s13302.mas.model.contracor.Buyer;
import pl.s13302.mas.model.contracor.Seller;
import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;

import java.util.logging.Logger;

public class PartialyPaidInvoice extends Invoice {

    private static final Logger LOGGER = Logger.getLogger(PartialyPaidInvoice.class.getName());

    public PartialyPaidInvoice(InvoiceTypeEnum invoiceType, String invoiceNo, Buyer buyer, Seller seller) {
        super(invoiceType, invoiceNo, buyer, seller);
    }

    public PartialyPaidInvoice(Invoice previousInvoice) {
        super(previousInvoice);
    }

    public PaidInvoice payRest() {
        LOGGER.info("CONNECTING TO WEB SERVICE: Pay Invoice " + getInvoiceNo());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        LOGGER.info("CONNECTION TO WEB SERVICE FINISHED: Invoice " + getInvoiceNo() + " is payed");
        return new PaidInvoice(this);
    }

}
