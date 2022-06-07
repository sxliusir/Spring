package com.sxliusir.springDemo.dao;

import com.sxliusir.springDemo.domain.City;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CityDao {
    static Map<Integer, City> dataMap = Collections.synchronizedMap(new HashMap<Integer, City>());
    public void save(City city) throws Exception {
        City data = dataMap.get(city.getId());
        if (data != null) {
            throw new Exception("数据已存在");
        } else {
            dataMap.put(city.getId(),city);
        }
    }

    public List<City> getAll() {
        return new ArrayList<>(dataMap.values());
    }

    public void del(Integer id) {
        City remove = dataMap.remove(id);
    }
}
