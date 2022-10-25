package com.platform.service.impl;

import com.platform.dao.LesseeDao;
import com.platform.domain.Lessee;
import com.platform.service.LesseeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LesseeServiceImpl implements LesseeService {
    @Autowired
    private LesseeDao lesseeDao;

    @Override
    public List<Lessee> findAll() {
        return lesseeDao.findAll();
    }

    @Override
    public Optional<Lessee> findById(Integer id) {
        return lesseeDao.findById(id);
    }

    @Override
    public int create(Lessee lessee) {
        return lesseeDao.create(lessee);
    }

    @Override
    public int update(Integer id, Lessee lessee) {
        return lesseeDao.update(id, lessee);
    }

    @Override
    public int delete(Integer id) {
        return lesseeDao.delete(id);
    }
}
