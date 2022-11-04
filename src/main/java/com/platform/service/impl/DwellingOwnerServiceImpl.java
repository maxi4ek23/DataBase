package com.platform.service.impl;

import com.platform.dao.DwellingOwnerDao;
import com.platform.domain.DwellingOwner;
import com.platform.service.DwellingOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DwellingOwnerServiceImpl implements DwellingOwnerService {
    @Autowired
    private DwellingOwnerDao dwellingOwnerDao;

    @Override
    public List<DwellingOwner> findAll() {
        return dwellingOwnerDao.findAll();
    }

    @Override
    public Optional<DwellingOwner> findById(Integer id) {
        return dwellingOwnerDao.findById(id);
    }

    @Override
    public int create(DwellingOwner dwellingOwner) {
        return dwellingOwnerDao.create(dwellingOwner);
    }

    @Override
    public int update(Integer id, DwellingOwner dwellingOwner) {
        return dwellingOwnerDao.update(id, dwellingOwner);
    }

    @Override
    public int delete(Integer id) {
        return dwellingOwnerDao.delete(id);
    }
}
