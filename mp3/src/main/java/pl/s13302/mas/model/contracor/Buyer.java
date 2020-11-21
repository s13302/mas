package pl.s13302.mas.model.contracor;

import pl.s13302.mas.model.Contractor;

public class Buyer extends Contractor {

    public Buyer(String name, String nip) {
        super(name, nip);
    }

    public Buyer(Contractor previousContractor) {
        super(previousContractor);
    }
}
