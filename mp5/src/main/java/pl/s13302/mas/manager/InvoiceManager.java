package pl.s13302.mas.manager;

import pl.s13302.mas.model.Invoice;

public class InvoiceManager implements Manager<Invoice> {

    @Override
    public String className() {
        return Invoice.class.getSimpleName();
    }

}
