package br.com.cmaia.domain.validator.property;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.exception.ValidationException;
import java.util.Collections;

public class PropertyValidatorTest {
    private PropertyValidator propertyValidator;

    @Before
    public void setUp() {
        this.propertyValidator = new PropertyValidator();
    }

    @Test
    public void testValidateSuccess() {
        Property property = new Property();
        property.setId(1L);
        property.setBaths(1);
        property.setBeds(1);
        property.setDescription("abc");
        property.setSquareMeters(100.0d);
        property.setTitle("title");
        property.setX(10);
        property.setY(10);
        property.setProvinces(Collections.singleton(new Province()));

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithLessThanMinimumBedsShouldThrowValidationException() {
        Property property = new Property();
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));
        property.setSquareMeters(100.0d);
        property.setBeds(0);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithMoreThanMaximumBedsShouldThrowValidationException() {
        Property property = new Property();
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));
        property.setSquareMeters(100.0d);
        property.setBeds(10);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithLessThanMinimumBathsShouldThrowValidationException() {
        Property property = new Property();
        property.setProvinces(Collections.singleton(new Province()));
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(0);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithMoreThanMaximumBathsShouldThrowValidationException() {
        Property property = new Property();
        property.setProvinces(Collections.singleton(new Province()));
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(10);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithLessThanMinimumSquareMetersShouldThrowValidationException() {
        Property property = new Property();
        property.setProvinces(Collections.singleton(new Province()));
        property.setBeds(1);
        property.setBaths(1);
        property.setSquareMeters(10.0d);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithMoreThanMaximumSquareMetersShouldThrowValidationException() {
        Property property = new Property();
        property.setProvinces(Collections.singleton(new Province()));
        property.setBeds(1);
        property.setBaths(1);
        property.setSquareMeters(250.0d);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidateWithProvincesNullShouldThrowValidationException() {
        Property property = new Property();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);

        propertyValidator.validate(property).verify();
    }

    @Test(expected = ValidationException.class)
    public void testValidationWithProvincesEmptyShouldThrowValidationException() {
        Property property = new Property();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.emptySet());

        propertyValidator.validate(property).verify();
    }

}