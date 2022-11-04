package com.platform.service.impl;

import com.platform.dao.PlatformUserDao;
import com.platform.domain.PlatformUser;
import com.platform.service.PlatformUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatformUserServiceImpl implements PlatformUserService {
    @Autowired
    private PlatformUserDao platformUserDao;

    @Override
    public List<PlatformUser> findAll() {
        return platformUserDao.findAll();
    }

    @Override
    public Optional<PlatformUser> findById(Integer id) {
        return platformUserDao.findById(id);
    }

    @Override
    public int create(PlatformUser platformUser) {
        return platformUserDao.create(platformUser);
    }

    @Override
    public int update(Integer id, PlatformUser platformUser) {
        return platformUserDao.update(id, platformUser);
    }

    @Override
    public int delete(Integer id) {
        return platformUserDao.delete(id);
    }
}
