package com.platform.controller.impl;

import com.platform.controller.RegionController;
import com.platform.domain.Region;
import com.platform.service.RegionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class RegionControllerImpl implements RegionController {
    @Autowired
    RegionService regionService;

    @Override
    public List<Region> findAll() {
        return regionService.findAll();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return regionService.findById(id);
    }

    @Override
    public int create(Region region) {
        return regionService.create(region);
    }

    @Override
    public int update(Integer id, Region region) {
        return regionService.update(id, region);
    }

    @Override
    public int delete(Integer id) {
        return regionService.delete(id);
    }
}
