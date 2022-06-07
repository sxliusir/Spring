package com.sxliusir.SpringJpaDemo.dao;

import com.sxliusir.SpringJpaDemo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
