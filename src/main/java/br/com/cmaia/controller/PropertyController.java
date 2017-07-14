package br.com.cmaia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cmaia.service.PropertyService;
import br.com.cmaia.service.resource.property.PropertyResource;
import br.com.cmaia.service.resource.property.PropertySearchResource;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
    public ResponseEntity<PropertyResource> createProperty(@Valid @RequestBody PropertyResource resource) {
        this.propertyService.create(resource);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public ResponseEntity<PropertyResource> searchProperty(@RequestParam(value = "ax") int ax,
                                                           @RequestParam("ay") int ay,
                                                           @RequestParam("bx") int bx,
                                                           @RequestParam("by") int by) {
        PropertySearchResource propertySearchResource = new PropertySearchResource(ax, ay, bx, by);

        this.propertyService.search(propertySearchResource);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PropertyResource> findPropertyById(@PathVariable("id") Long id) {
        this.propertyService.findById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
