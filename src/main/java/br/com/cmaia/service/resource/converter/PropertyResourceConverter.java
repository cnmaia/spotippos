package br.com.cmaia.service.resource.converter;

import br.com.cmaia.domain.model.Property;
import br.com.cmaia.service.resource.ResourceConverter;
import br.com.cmaia.service.resource.property.PropertyResource;

public class PropertyResourceConverter implements ResourceConverter<Property, PropertyResource> {
    @Override
    public Property fromResource(PropertyResource resource) {
        return null;
    }

    @Override
    public PropertyResource toResource(Property entity) {
        return null;
    }
}
