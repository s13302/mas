package pl.s13302.mas.manager;

import pl.s13302.mas.model.InvoiceItem;

public class InvoiceItemManager implements Manager<InvoiceItem> {

    @Override
    public String className() {
        return InvoiceItem.class.getSimpleName();
    }

}
