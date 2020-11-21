package pl.s13302.mas;

import pl.s13302.mas.model.contracor.Buyer;
import pl.s13302.mas.model.contracor.Seller;
import pl.s13302.mas.model.invoice.Invoice;
import pl.s13302.mas.model.InvoiceItem;
import pl.s13302.mas.model.VatTax;
import pl.s13302.mas.model.invoice.InvoiceTypeEnum;
import pl.s13302.mas.model.invoice.status.PaidInvoice;
import pl.s13302.mas.model.invoice.status.PartialyPaidInvoice;
import pl.s13302.mas.model.invoice.status.UnpaidInvoice;
import pl.s13302.mas.model.invoiceItem.InvoiceItem23;
import pl.s13302.mas.model.invoiceItem.InvoiceItem8;

import java.math.BigDecimal;

/*
* Dziedziczenie wieloaspektowe jest zrealizowane na bazie klasy Invoice
* Pierwszy aspekt: type (CostInvoice, SaleInvoice, ProformaInvoice)
* Drugi aspekt: status (PaidInvoice, UnpaidInvoice) - dodatkowo PartialyPaidInvoice jako status pośredni
 */

public class Main {

    public static void main(String[] args) {
        Buyer buyer = new Buyer("Rafał Podkoński", "118-201-69-86");
        Seller seller = new Seller(buyer); // Dziedziczenie dynamiczne - jeśli posiadamy kontrahenta w bazie to w zależności od kontekstu jest kupującym na fakturze lub sprzedającym

        InvoiceItem item1 = new InvoiceItem23("Intel i7 8700K", 1d, new BigDecimal("1706.50")); // Klasa abstrakcyjna + Dziedziczenie disjoint
        InvoiceItem item2 = new InvoiceItem23("GTX 1080 Ti", 2d, new BigDecimal("2682.11")); // Klasa abstrakcyjna + Dziedziczenie disjoint

        InvoiceItem item3 = new InvoiceItem8("Usługa gastronomiczna 8%", 1d, new BigDecimal("100")); // Klasa abstrakcyjna + Dziedziczenie disjoint

        Invoice invoice = new UnpaidInvoice(InvoiceTypeEnum.COST,"2018/12/001", buyer, seller); // Klasa abstrakcyjna + Dziedziczenie wieloaspektowe
        invoice.addItem(item1);
        invoice.addItem(item2);

        Invoice invoice2 = new PaidInvoice(InvoiceTypeEnum.SALE, "2018/12/001", buyer, seller); // Klasa abstrakcyjna + Dziedziczenie wieloaspektowe
        invoice2.addItem(item3);

//        new UnpaidInvoice(InvoiceTypeEnum.PROFORMA)

        System.out.println("Faktura Kosztowa: ");
        System.out.println(invoice.getBruttoAmount()); // Polimorficzne wywołanie metod - dla faktur kosztowych jest zmieniona definicja pod względem np. raportów
        System.out.println(invoice.getNettoAmount()); // Polimorficzne wywołanie metod - dla faktur kosztowych jest zmieniona definicja pod względem np. raportów
        System.out.println(invoice.getTaxAmount()); // Polimorficzne wywołanie metod - dla faktur kosztowych jest zmieniona definicja pod względem np. raportów

        System.out.println("Faktura Sprzedażowa: ");
        System.out.println(invoice2.getBruttoAmount()); // Polimorficzne wywołanie metod
        System.out.println(invoice2.getNettoAmount()); // Polimorficzne wywołanie metod
        System.out.println(invoice2.getTaxAmount()); // Polimorficzne wywołanie metod

        System.out.println("Operacja płacenia faktury: ");
        if (invoice instanceof UnpaidInvoice) {
            UnpaidInvoice unpaidInvoice = (UnpaidInvoice) invoice;  // Dziedziczenie overlapping + Dziedziczenie wieloaspektowe
            PartialyPaidInvoice partialyPaidInvoice = unpaidInvoice.partialPayInvoice(new BigDecimal("1200"));
            System.out.println(partialyPaidInvoice);
            PaidInvoice paidInvoice = partialyPaidInvoice.payRest();
            System.out.println(paidInvoice);
        }
    }

}
