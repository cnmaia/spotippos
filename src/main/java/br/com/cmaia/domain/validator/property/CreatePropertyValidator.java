package br.com.cmaia.domain.validator.property;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.validator.AbstractValidator;
import br.com.cmaia.domain.validator.Reason;
import br.com.cmaia.domain.validator.Validator;

public class CreatePropertyValidator extends AbstractValidator<Property> {
    @Override
    public Validator<Property> validate(Property instance) {
        if (instance.getProvinces().isEmpty()) {
            this.addReason(Reason.error("There's no province for this property"));
        }

        return this;
    }
}
