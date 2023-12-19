package com.example.realEstatePropertyListingSystem.api.controllers;

import com.example.realEstatePropertyListingSystem.services.RealtorService;
import com.example.realEstatePropertyListingSystem.store.entities.RealtorEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realtors")
public class RealtorController {
    private RealtorService realtorService;

    @Autowired
    public RealtorController(RealtorService realtorService) {
        this.realtorService = realtorService;
    }

    @GetMapping
    public List<RealtorEntity> getAllRealtors() {
        return realtorService.getAllRealtors();
    }

    @GetMapping("/{id}")
    public RealtorEntity getRealtor(@PathVariable Long id) {
        return realtorService.getRealtorById(id);
    }

    @PostMapping
    public RealtorEntity createRealtor(@Valid @RequestBody RealtorEntity realtor) {
        return realtorService.createRealtor(realtor);
    }

    @PutMapping("/{id}")
    public RealtorEntity updateRealtor(@PathVariable Long id, @Valid @RequestBody String phone) {
        return realtorService.updateRealtor(id, phone);
    }

    @DeleteMapping("/{id}")
    public void deleteRealtor(@PathVariable Long id) {
        realtorService.deleteRealtor(id);
    }
}
