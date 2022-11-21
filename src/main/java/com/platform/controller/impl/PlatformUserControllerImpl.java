package com.platform.controller.impl;

import com.platform.controller.PlatformUserController;
import com.platform.domain.PlatformUser;
import com.platform.service.PlatformUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PlatformUserControllerImpl implements PlatformUserController {
    @Autowired
    PlatformUserService platformUserService;

    @Override
    public List<PlatformUser> findAll() {
        return platformUserService.findAll();
    }

    @Override
    public Optional<PlatformUser> findById(Integer id) {
        return platformUserService.findById(id);
    }

    @Override
    public int create(PlatformUser platformUser) {
        return platformUserService.create(platformUser);
    }

    @Override
    public int update(Integer id, PlatformUser platformUser) {
        return platformUserService.update(id, platformUser);
    }

    @Override
    public int delete(Integer id) {
        return platformUserService.delete(id);
    }
}
