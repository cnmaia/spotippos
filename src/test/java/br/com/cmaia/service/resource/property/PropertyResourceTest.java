package br.com.cmaia.service.resource.property;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class PropertyResourceTest {
    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidationExceedingMaximumSquareMetersShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(300.0d);
        property.setBeds(1);
        property.setBaths(1);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumSquareMetersShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(5.0d);
        property.setBeds(1);
        property.setBaths(1);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationExceedingMaximumBathsShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(10);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumSBathsShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(5.0d);
        property.setBeds(1);
        property.setBaths(0);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationExceedingMaximumBedsShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(300.0d);
        property.setBeds(10);
        property.setBaths(2);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumBedsShouldHaveViolation() {
        PropertyResource property = new PropertyResource();
        property.setSquareMeters(5.0d);
        property.setBeds(0);
        property.setBaths(1);

        Set<ConstraintViolation<PropertyResource>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }
}