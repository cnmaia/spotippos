package br.com.cmaia.domain.validator.property;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.validator.AbstractValidator;
import br.com.cmaia.domain.validator.Reason;
import br.com.cmaia.domain.validator.Validator;

public class PropertyValidator extends AbstractValidator<Property> {

    @Override
    public Validator<Property> validate(Property instance) {
        if (instance.getBeds() > 5 || instance.getBeds() < 1) {
            this.addReason(Reason.error("A property in Spotippos has at least 1 bed and a maximum of 5."));
        }

        if (instance.getBaths() > 4 || instance.getBaths() < 1) {
            this.addReason(Reason.error("A property in Spotippos has at least 1 bath and a maximum of 4."));
        }

        if (instance.getSquareMeters() > 240.0d || instance.getSquareMeters() < 20.0d) {
            this.addReason(Reason.error("A property in Spotippos has at least 20 square meters and a maximum of 240 square meters."));
        }

        if (instance.getProvinces() != null) {
            if (instance.getProvinces().isEmpty()) {
                this.addReason(Reason.error("There's no province for this property."));
            }
        } else {
            this.addReason(Reason.error("Could not calculate provinces for this property."));
        }

        return this;
    }
}
