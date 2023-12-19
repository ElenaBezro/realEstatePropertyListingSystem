package com.example.realEstatePropertyListingSystem.services;

import com.example.realEstatePropertyListingSystem.store.entities.PropertyEntity;
import com.example.realEstatePropertyListingSystem.store.repositories.PropertyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Service
public class PropertyService {
    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyService(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    public List<PropertyEntity> getAllProperties() {
        return propertyRepository.findAll();
    }

    public PropertyEntity getPropertyById(@RequestParam Long id) {
        PropertyEntity property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with id: " + id));

        return property;
    }

    public PropertyEntity createProperty(@RequestBody PropertyEntity property) {
        return propertyRepository.save(property);
    }

    public PropertyEntity updateProperty(@RequestParam Long id, @RequestBody Double price) {
        PropertyEntity property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found with id: " + id));

        property.setPrice(price);
        return propertyRepository.save(property);
    }

    public void deleteProperty(@RequestBody Long id) {
        propertyRepository.deleteById(id);
    }
}
