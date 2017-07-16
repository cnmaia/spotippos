package br.com.cmaia.domain.validator.property;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.exception.ValidationException;
import java.util.Collections;

public class CreatePropertyValidatorTest {

    private static CreatePropertyValidator createPropertyValidator;

    @BeforeClass
    public static void setUp() {
        createPropertyValidator = new CreatePropertyValidator();
    }

    @Test
    public void testValidateSuccess() {
        Property property = new Property();
        property.setBaths(1);
        property.setBeds(1);
        property.setDescription("abc");
        property.setSquareMeters(100);
        property.setTitle("title");
        property.setX(10);
        property.setY(10);
        property.setProvinces(Collections.singleton(new Province()));

        createPropertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithIdNotNullShouldThrowValidationException() {
        Property property = new Property();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));
        property.setId(1L);

        createPropertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithProvincesNullShouldThrowValidationException() {
        Property property = new Property();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);

        createPropertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidationWithProvincesEmptyShouldThrowValidationException() {
        Property property = new Property();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.emptySet());

        createPropertyValidator.validate(property).verify();
    }
}