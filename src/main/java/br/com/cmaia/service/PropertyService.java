package br.com.cmaia.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;

public interface PropertyService {
    PropertyResource create(final PropertyResource resource);

    PropertyResource findById(final Long id);

    Page<PropertyResource> search(final PropertySearchResource resource, final Pageable pageable);
}
