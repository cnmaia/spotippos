package br.com.cmaia.service.resource.property;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class PropertySearchResultResource {
    private final Set<PropertyResource> propertyResources;

    public PropertySearchResultResource(Set<PropertyResource> propertyResources) {
        this.propertyResources = propertyResources;
    }

    @JsonProperty("foundProperties")
    public int foundProperties() {
        return this.propertyResources.size();
    }

    public Set<PropertyResource> getPropertyResources() {
        return propertyResources;
    }
}
