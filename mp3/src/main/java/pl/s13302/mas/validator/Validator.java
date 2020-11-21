package pl.s13302.mas.validator;

public interface Validator<T> {

    public boolean doValidate(final T data);

}
