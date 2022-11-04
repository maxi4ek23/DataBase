package com.platform.controller.impl;

import com.platform.controller.AdressController;
import com.platform.domain.Adress;
import com.platform.service.AdressService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class AdressControllerImpl implements AdressController {
    @Autowired
    AdressService adressService;

    @Override
    public List<Adress> findAll() {
        return adressService.findAll();
    }

    @Override
    public Optional<Adress> findById(Integer id) {
        return adressService.findById(id);
    }

    @Override
    public int create(Adress adress) {
        return adressService.create(adress);
    }

    @Override
    public int update(Integer id, Adress adress) {
        return adressService.update(id, adress);
    }

    @Override
    public int delete(Integer id) {
        return adressService.delete(id);
    }
}
