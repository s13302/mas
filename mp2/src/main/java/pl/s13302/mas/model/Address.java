package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

public class Address extends ObjectPlus {

    private static final long serialVersionUID = 1L;

    private String street;
    private String houseNo;
    private String city;
    private String zipCode;
    private String country;
    private Library library;

    public Address(String street, String houseNo, String city, String zipCode) {
        this(street, houseNo, city, zipCode, "Polska");
    }

    public Address(String street, String houseNo, String city, String zipCode, String country) {
        setStreet(street);
        setHouseNo(houseNo);
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        if (getLibrary() != library) {
            if (getLibrary() != null) {
                getLibrary().removeAddressAssociation(this);
            }
            this.library = library;
            if (library != null) {
                library.setAddress(this);
            }
        }
    }

    protected void removeLibraryAssociation(Library library) {
        if (this.library != null && this.library == library) {
            this.library = null;
            library.removeAddressAssociation(this);
        }
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + getStreet() + '\'' +
                ", houseNo='" + getHouseNo() + '\'' +
                ", city='" + getCity() + '\'' +
                ", zipCode='" + getZipCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                '}';
    }
}
