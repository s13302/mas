package pl.s13302.mas.model.contracor;

import pl.s13302.mas.model.Contractor;

public class Seller extends Contractor {

    public Seller(String name, String nip) {
        super(name, nip);
    }

    public Seller(Contractor previousContractor) {
        super(previousContractor);
    }
}
