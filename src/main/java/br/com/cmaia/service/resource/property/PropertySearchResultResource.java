package br.com.cmaia.service.resource.property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;

@JsonPropertyOrder({"foundProperties", "properties"})
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
