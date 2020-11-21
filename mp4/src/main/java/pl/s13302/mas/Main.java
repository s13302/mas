package pl.s13302.mas;

import pl.s13302.mas.model.Customer;
import pl.s13302.mas.model.Invoice;
import pl.s13302.mas.model.InvoiceItem;
import pl.s13302.mas.model.Product;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        /*
        Atrybutów - Product#nettoPrice, InvoiceItem#discount
        Unique - Customer#customerTaxId
        Ordered - Invoice#items
        Własne - Product#nettoPrice
         */

        Product otherService = new Product(new BigDecimal("25.97"));
        Product computerAssembly = new Product(new BigDecimal("99.99"));
//        Product freeService = new Product(new BigDecimal("0")); // Ograniczenie własne - cena netto nie może być niższa niż 0
//        Product nullService = new Product(null); // Ograniczenie własne - cena netto jest wymagana

        Customer rafalPodkonski = new Customer("118-201-69-86");
        Customer sollersConsulting = new Customer("113-246-30-39");
//        Customer rafalPodkonski2 = new Customer("1182016986"); // Ograniczenie unique - Numer TaxID musi być unikalny
//        Customer nullNip = new Customer(null); // Numer TaxID nie może być null
//        Customer emptyNip = new Customer(""); // Ograniczenie atrybutu - numer TaxID musi mieć 10 cyfr
//        Customer tooShortNip = new Customer("118"); // Ograniczenie atrybutu - numer TaxID musi mieć 10 cyfr
//        Customer tooLongtNip = new Customer("11820169860"); // Ograniczenie atrybutu - numer TaxID musi mieć 10 cyfr

        InvoiceItem otherServiceItem = new InvoiceItem(otherService, 1, 0.3);
        InvoiceItem assemblyComputerItem = new InvoiceItem(computerAssembly, 2, 0.13);
//        InvoiceItem otherServiceItemWrongDiscount = new InvoiceItem(otherService, 1, 1.1); // Ograniczenie atrybutu - Zniżka musi być w przedziale <0, 1>
//        InvoiceItem otherServiceItemWrongCount = new InvoiceItem(otherService, 0, 1.0); // Ograniczenie atrybutu - liczba sztuk nie może być mniejsza niż 1

        Invoice invoice = new Invoice("2018/12/001");
        invoice.addItem(assemblyComputerItem);
        invoice.addItem(otherServiceItem); // Ograniczenie Ordered - pozycje na fakturze są uporządkowane wg. wartości od malejącej do rosnącej
        System.out.println(invoice);
    }

}
