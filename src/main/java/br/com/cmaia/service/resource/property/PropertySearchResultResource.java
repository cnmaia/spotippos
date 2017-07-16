package br.com.cmaia.service.resource.property;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class PropertySearchResultResource {
    private final Set<PropertyResource> properties;

    public PropertySearchResultResource(Set<PropertyResource> properties) {
        this.properties = properties;
    }

    @JsonProperty("foundProperties")
    public int foundProperties() {
        return this.properties.size();
    }

    public Set<PropertyResource> getProperties() {
        return properties;
    }
}
