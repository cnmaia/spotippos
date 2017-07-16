package br.com.cmaia.service.resource.converter;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.domain.model.Province;
import br.com.cmaia.service.resource.ResourceConverter;
import br.com.cmaia.service.resource.property.PropertyResource;
import java.util.stream.Collectors;

public class PropertyResourceConverter implements ResourceConverter<Property, PropertyResource> {
    @Override
    public Property fromResource(PropertyResource resource) {
        if (resource == null)
            return null;

        Property property = new Property();

        property.setId(resource.getId());
        property.setBaths(resource.getBaths());
        property.setBeds(resource.getBeds());
        property.setDescription(resource.getDescription());
        property.setPrice(resource.getPrice());
        property.setSquareMeters(resource.getSquareMeters());
        property.setTitle(resource.getTitle());
        property.setX(resource.getX());
        property.setY(resource.getY());

        return property;
    }

    @Override
    public PropertyResource toResource(Property entity) {
        if (entity == null)
            return null;

        PropertyResource resource = new PropertyResource();

        resource.setId(entity.getId());
        resource.setBaths(entity.getBaths());
        resource.setBeds(entity.getBeds());
        resource.setDescription(entity.getDescription());
        resource.setPrice(entity.getPrice());
        resource.setSquareMeters(entity.getSquareMeters());
        resource.setTitle(entity.getTitle());
        resource.setX(entity.getX());
        resource.setY(entity.getY());
        resource.setProvinces(entity.getProvinces().stream().map(Province::getName).collect(Collectors.toSet()));

        return resource;
    }
}
