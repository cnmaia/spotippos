package br.com.cmaia.domain.validator;

public interface Validator<T> {
    Validator<T> validate(T instance);
    void verify();
}
