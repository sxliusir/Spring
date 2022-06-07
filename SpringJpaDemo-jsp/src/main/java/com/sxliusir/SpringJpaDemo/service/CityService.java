package com.sxliusir.SpringJpaDemo.service;

import com.sxliusir.SpringJpaDemo.dao.CityRepository;
import com.sxliusir.SpringJpaDemo.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Component
public class CityService {
    @Autowired
    CityRepository cityRepository;
    public List<City> findAll() {
        return cityRepository.findAll();
    }
}
