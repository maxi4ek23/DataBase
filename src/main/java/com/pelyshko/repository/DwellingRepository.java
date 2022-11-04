package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.Dwelling;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface DwellingRepository extends JpaRepository<Dwelling, Integer> {
}
