package br.com.cmaia.domain.validator;

import java.util.Collection;

public interface Validator<T> {
    Validator<T> validate(T instance);
    void verify();
    Collection<Reason> getReasons();
}
