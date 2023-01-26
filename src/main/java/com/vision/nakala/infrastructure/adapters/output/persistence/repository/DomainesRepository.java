package com.vision.nakala.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vision.nakala.infrastructure.adapters.output.persistence.entity.DomainesEntity;

@Repository
public interface DomainesRepository extends JpaRepository<DomainesEntity, Long> {

}