package br.com.cmaia.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class PropertyTest {
    private static Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidationWithProvincesEmptyShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.emptySet());

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithNullProvincesShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(null);

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationExceedingMaximumSquareMetersShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(300.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumSquareMetersShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(5.0d);
        property.setBeds(1);
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationExceedingMaximumBathsShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(100.0d);
        property.setBeds(1);
        property.setBaths(10);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumSBathsShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(5.0d);
        property.setBeds(1);
        property.setBaths(0);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationExceedingMaximumBedsShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(300.0d);
        property.setBeds(10);
        property.setBaths(2);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }

    @Test
    public void testValidationWithLessThanMinimumBedsShouldHaveViolation() {
        Property property = new Property();
        property.setId(1L);
        property.setSquareMeters(5.0d);
        property.setBeds(0);
        property.setBaths(1);
        property.setProvinces(Collections.singleton(new Province()));

        Set<ConstraintViolation<Property>> violations = validator.validate(property);

        Assert.assertFalse(violations.isEmpty());
    }
}
