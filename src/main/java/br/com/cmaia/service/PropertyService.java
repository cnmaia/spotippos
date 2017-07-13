package br.com.cmaia.service;

import java.util.List;

import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;

public interface PropertyService {
    void create(PropertyResource resource);

    PropertyResource findById(Long id);

    List<PropertyResource> search(PropertySearchResource resource);
}
