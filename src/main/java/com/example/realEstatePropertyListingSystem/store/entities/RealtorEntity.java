package com.example.realEstatePropertyListingSystem.store.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

@Entity
@Table(name = "realtor")
public class RealtorEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String name;
        @Email
        private String email;
        @Pattern(regexp = EntityConstants.PHONE_NUMBER_REGEXP)
        private String phone;
        @OneToMany(mappedBy = "realtor")
        private List<PropertyEntity> properties;

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPhone() {
                return phone;
        }

        public List<PropertyEntity> getProperties() {
                return properties;
        }

        public void setProperties(List<PropertyEntity> properties) {
                this.properties = properties;
        }
}
