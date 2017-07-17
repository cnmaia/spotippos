package br.com.cmaia.service.resource.property;

import org.springframework.data.domain.PageImpl;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PagedPropertyResource extends PageImpl<PropertyResource> {

    private List<PropertyResource> properties;

    public PagedPropertyResource(List<PropertyResource> propertyResources) {
        super(propertyResources);
        this.properties = propertyResources;
    }

    @Override
    public List<PropertyResource> getContent() {
        return properties;
    }

    @JsonProperty("totalProperties")
    public int getTotalProperties() {
        return this.properties.size();
    }
}
