package com.example.realEstatePropertyListingSystem.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.Instant;

@Entity
@Table(name="property")
public class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "realtor_id")
    private RealtorEntity realtor;
    @NotBlank
    private String address;
    private PropertyType type;
    @Positive
    @NotNull
    private double price;
    @Positive
    @NotNull
    private double area;
    @Positive
    @NotNull
    private int bedrooms;
    @Positive
    private int bathrooms;
    private Instant listingDate = Instant.now();

    public void setPrice(double price) {
        this.price = price;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
