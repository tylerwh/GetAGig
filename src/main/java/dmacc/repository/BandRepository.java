package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Band;

@Repository
public interface BandRepository extends JpaRepository<Band, Long>{ }