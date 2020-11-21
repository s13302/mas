package pl.s13302.mas.model;

import pl.s13302.mas.extension.BaseObject;

public class Customer extends BaseObject {

    private String customerTaxID;

    public Customer(String customerTaxID) {
        super();
        setCustomerTaxID(customerTaxID);
    }

    public Customer(long id, String customerTaxID) {
        super(id);
        setCustomerTaxID(customerTaxID);
    }

    public String getCustomerTaxID() {
        return customerTaxID;
    }

    public void setCustomerTaxID(final String customerTaxID) {
        if (customerTaxID == null) throw new IllegalArgumentException("customerTaxID cannot be null");
        String newCustomerTaxID = formatCustomerTaxID(customerTaxID);
        if (isCustomerTaxIDValid(newCustomerTaxID) && isCustomerTaxIDUnique(newCustomerTaxID)) {
            this.customerTaxID = newCustomerTaxID;
        } else {
            throw new IllegalArgumentException("customerTaxID is not unique or is invalid");
        }
    }

    private boolean isCustomerTaxIDUnique(String customerTaxID) {
        return ! getExtension(Customer.class)
                .stream()
                .filter(objectPlus -> objectPlus != this)
                .map(objectPlus -> (Customer) objectPlus)
                .map(customer -> customer.getCustomerTaxID())
                .anyMatch(thatCustomerTaxID -> thatCustomerTaxID.equals(customerTaxID));
    }

    private static boolean isCustomerTaxIDValid(final String customerTaxID) {
        return (customerTaxID.length() == 10);
    }

    private static String formatCustomerTaxID(final String customerTaxID) {
        if (customerTaxID == null) return null;
        return customerTaxID.replaceAll("\\D", "");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append(super.toString()).append(", ");
        sb.append("customerTaxID='").append(customerTaxID).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
