package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Long>{ }