package com.example.realEstatePropertyListingSystem.store.repositories;

import com.example.realEstatePropertyListingSystem.store.entities.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {

}
