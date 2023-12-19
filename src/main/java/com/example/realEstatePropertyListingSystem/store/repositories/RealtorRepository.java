package com.example.realEstatePropertyListingSystem.store.repositories;

import com.example.realEstatePropertyListingSystem.store.entities.RealtorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtorRepository extends JpaRepository<RealtorEntity, Long> {
}
