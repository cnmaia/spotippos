package br.com.cmaia.domain.validator;

import br.com.cmaia.exception.ValidationException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AbstractValidator<T> implements Validator<T> {
    private Set<Reason> reasons = new HashSet<>();

    public void verify() {
        if (!reasons.isEmpty()) {
            throw new ValidationException(reasons.stream().map(Reason::getMessage).collect(Collectors.joining(", ")));
        }
    }

    public void addReason(Reason reason) {
        this.reasons.add(reason);
    }

    @Override
    public Validator<T> validate(T instance) {
        throw new NotImplementedException();
    }
}
