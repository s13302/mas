package pl.s13302.mas;

import pl.s13302.mas.manager.InvoiceItemManager;
import pl.s13302.mas.manager.InvoiceManager;
import pl.s13302.mas.manager.ProductManager;
import pl.s13302.mas.model.Invoice;
import pl.s13302.mas.model.InvoiceItem;
import pl.s13302.mas.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class Main {

    private static final long INVOICE_ID = 1L;

    private static final long CHOCOLATE_ID = 1L;
    private static final long BREAD_ID = 2L;
    private static final long BUTTER_ID = 3L;

    private static ProductManager productManager;
    private static InvoiceItemManager invoiceItemManager;
    private static InvoiceManager invoiceManager;

    public static void main(String[] args) {
        initManagers();
        initData();

        Invoice invoice = invoiceManager.getById(INVOICE_ID); // MR - Klasy
        invoice.getItems().forEach(item -> {
            System.out.println(item.getProduct()); // MR - Asocjacje
        });
        System.out.println(invoice);
    }

    private static void initManagers() {
        productManager = new ProductManager();
        invoiceItemManager = new InvoiceItemManager();
        invoiceManager = new InvoiceManager();
    }

    private static void initData() {
        initProducts();
        initInvoices();
    }

    private static void initProducts() {
        Product chocolate = new Product();
        chocolate.setId(CHOCOLATE_ID);
        chocolate.setProductName("Chocolate");
        chocolate.setNettoValue(new BigDecimal("2.90"));

        Product bread = new Product();
        bread.setId(BREAD_ID);
        bread.setProductName("Bread");
        bread.setNettoValue(new BigDecimal("1.75"));

        Product butter = new Product();
        butter.setId(BUTTER_ID);
        butter.setProductName("Butter");
        butter.setNettoValue(new BigDecimal("7.98"));

        productManager.save(chocolate);
        productManager.save(bread);
        productManager.save(butter);
    }

    private static void initInvoices() {
        Product chocolate = productManager.getById(CHOCOLATE_ID);
        Product bread = productManager.getById(BREAD_ID);
        Product butter = productManager.getById(BUTTER_ID);

        Invoice invoice = new Invoice();
        invoice.setId(INVOICE_ID);
        invoice.setInvoiceNo("2019/001");

        InvoiceItem itemBread = new InvoiceItem();
        itemBread.setProduct(bread);
        itemBread.setNettoAmount(bread.getNettoValue().multiply(new BigDecimal("2")));
        InvoiceItem itemButter = new InvoiceItem();
        itemButter.setProduct(butter);
        itemButter.setNettoAmount(butter.getNettoValue());
        invoice.addItem(itemBread);
        invoice.addItem(itemButter);

        invoiceItemManager.save(itemBread);
        invoiceItemManager.save(itemButter);
        invoiceManager.save(invoice);
    }

}
