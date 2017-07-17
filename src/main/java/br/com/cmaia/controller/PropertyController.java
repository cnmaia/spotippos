package br.com.cmaia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;
import br.com.cmaia.service.resource.property.PropertySearchResultResource;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PropertyResource> createProperty(@Valid @RequestBody PropertyResource resource) {
        return new ResponseEntity<>(this.propertyService.create(resource), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PropertySearchResultResource> searchProperty(@RequestParam("ax") int ax,
                                                                @RequestParam("ay") int ay,
                                                                @RequestParam("bx") int bx,
                                                                @RequestParam("by") int by,
                                                                Pageable pageable) {
        PropertySearchResource propertySearchResource = new PropertySearchResource(ax, ay, bx, by);

        return new ResponseEntity<>(this.propertyService.search(propertySearchResource, pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PropertyResource> findPropertyById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this.propertyService.findById(id), HttpStatus.OK);
    }

    // TODO Remove, test only purpose
    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    public ResponseEntity<Void> createBatchProperties(@RequestBody List<PropertyResource> resources) {
        resources.forEach(r -> this.propertyService.create(r));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
