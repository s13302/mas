package pl.s13302.mas.validator;

public class NipValidator implements Validator<String> {

    public static final int NIP_LEN = 10;

    @Override
    public boolean doValidate(final String data) {
        String nip = data.replaceAll("-", "");
        return nip.length() == NIP_LEN;
    }

}
