package com.example.realEstatePropertyListingSystem.services;

import com.example.realEstatePropertyListingSystem.store.entities.RealtorEntity;
import com.example.realEstatePropertyListingSystem.store.repositories.RealtorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class RealtorService {
    private final RealtorRepository realtorRepository;

    @Autowired
    public RealtorService(RealtorRepository realtorRepository) {
        this.realtorRepository = realtorRepository;
    }

    public List<RealtorEntity> getAllRealtors() {
        return realtorRepository.findAll();
    }

    public RealtorEntity getRealtorById(@RequestParam Long id) {
        RealtorEntity realtor = realtorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Realtor not found with id: " + id));

        return realtor;
    }

    public RealtorEntity createRealtor(@RequestBody RealtorEntity realtor) {
        return realtorRepository.save(realtor);
    }

    public RealtorEntity updateRealtor(@RequestParam Long id, @RequestBody String phone) {
        RealtorEntity realtor = realtorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Realtor not found with id: " + id));

        realtor.setPhone(phone);
        return realtorRepository.save(realtor);
    }

    public void deleteRealtor(@RequestBody Long id) {
        realtorRepository.deleteById(id);
    }

}
