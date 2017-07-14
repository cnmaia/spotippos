package br.com.cmaia.repository;

import br.com.cmaia.domain.filter.PropertyFilter;
import br.com.cmaia.domain.model.Property;
import java.util.Optional;
import java.util.Set;

public interface PropertyRepository {
    Optional<Property> find(Long id);
    Property create(Property property);
    Set<Property> search(PropertyFilter filter);
}
