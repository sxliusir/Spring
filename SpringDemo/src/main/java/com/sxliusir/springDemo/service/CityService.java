package com.sxliusir.springDemo.service;

import com.sxliusir.springDemo.dao.CityDao;
import com.sxliusir.springDemo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CityService {

    @Autowired
    CityDao cityDao;

    public String save(City city) {
        try {
            cityDao.save(city);
            return "保存成功";
        } catch (Exception e) {
            return "保存失败";
        }
    }

    public List<City> getAll() {
        return cityDao.getAll();
    }

    public void del(Integer id) {
        cityDao.del(id);
    }
}
