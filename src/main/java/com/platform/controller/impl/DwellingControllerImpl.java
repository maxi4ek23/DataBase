package com.platform.controller.impl;

import com.platform.controller.DwellingController;
import com.platform.domain.Dwelling;
import com.platform.service.DwellingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DwellingControllerImpl implements DwellingController {
    @Autowired
    DwellingService dwellingService;

    @Override
    public List<Dwelling> findAll() {
        return dwellingService.findAll();
    }

    @Override
    public Optional<Dwelling> findById(Integer id) {
        return dwellingService.findById(id);
    }

    @Override
    public int create(Dwelling dwelling) {
        return dwellingService.create(dwelling);
    }

    @Override
    public int update(Integer id, Dwelling dwelling) {
        return dwellingService.update(id, dwelling);
    }

    @Override
    public int delete(Integer id) {
        return dwellingService.delete(id);
    }
}
