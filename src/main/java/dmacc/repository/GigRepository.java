package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Gig;

@Repository
public interface GigRepository extends JpaRepository<Gig, Long>{ }