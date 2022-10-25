package com.platform.controller.impl;

import com.platform.controller.DwellingOwnerController;
import com.platform.domain.DwellingOwner;
import com.platform.service.DwellingOwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DwellingOwnerControllerImpl implements DwellingOwnerController {
    @Autowired
    DwellingOwnerService dwellingOwnerService;

    @Override
    public List<DwellingOwner> findAll() {
        return dwellingOwnerService.findAll();
    }

    @Override
    public Optional<DwellingOwner> findById(Integer id) {
        return dwellingOwnerService.findById(id);
    }

    @Override
    public int create(DwellingOwner dwellingOwner) {
        return dwellingOwnerService.create(dwellingOwner);
    }

    @Override
    public int update(Integer id, DwellingOwner dwellingOwner) {
        return dwellingOwnerService.update(id, dwellingOwner);
    }

    @Override
    public int delete(Integer id) {
        return dwellingOwnerService.delete(id);
    }
}
