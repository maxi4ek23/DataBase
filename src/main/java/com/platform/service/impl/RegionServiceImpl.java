package com.platform.service.impl;

import com.platform.dao.RegionDao;
import com.platform.domain.Region;
import com.platform.service.RegionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionDao regionDao;

    @Override
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Override
    public Optional<Region> findById(Integer id) {
        return regionDao.findById(id);
    }

    @Override
    public int create(Region region) {
        return regionDao.create(region);
    }

    @Override
    public int update(Integer id, Region region) {
        return regionDao.update(id, region);
    }

    @Override
    public int delete(Integer id) {
        return regionDao.delete(id);
    }
}
