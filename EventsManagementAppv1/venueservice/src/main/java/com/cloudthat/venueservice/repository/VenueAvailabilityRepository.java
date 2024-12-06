package com.cloudthat.venueservice.repository;

import com.cloudthat.venueservice.entity.VenueAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability, Long> {
}
