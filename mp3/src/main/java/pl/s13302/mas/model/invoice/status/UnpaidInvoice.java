package pl.s13302.mas.model.invoice.status;

import pl.s13302.mas.model.contracor.Buyer;
import pl.s13302.mas.model.contracor.Seller;
import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class UnpaidInvoice extends Invoice {

    private static final Logger LOGGER = Logger.getLogger(UnpaidInvoice.class.getName());

    public UnpaidInvoice(InvoiceTypeEnum invoiceType, String invoiceNo, Buyer buyer, Seller seller) {
        super(invoiceType, invoiceNo, buyer, seller);
    }

    public UnpaidInvoice(Invoice previousInvoice) {
        super(previousInvoice);
    }

    public PaidInvoice payInvoice() {
        LOGGER.info("CONNECTING TO WEB SERVICE: Pay Invoice " + getInvoiceNo());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        LOGGER.info("CONNECTION TO WEB SERVICE FINISHED: Invoice " + getInvoiceNo() + " is payed");
        return new PaidInvoice(this);
    }

    public PartialyPaidInvoice partialPayInvoice(BigDecimal amount) {
        LOGGER.info("CONNECTING TO WEB SERVICE: Partialy Pay Invoice " + getInvoiceNo());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        LOGGER.info("CONNECTION TO WEB SERVICE FINISHED: Partialy Pay Invoice " + getInvoiceNo());
        return new PartialyPaidInvoice(this);
    }

}
