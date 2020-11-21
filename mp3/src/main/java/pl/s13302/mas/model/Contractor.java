package pl.s13302.mas.model;

import pl.s13302.mas.validator.NipValidator;
import pl.s13302.mas.validator.Validator;

public abstract class Contractor {

    private static final Validator<String> validator = new NipValidator();

    private String name;
    private String nip;

    public Contractor(String name, String nip) {
        setName(name);
        setNip(nip);
    }

    public Contractor(Contractor previousContractor) {
        setName(previousContractor.getName());
        setNip(previousContractor.getNip());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        if (validator.doValidate(nip)) {
            this.nip = nip;
        } else {
            throw new IllegalArgumentException("Given NIP number seems to be invalid.");
        }
    }
}
