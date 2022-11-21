package com.platform.controller.impl;

import com.platform.controller.CityController;
import com.platform.domain.City;
import com.platform.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CityControllerImpl implements CityController {
    @Autowired
    CityService cityService;

    @Override
    public List<City> findAll() {
        return cityService.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityService.findById(id);
    }

    @Override
    public int create(City city) {
        return cityService.create(city);
    }

    @Override
    public int update(Integer id, City city) {
        return cityService.update(id, city);
    }

    @Override
    public int delete(Integer id) {
        return cityService.delete(id);
    }
}
