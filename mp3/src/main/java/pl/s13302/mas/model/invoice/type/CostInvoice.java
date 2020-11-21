package pl.s13302.mas.model.invoice.type;

import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.invoice.InvoiceType;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostInvoice extends InvoiceType {

    public CostInvoice(Invoice invoice) {
        super(invoice);
    }

    @Override
    public InvoiceTypeEnum getInvoiceTypeEnum() {
        return InvoiceTypeEnum.COST;
    }

    @Override
    public BigDecimal getNettoAmount() {
        BigDecimal result = super.getNettoAmount();
        if (result.compareTo(BigDecimal.ZERO) > 0) {
            return result.negate();
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getBruttoAmount() {
        BigDecimal result = super.getBruttoAmount();
        if (result.compareTo(BigDecimal.ZERO) > 0) {
            return result.negate();
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal getTaxAmount() {
        BigDecimal result = super.getTaxAmount();
        if (result.compareTo(BigDecimal.ZERO) > 0) {
            return result.negate();
        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }
}
