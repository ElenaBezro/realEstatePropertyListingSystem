package com.example.realEstatePropertyListingSystem.api.controllers;

import com.example.realEstatePropertyListingSystem.services.PropertyService;
import com.example.realEstatePropertyListingSystem.store.entities.PropertyEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private PropertyService propertyService;

    @Autowired
    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping
    public List<PropertyEntity> getAllProperties() {
        return propertyService.getAllProperties();
    }

    @GetMapping("/{id}")
    public PropertyEntity getProperty(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @PostMapping
    public PropertyEntity createProperty(@Valid @RequestBody PropertyEntity property) {
        return propertyService.createProperty(property);
    }

    @PutMapping("/{id}")
    public PropertyEntity updateProperty(@PathVariable Long id, @Valid @RequestBody Double price) {
        return propertyService.updateProperty(id, price);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
    }
}
