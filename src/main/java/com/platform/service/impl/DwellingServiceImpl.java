package com.platform.service.impl;

import com.platform.dao.DwellingDao;
import com.platform.domain.Dwelling;
import com.platform.service.DwellingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DwellingServiceImpl implements DwellingService {
    @Autowired
    private DwellingDao dwellingDao;

    @Override
    public List<Dwelling> findAll() {
        return dwellingDao.findAll();
    }

    @Override
    public Optional<Dwelling> findById(Integer id) {
        return dwellingDao.findById(id);
    }

    @Override
    public int create(Dwelling dwelling) {
        return dwellingDao.create(dwelling);
    }

    @Override
    public int update(Integer id, Dwelling dwelling) {
        return dwellingDao.update(id, dwelling);
    }

    @Override
    public int delete(Integer id) {
        return dwellingDao.delete(id);
    }
}
