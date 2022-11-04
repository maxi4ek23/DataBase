package com.pelyshko.repository;

import org.springframework.stereotype.Repository;
import com.pelyshko.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
