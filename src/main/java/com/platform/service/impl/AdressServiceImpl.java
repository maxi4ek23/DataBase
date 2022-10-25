package com.platform.service.impl;

import com.platform.dao.AdressDao;
import com.platform.domain.Adress;
import com.platform.service.AdressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImpl implements AdressService {
    @Autowired
    private AdressDao adressDao;

    @Override
    public List<Adress> findAll() {
        return adressDao.findAll();
    }

    @Override
    public Optional<Adress> findById(Integer id) {
        return adressDao.findById(id);
    }

    @Override
    public int create(Adress adress) {
        return adressDao.create(adress);
    }

    @Override
    public int update(Integer id, Adress adress) {
        return adressDao.update(id, adress);
    }

    @Override
    public int delete(Integer id) {
        return adressDao.delete(id);
    }
}
