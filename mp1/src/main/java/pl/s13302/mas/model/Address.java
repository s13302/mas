package pl.s13302.mas.model;

import pl.s13302.mas.extension.ObjectPlus;

import java.util.Objects;

public class Address extends ObjectPlus {

    private static final long serialVersionUID = 1L;

    private String street;
    private int houseNumber;
    private String city;
    private String zipCode;

    public Address(Integer houseNumber, String city, String zipCode) {
        super();
        setHouseNumber(houseNumber);
        setCity(city);
        setZipCode(zipCode);
    }

    public Address(String street, Integer houseNumber, String city, String zipCode) {
        this(houseNumber, city, zipCode);
        setStreet(street);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        if (houseNumber == null) {
            throw new IllegalArgumentException("You need to specify house number");
        }
        if (houseNumber < 0) {
            throw new IllegalArgumentException("House number cannot be less than 0");
        }
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if (city == null || city.length() == 0) {
            throw new IllegalArgumentException("You need to specify city");
        }
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        if (zipCode == null || zipCode.length() == 0) {
            throw new IllegalArgumentException("You need to specify zip code");
        }
        if (!isZipCodeFormatCorrect(zipCode)) {
            throw new IllegalArgumentException("You need to specify zip code in correct format: 99-999");
        }
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return houseNumber == address.houseNumber &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(zipCode, address.zipCode);
    }

    public static Address findAddressInExtension(String street, Integer houseNumber, String city, String zipCode) {
        for (ObjectPlus objectPlus : getExtension(Address.class)) {
            if (objectPlus instanceof Address) {
                Address address = (Address) objectPlus;
                if (address.getHouseNumber() == houseNumber
                        && address.getCity().equals(city)
                        && address.getZipCode().equals(zipCode)
                        && (
                                address.getStreet() == null && street == null
                                        || address.getStreet().equals(street)
                        )) {
                    return address;
                }
            }
        }
        return null;
    }

    private static boolean isZipCodeFormatCorrect(String zipCode) {
        return zipCode.matches("\\d{2}-\\d{3}");
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
