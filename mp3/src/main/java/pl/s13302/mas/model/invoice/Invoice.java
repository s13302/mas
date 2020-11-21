package pl.s13302.mas.model.invoice;

import pl.s13302.mas.model.InvoiceItem;
import pl.s13302.mas.model.contracor.Buyer;
import pl.s13302.mas.model.contracor.Seller;
import pl.s13302.mas.model.invoice.type.CostInvoice;
import pl.s13302.mas.model.invoice.type.ProformaInvoice;
import pl.s13302.mas.model.invoice.type.SaleInvoice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Invoice {

    private String invoiceNo;
    private List<InvoiceItem> invoiceItems;
    private Buyer buyer;
    private Seller seller;

    private InvoiceType invoiceType;

    public Invoice(InvoiceTypeEnum invoiceType, String invoiceNo, Buyer buyer, Seller seller) {
        setInvoiceNo(invoiceNo);
        setInvoiceType(invoiceType);
        setBuyer(buyer);
        setSeller(seller);
        this.invoiceItems = new ArrayList<>();
    }

    public Invoice(Invoice previousInvoice) {
        this(previousInvoice.getInvoiceType().getInvoiceTypeEnum()
                , previousInvoice.getInvoiceNo()
                , previousInvoice.getBuyer()
                , previousInvoice.getSeller());
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public List<InvoiceItem> getInvoiceItems() {
        return Collections.unmodifiableList(this.invoiceItems);
    }

    public void addItem(InvoiceItem item) {
        if (! getInvoiceItems().contains(item)) {
            this.invoiceItems.add(item);
        }
    }

    public void removeItem(InvoiceItem item) {
        if (getInvoiceItems().contains(item)) {
            this.invoiceItems.remove(item);
        }
    }

    public Buyer getBuyer() {
        return buyer;
    }

    private void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Seller getSeller() {
        return seller;
    }

    private void setSeller(Seller seller) {
        this.seller = seller;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    private void setInvoiceType(InvoiceTypeEnum invoiceType) {
        switch (invoiceType) {
            case COST:
                this.invoiceType = new CostInvoice(this);
                break;
            case SALE:
                this.invoiceType = new SaleInvoice(this);
                break;
            case PROFORMA:
                this.invoiceType = new ProformaInvoice(this);
                break;
            default:
                throw new IllegalArgumentException("Passed wrong invoice type");
        }
    }

    public BigDecimal getNettoAmount() {
        return getInvoiceType().getNettoAmount();
    }

    public BigDecimal getBruttoAmount() {
        return getInvoiceType().getBruttoAmount();
    }

    public BigDecimal getTaxAmount() {
        return getInvoiceType().getTaxAmount();
    }

}
